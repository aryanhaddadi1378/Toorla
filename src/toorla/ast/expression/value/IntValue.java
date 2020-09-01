package toorla.ast.expression.value;

import toorla.types.Type;
import toorla.types.singleType.IntType;
import toorla.visitor.IVisitor;

public class IntValue extends Value {
    private int constant;

    public IntValue(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }

    public void setConstant(int constant) {
        this.constant = constant;
    }

    @Override
    public Type getType() {
        return new IntType();
    }

    @Override
    public String toString() {
        return "(IntValue," + constant + ")";
    }

    @Override
    public <R> R accept(IVisitor<R> visitor) {
        return visitor.visit(this);
    }

}
