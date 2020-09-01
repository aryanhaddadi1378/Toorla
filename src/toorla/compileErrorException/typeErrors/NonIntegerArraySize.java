package toorla.compileErrorException.typeErrors;

import toorla.compileErrorException.CompileErrorException;

public class NonIntegerArraySize extends CompileErrorException {
    public NonIntegerArraySize( int line , int col )
    {
        this.atLine = line;
        this.atColumn = col;
    }

    @Override
    public String toString()
    {
        return String.format("Error:Line:%d:Size " +
                "of an array must be of type integer" , this.atLine );
    }
}
