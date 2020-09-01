package toorla.symbolTable;

import toorla.symbolTable.exceptions.ItemAlreadyExistsException;
import toorla.symbolTable.exceptions.ItemNotFoundException;
import toorla.symbolTable.symbolTableItem.SymbolTableItem;
import toorla.utilities.stack.Stack;

import java.util.*;

public class SymbolTable {
    private SymbolTable pre;
    private Map<String, SymbolTableItem> items;

    // Static members region

    private static SymbolTable top;
    public static SymbolTable root;
    private static int mustBeUsedAfterDefCount = 0;

    private static Stack<SymbolTable> stack = new Stack<>();
    private static Queue<SymbolTable> queue = new LinkedList<>();

    public static SymbolTable top() {
        return top;
    }

    public static void pushFromQueue() {
        push(queue.remove());
    }

    public static void define()
    {
        mustBeUsedAfterDefCount++;
    }

    public static int getCountOfDefinedMustBeUsedAfterDefItems()
    {
        return mustBeUsedAfterDefCount;
    }

    public static void reset()
    {
        mustBeUsedAfterDefCount = 0;
    }
    public static void push(SymbolTable symbolTable) {
        if (top != null)
            stack.push(top);
        top = symbolTable;
        queue.offer(symbolTable);
    }

    public static void pop() {
        top = stack.pop();
    }

    // End of static members region

    public SymbolTable() {
        this(null);
    }

    public SymbolTable(SymbolTable pre) {
        this.pre = pre;
        this.items = new HashMap<>();
    }

    public void put(SymbolTableItem item) throws ItemAlreadyExistsException {
        if (items.containsKey(item.getKey()))
            throw new ItemAlreadyExistsException();
        items.put(item.getKey(), item);
    }

    public SymbolTableItem get(String key) throws ItemNotFoundException {
        Set<SymbolTable> visitedSymbolTables = new HashSet<>();
        return getSymbolTableItemInCurrentOrParents(key, visitedSymbolTables,this);
    }

    public SymbolTableItem getInParentScopes(String key) throws ItemNotFoundException {
        if (pre == null)
            throw new ItemNotFoundException();
        else
        {
            Set<SymbolTable> visitedSymbolTables = new HashSet<>();
            visitedSymbolTables.add(this);
            if( this.pre == this )
                throw new ItemNotFoundException();
            SymbolTable currentSymbolTable = this.pre;
            return getSymbolTableItemInCurrentOrParents(key, visitedSymbolTables, currentSymbolTable);
        }
    }

    private SymbolTableItem getSymbolTableItemInCurrentOrParents(String key, Set<SymbolTable> visitedSymbolTables, SymbolTable currentSymbolTable) throws ItemNotFoundException {
        do {
            visitedSymbolTables.add( currentSymbolTable );
            SymbolTableItem value = currentSymbolTable.items.get(key);
            if( value != null )
                if( value.getDefinitionNumber() <= SymbolTable.mustBeUsedAfterDefCount)
                    return value;
            currentSymbolTable = currentSymbolTable.getPreSymbolTable();
        } while( currentSymbolTable != null &&
                !visitedSymbolTables.contains( currentSymbolTable ) );
        throw new ItemNotFoundException();
    }

    public SymbolTable getPreSymbolTable() {
        return pre;
    }

    public void setPreSymbolTable(SymbolTable symbolTable) {
        pre = symbolTable;
    }
}
