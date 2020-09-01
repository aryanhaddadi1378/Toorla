package toorla.compileErrorException.typeErrors.itemNotDeclared;

import toorla.compileErrorException.CompileErrorException;

public class ClassNotDeclaredException extends CompileErrorException {
    private String className;
    public ClassNotDeclaredException(String className, int line , int col)
    {
        this.className = className;
        this.atLine = line;
        this.atColumn = col;
    }

    @Override
    public String toString()
    {
        return String.format("Error:Line:%d:There is " +
                        "no class with name %s;", atLine
                , className);
    }
}
