package toorla.ast.statement.returnStatement;

import toorla.ast.expression.Expression;
import toorla.ast.statement.Statement;
import toorla.visitor.IVisitor;

public class Return extends Statement {
    private Expression returnedExpr;

    public Return(Expression returnedExpr) {
        this.returnedExpr = returnedExpr;
    }

    public Expression getReturnedExpr() {
        return returnedExpr;
    }

    @Override
    public <R> R accept(IVisitor<R> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Return";
    }
}
