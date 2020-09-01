package toorla.ast.expression.binaryExpression;

import toorla.ast.expression.Expression;
import toorla.visitor.IVisitor;

public class And extends BinaryExpression {
	public And(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public <R> R accept(IVisitor<R> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "And";
	}
}
