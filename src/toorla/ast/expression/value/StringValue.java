package toorla.ast.expression.value;

import toorla.types.Type;
import toorla.types.singleType.StringType;
import toorla.visitor.IVisitor;

public class StringValue extends Value {
    private String constant;

    public StringValue(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }

    @Override
    public Type getType() {
        return new StringType();
    }

    @Override
    public String toString() {
        return "(StringValue," + constant + ")";
    }

    @Override
    public <R> R accept(IVisitor<R> visitor) {
        return visitor.visit(this);
    }

}
