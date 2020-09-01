package toorla.visitor;

import toorla.ast.Program;
import toorla.ast.declaration.classDecs.ClassDeclaration;
import toorla.ast.declaration.classDecs.EntryClassDeclaration;
import toorla.ast.declaration.classDecs.classMembersDecs.FieldDeclaration;
import toorla.ast.declaration.classDecs.classMembersDecs.MethodDeclaration;
import toorla.ast.declaration.localVarDecs.ParameterDeclaration;
import toorla.ast.expression.*;
import toorla.ast.expression.binaryExpression.*;
import toorla.ast.expression.unaryExpression.Neg;
import toorla.ast.expression.unaryExpression.Not;
import toorla.ast.expression.value.BoolValue;
import toorla.ast.expression.value.IntValue;
import toorla.ast.expression.value.StringValue;
import toorla.ast.statement.*;
import toorla.ast.statement.localVarStats.LocalVarDef;
import toorla.ast.statement.localVarStats.LocalVarsDefinitions;
import toorla.ast.statement.returnStatement.Return;

public class Visitor<R> implements IVisitor<R> {
    // Expression
    public R visit(Plus plusExpr) {
        return null;
    }

    public R visit(Minus minusExpr) {
        return null;
    }

    public R visit(Times timesExpr) {
        return null;
    }

    public R visit(Division divExpr) {
        return null;
    }

    public R visit(Modulo moduloExpr) {
        return null;
    }

    public R visit(Equals equalsExpr) {
        return null;
    }

    public R visit(GreaterThan gtExpr) {
        return null;
    }

    public R visit(LessThan lessThanExpr) {
        return null;
    }

    public R visit(And andExpr) {
        return null;
    }

    public R visit(Or orExpr) {
        return null;
    }

    public R visit(Neg negExpr) {
        return null;
    }

    public R visit(Not notExpr) {
        return null;
    }

    public R visit(MethodCall methodCall) {
        return null;
    }

    public R visit(Identifier identifier) {
        return null;
    }

    public R visit(Self self) {
        return null;
    }

    public R visit(IntValue intValue) {
        return null;
    }

    public R visit(NewArray newArray) {
        return null;
    }

    public R visit(BoolValue booleanValue) {
        return null;
    }

    public R visit(StringValue stringValue) {
        return null;
    }

    public R visit(NewClassInstance newClassInstance) {
        return null;
    }

    public R visit(FieldCall fieldCall) {
        return null;
    }

    public R visit(ArrayCall arrayCall) {
        return null;
    }

    public R visit(NotEquals notEquals) {
        return null;
    }

    // Statement
    public R visit(PrintLine printStat) {
        return null;
    }

    public R visit(Assign assignStat) {
        return null;
    }

    public R visit(Block block) {
        return null;
    }

    public R visit(Conditional conditional) {
        return null;
    }

    public R visit(While whileStat) {
        return null;
    }

    public R visit(Return returnStat) {
        return null;
    }

    public R visit(Break breakStat) {
        return null;
    }

    public R visit(Continue continueStat) {
        return null;
    }

    public R visit(Skip skip) {
        return null;
    }

    public R visit(LocalVarDef localVarDef) {
        return null;
    }

    public R visit(IncStatement incStatement) {
        return null;
    }

    public R visit(DecStatement decStatement) {
        return null;
    }

    // declarations
    public R visit(ClassDeclaration classDeclaration) {
        return null;
    }

    public R visit(EntryClassDeclaration entryClassDeclaration) {
        return null;
    }

    public R visit(FieldDeclaration fieldDeclaration) {
        return null;
    }

    public R visit(ParameterDeclaration parameterDeclaration) {
        return null;
    }

    public R visit(MethodDeclaration methodDeclaration) {
        return null;
    }

    public R visit(LocalVarsDefinitions localVarsDefinitions) {
        return null;
    }

    public R visit(Program program) {
        return null;
    }

}