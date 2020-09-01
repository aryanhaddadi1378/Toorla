package toorla.compileErrorException.typeErrors;

import toorla.compileErrorException.CompileErrorException;

public class MainMethodNotFound extends CompileErrorException {
    public MainMethodNotFound(int line, int col) {
        this.atLine = line;
        this.atColumn = col;
    }

    @Override
    public String toString()
    {
        return String.format("Error:Line:%d:Entry class should have a main method " +
                "with no argument and int return type;" , atLine );
    }
}
