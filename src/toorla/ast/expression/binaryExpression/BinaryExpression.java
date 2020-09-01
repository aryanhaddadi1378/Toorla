package toorla.ast.expression.binaryExpression;

import toorla.ast.expression.Expression;
import toorla.visitor.IVisitor;

public abstract class BinaryExpression extends Expression {
    protected Expression lhs;
    protected Expression rhs;

    public BinaryExpression(Expression lhs, Expression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public BinaryExpression() {
    }

    public Expression getLhs() {
        return lhs;
    }

    public void setLhs(Expression lhs) {
        this.lhs = lhs;
    }

    public Expression getRhs() {
        return rhs;
    }

    public void setRhs(Expression rhs) {
        this.rhs = rhs;
    }

    public void setSides(Expression lhs, Expression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public abstract <R> R accept(IVisitor<R> visitor);

}