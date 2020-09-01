package toorla.ast.expression.value;

import toorla.types.Type;
import toorla.types.singleType.BoolType;
import toorla.visitor.IVisitor;

public class BoolValue extends Value {
    private boolean constant;

    public BoolValue(boolean constant) {
        this.constant = constant;

    }

    public boolean isConstant() {
        return constant;
    }

    public void setConstant(boolean constant) {
        this.constant = constant;
    }

    @Override
    public Type getType() {
        return new BoolType();
    }

    @Override
    public String toString() {
        return "(BoolValue," + constant + ")";
    }

    @Override
    public <R> R accept(IVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
