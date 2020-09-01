package toorla.ast.expression.binaryExpression;

import toorla.ast.expression.Expression;
import toorla.visitor.IVisitor;

public class LessThan extends BinaryExpression {

	public LessThan(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	public LessThan() {
		super(null, null);
	}

	@Override
	public <R> R accept(IVisitor<R> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Lt";
	}
}
