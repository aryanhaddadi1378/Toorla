package toorla.compileErrorException.typeErrors.itemNotDeclared;

import toorla.compileErrorException.CompileErrorException;

public class FieldNotDeclared extends CompileErrorException {
    private String fieldName;
    private String className;
    public FieldNotDeclared( String fieldName , String className , int line , int col)
    {
        this.fieldName = fieldName;
        this.className = className;
        this.atLine = line;
        this.atColumn = col;
    }

    @Override
    public String toString()
    {
        return String.format("Error:Line:%d:There is " +
                "no Field with name %s in class %s;", atLine, fieldName , className
        );
    }
}
