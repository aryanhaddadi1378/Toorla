package toorla.compileErrorException.nameErrors;

import toorla.compileErrorException.CompileErrorException;

public class FieldNamedLengthDeclarationException extends CompileErrorException {
    public FieldNamedLengthDeclarationException(int atLine, int atColumn) {
        super("Definition of length as field of a class" , atLine, atColumn);
    }

}