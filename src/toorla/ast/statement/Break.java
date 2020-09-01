package toorla.ast.statement;

import toorla.visitor.IVisitor;

public class Break extends Statement {

    public <R> R accept(IVisitor<R> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "(Break)";
    }
}