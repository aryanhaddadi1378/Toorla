package toorla.ast.statement;

import toorla.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class Block extends Statement {
	public List<Statement> body;

	public Block() {
		body = new ArrayList<>();
	}

	public void addStatement(Statement s) {
		body.add(s);
	}

	public Block(List<Statement> body) {
		this.body = body;
	}

	public <R> R accept(IVisitor<R> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Block";
	}
}