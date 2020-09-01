package toorla.ast.expression.value;

import toorla.ast.expression.Expression;
import toorla.types.Type;
import toorla.visitor.IVisitor;

public abstract class Value extends Expression {
    abstract public Type getType();

    protected Type type;

    public abstract String toString();

    public abstract <R> R accept(IVisitor<R> visitor);
}