package toorla.compileErrorException.nameErrors;

import toorla.compileErrorException.CompileErrorException;

public class FieldRedefinitionException extends CompileErrorException {

    public FieldRedefinitionException(String name, int atLine, int atColumn) {
        super(String.format("Redefinition of Field %s", name )
                ,atLine, atColumn);
    }


}