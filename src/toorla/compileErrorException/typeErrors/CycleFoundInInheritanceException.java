package toorla.compileErrorException.typeErrors;

import toorla.compileErrorException.CompileErrorException;

public class CycleFoundInInheritanceException extends CompileErrorException {

    private String className;
    private String parentClassName;

    public CycleFoundInInheritanceException(int line , int col , String className , String parentName )
    {
        this.atLine = line;
        this.atColumn = col;
        this.className= className;
        this.parentClassName = parentName;
    }

    @Override
    public String toString()
    {
        return String.format("Error:Line:%d:Link %s - %s creates a cycle in inheritance"
            , atLine , className , parentClassName);
    }
}
