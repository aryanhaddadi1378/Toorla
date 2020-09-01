package toorla.ast.declaration.classDecs.classMembersDecs;

import toorla.ast.declaration.Declaration;
import toorla.ast.declaration.localVarDecs.ParameterDeclaration;
import toorla.ast.expression.Identifier;
import toorla.ast.statement.Statement;
import toorla.types.Type;
import toorla.visitor.IVisitor;

import java.util.ArrayList;

public class MethodDeclaration extends Declaration implements ClassMemberDeclaration {
    private Type returnType;
    private Identifier name;
    private AccessModifier accessModifier;
    private ArrayList<ParameterDeclaration> args = new ArrayList<>();
    private ArrayList<Statement> body = new ArrayList<>();

    public MethodDeclaration(Identifier name) {
        this.name = name;
        this.accessModifier = AccessModifier.ACCESS_MODIFIER_PUBLIC;
    }

    public Type getReturnType() {
        return returnType;
    }

    public void setReturnType(Type returnType) {
        this.returnType = returnType;
    }

    public void setAccessModifier(AccessModifier modifier) {
        this.accessModifier = modifier;
    }

    public AccessModifier getAccessModifier() {
        return this.accessModifier;
    }

    public Identifier getName() {
        return name;
    }

    public ArrayList<ParameterDeclaration> getArgs() {
        return args;
    }

    public void addArg(ParameterDeclaration arg) {
        this.args.add(arg);
    }

    public ArrayList<Statement> getBody() {
        return body;
    }

    public void addStatement(Statement statement) {
        this.body.add(statement);
    }

    @Override
    public String toString() {
        return "MethodDeclaration";
    }

    @Override
    public <R> R accept(IVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
