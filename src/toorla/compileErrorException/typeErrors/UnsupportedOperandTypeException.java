package toorla.compileErrorException.typeErrors;

import toorla.ast.expression.Expression;
import toorla.compileErrorException.CompileErrorException;

public class UnsupportedOperandTypeException extends CompileErrorException {
    private Expression expression;
    public UnsupportedOperandTypeException(Expression expression)
    {
        this.expression = expression;
    }
    @Override
    public String toString()
    {
        return String.format("Error:Line:%d:Unsupported operand types for %s;"
                , expression.line , expression.toString() );
    }
}
