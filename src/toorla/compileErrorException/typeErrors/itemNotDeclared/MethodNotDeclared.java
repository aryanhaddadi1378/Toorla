package toorla.compileErrorException.typeErrors.itemNotDeclared;

import toorla.compileErrorException.CompileErrorException;

public class MethodNotDeclared extends CompileErrorException {
    private String methodName;
    private String className;
    public MethodNotDeclared( String methodName , String className , int line , int col)
    {
        this.methodName = methodName;
        this.className = className;
        this.atLine = line;
        this.atColumn = col;
    }

    @Override
    public String toString()
    {
        return String.format("Error:Line:%d:There is no Method with name %s" +
                " with such parameters in class %s;", atLine, methodName , className
        );
    }
}
