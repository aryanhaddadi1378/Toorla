package toorla.ast.declaration;

import toorla.ast.expression.Identifier;

public abstract class VariableDeclaration extends Declaration {
    protected Identifier identifier;

    public Identifier getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }
}