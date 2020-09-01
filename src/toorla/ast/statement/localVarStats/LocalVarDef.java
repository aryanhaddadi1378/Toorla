package toorla.ast.statement.localVarStats;

import toorla.ast.expression.Expression;
import toorla.ast.expression.Identifier;
import toorla.ast.statement.Statement;
import toorla.visitor.IVisitor;

public class LocalVarDef extends Statement {
    private Identifier localVarName;
    private Expression initialValue;

    public LocalVarDef(Identifier localVarName, Expression initialValue) {
        this.localVarName = localVarName;
        this.initialValue = initialValue;
    }

    public <R> R accept(IVisitor<R> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "localVarDef";
    }

    public Expression getInitialValue() {
        return initialValue;
    }

    public Identifier getLocalVarName() {
        return localVarName;
    }

}
