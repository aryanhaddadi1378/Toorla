package toorla.ast.expression;

import toorla.visitor.IVisitor;

public class ArrayCall extends Expression {
    private Expression instance;
    private Expression index;

    public ArrayCall(Expression instance, Expression index) {
        this.instance = instance;
        this.index = index;
    }

    public Expression getIndex() {
        return index;
    }

    public Expression getInstance() {
        return instance;
    }

    @Override
    public <R> R accept(IVisitor<R> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "ArrayCall";
    }

    @Override
    public boolean isLvalue()
    {
        return true;
    }

}
