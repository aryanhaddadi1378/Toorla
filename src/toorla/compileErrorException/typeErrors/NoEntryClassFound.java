package toorla.compileErrorException.typeErrors;

import toorla.compileErrorException.CompileErrorException;

public class NoEntryClassFound extends CompileErrorException {
    public NoEntryClassFound()
    {

    }

    @Override
    public String toString()
    {
        return "Error:No entry class Found in source code;";
    }
}
