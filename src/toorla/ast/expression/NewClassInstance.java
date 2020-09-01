package toorla.ast.expression;

import toorla.visitor.IVisitor;

public class NewClassInstance extends Expression {
    private Identifier className;

    public NewClassInstance(Identifier className) {
        this.className = className;
    }

    public Identifier getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return "NewClass";
    }

    public <R> R accept(IVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
