package toorla.ast.declaration.classDecs;

import toorla.ast.expression.Identifier;
import toorla.visitor.IVisitor;

public class EntryClassDeclaration extends ClassDeclaration {
    public EntryClassDeclaration(Identifier name) {
        super(name);
    }

    public EntryClassDeclaration(Identifier name, Identifier parentName) {
        super(name, parentName);
    }

    @Override
    public <R> R accept(IVisitor<R> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "EntryClassDeclaration";
    }
}
