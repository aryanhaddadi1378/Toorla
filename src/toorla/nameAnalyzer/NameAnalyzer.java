package toorla.nameAnalyzer;


import toorla.ast.Program;
import toorla.symbolTable.SymbolTable;
import toorla.symbolTable.exceptions.ItemAlreadyExistsException;
import toorla.symbolTable.symbolTableItem.ClassSymbolTableItem;
import toorla.utilities.graph.Graph;

public class NameAnalyzer {
    private Program program;
    private Graph<String> classHierarchy;

    public NameAnalyzer(Program p) {
        program = p;
    }

    public void analyze() {
        NameCollectionPass nameCollectionPass = new NameCollectionPass();
        ClassParentshipExtractorPass classParentshipExtractorPass = new ClassParentshipExtractorPass();
        NameCheckingPass nameCheckingPass = new NameCheckingPass();
        prepare();
        nameCollectionPass.analyze(program);
        classParentshipExtractorPass.analyze(program);
        nameCheckingPass.analyze(program);
        classHierarchy = classParentshipExtractorPass.getResult();

    }

    private void prepare() {
        SymbolTable.root = new SymbolTable();
        ClassSymbolTableItem classAnySymbolTableItem = new ClassSymbolTableItem("Any");
        classAnySymbolTableItem.setSymbolTable(new SymbolTable(SymbolTable.root));
        try {
            SymbolTable.root.put(classAnySymbolTableItem);
        } catch (ItemAlreadyExistsException ignored) {
        }
        SymbolTable.push(classAnySymbolTableItem.getSymbolTable());
    }

    public Graph<String> getClassHierarchy() {
        return classHierarchy;
    }
}