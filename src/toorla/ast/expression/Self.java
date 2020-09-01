package toorla.ast.expression;

import toorla.visitor.IVisitor;

public class Self extends Expression {

    @Override
    public String toString() {
        return "(Self)";
    }

    @Override
    public <R> R accept(IVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
