package toorla.compileErrorException.nameErrors;

import toorla.ast.declaration.classDecs.ClassDeclaration;
import toorla.ast.expression.Identifier;
import toorla.compileErrorException.CompileErrorException;
import toorla.symbolTable.SymbolTable;
import toorla.symbolTable.exceptions.ItemAlreadyExistsException;
import toorla.symbolTable.symbolTableItem.ClassSymbolTableItem;

public class ClassRedefinitionException extends CompileErrorException {
    private ClassDeclaration classDeclaration;
    private int seenClassesNum;
    private String oldName;

    public ClassRedefinitionException(ClassDeclaration classDeclaration , int seenClassesNum ) {
        super(String.format("Redefinition of Class %s", classDeclaration.getName().getName())
                ,classDeclaration.getName().line, classDeclaration.getName().col);
        this.classDeclaration = classDeclaration;
        this.seenClassesNum = seenClassesNum;
        this.oldName = classDeclaration.getName().getName();
    }


    public void handle()
    {
        String newClassName = "$"
                + seenClassesNum + oldName;
        ClassSymbolTableItem thisClass = new ClassSymbolTableItem( newClassName );
        thisClass.setSymbolTable( SymbolTable.top() );
        thisClass.setParentSymbolTable(SymbolTable.top().getPreSymbolTable());
        Identifier newClassIdentifier = new Identifier( newClassName );
        newClassIdentifier.line = atLine;
        newClassIdentifier.col = atColumn;
        try
        {
            SymbolTable.root.put( thisClass );
            classDeclaration.setName( newClassIdentifier );
        }
        catch( ItemAlreadyExistsException itemAlreadyExists ) {
            itemAlreadyExists.printStackTrace();
        }
    }
}