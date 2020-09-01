package toorla.ast.declaration.localVarDecs;

import toorla.ast.declaration.TypedVariableDeclaration;
import toorla.ast.expression.Identifier;
import toorla.types.Type;
import toorla.visitor.IVisitor;

public class ParameterDeclaration extends TypedVariableDeclaration {
    public ParameterDeclaration(Identifier name, Type type) {
        this.identifier = name;
        this.type = type;
    }

    @Override
    public <R> R accept(IVisitor<R> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Parameter";
    }
}