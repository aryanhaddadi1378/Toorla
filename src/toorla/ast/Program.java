package toorla.ast;

import toorla.ast.declaration.classDecs.ClassDeclaration;
import toorla.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class Program extends Tree {
    private ArrayList<ClassDeclaration> classes = new ArrayList<>();

    public void addClass(ClassDeclaration classDeclaration) {
        classes.add(classDeclaration);
    }

    public List<ClassDeclaration> getClasses() {
        return classes;
    }

    @Override
    public String toString() {
        return "Program";
    }

    public <R> R accept(IVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
