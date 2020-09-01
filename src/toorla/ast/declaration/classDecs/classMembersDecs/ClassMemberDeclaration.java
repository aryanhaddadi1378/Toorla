package toorla.ast.declaration.classDecs.classMembersDecs;

import toorla.visitor.IVisitor;

public interface ClassMemberDeclaration {
    <R> R accept(IVisitor<R> visitor);

    String toString();

}