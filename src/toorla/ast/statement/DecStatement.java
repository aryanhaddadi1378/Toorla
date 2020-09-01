package toorla.ast.statement;

import toorla.ast.expression.Expression;
import toorla.visitor.IVisitor;

public class DecStatement extends Statement {
    private Expression operand;

    public DecStatement(Expression operand) {
        this.operand = operand;
    }

    @Override
    public <R> R accept(IVisitor<R> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "DecStat";
    }

    public Expression getOperand() {
        return operand;
    }

}
