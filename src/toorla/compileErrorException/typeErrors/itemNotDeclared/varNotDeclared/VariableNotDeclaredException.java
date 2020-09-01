package toorla.compileErrorException.typeErrors.itemNotDeclared.varNotDeclared;

import toorla.compileErrorException.CompileErrorException;

public class VariableNotDeclaredException extends CompileErrorException {
    private String varName;
    public VariableNotDeclaredException(String varName, int line , int col)
    {
        this.varName = varName;
        this.atLine = line;
        this.atColumn = col;
    }

    @Override
    public String toString()
    {
        return String.format("Error:Line:%d:Variable %s " +
                        "is not declared yet in this Scope;", atLine, varName
                );
    }
}
