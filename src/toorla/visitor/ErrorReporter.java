package toorla.visitor;

import toorla.ast.Program;
import toorla.ast.Tree;
import toorla.ast.declaration.classDecs.ClassDeclaration;
import toorla.ast.declaration.classDecs.EntryClassDeclaration;
import toorla.ast.declaration.classDecs.classMembersDecs.ClassMemberDeclaration;
import toorla.ast.declaration.classDecs.classMembersDecs.FieldDeclaration;
import toorla.ast.declaration.classDecs.classMembersDecs.MethodDeclaration;
import toorla.ast.declaration.localVarDecs.ParameterDeclaration;
import toorla.ast.expression.*;
import toorla.ast.expression.binaryExpression.*;
import toorla.ast.expression.unaryExpression.Neg;
import toorla.ast.expression.unaryExpression.Not;
import toorla.ast.expression.unaryExpression.UnaryExpression;
import toorla.ast.expression.value.BoolValue;
import toorla.ast.expression.value.IntValue;
import toorla.ast.expression.value.StringValue;
import toorla.ast.statement.*;
import toorla.ast.statement.localVarStats.LocalVarDef;
import toorla.ast.statement.localVarStats.LocalVarsDefinitions;
import toorla.ast.statement.returnStatement.Return;
import toorla.compileErrorException.CompileErrorException;

import java.util.List;

public class ErrorReporter extends Visitor<Integer> {

    private Integer report(BinaryExpression binaryExpression)
    {
        int numOfErrors = printErrors(binaryExpression);
        numOfErrors += binaryExpression.getLhs().accept(this);
        numOfErrors += binaryExpression.getRhs().accept(this);
        return numOfErrors;
    }

    private Integer printErrors(Tree treeNode)
    {
        List<CompileErrorException> errors = treeNode.flushErrors();
        int numOfErrors = errors.size();
        for (CompileErrorException e : errors) {
            System.out.println(e);
        }
        return numOfErrors;
    }
    private Integer report(UnaryExpression unaryExpression)
    {
        List<CompileErrorException> errors = unaryExpression.flushErrors();
        int numOfErrors = errors.size();
        for(CompileErrorException e: errors )
            System.out.println(e);
        numOfErrors += unaryExpression.getExpr().accept(this);
        return numOfErrors;
    }

    @Override
    public Integer visit(Block block) {
        int numOfErrors = printErrors(block);
        for (Statement stmt : block.body)
            numOfErrors += stmt.accept(this);
        return numOfErrors;
    }

    @Override
    public Integer visit(Conditional conditional) {
        int numOfErrors = printErrors(conditional);
        numOfErrors += conditional.getCondition().accept(this);
        numOfErrors += conditional.getThenStatement().accept(this);
        numOfErrors += conditional.getElseStatement().accept(this);
        return numOfErrors;
    }

    @Override
    public Integer visit(While whileStat) {
        int numOfErrors = printErrors(whileStat);
        numOfErrors += whileStat.expr.accept(this);
        numOfErrors += whileStat.body.accept(this);
        return numOfErrors;
    }

    @Override
    public Integer visit(LocalVarDef localVarDef) {
        int numOfErrors = printErrors(localVarDef);
        numOfErrors += localVarDef.getInitialValue().accept(this);
        return numOfErrors;
    }

    @Override
    public Integer visit(ClassDeclaration classDeclaration) {
        int numOfErrors = printErrors(classDeclaration);
        for (ClassMemberDeclaration cmd : classDeclaration.getClassMembers())
            numOfErrors += cmd.accept(this);
        return numOfErrors;
    }

    @Override
    public Integer visit(EntryClassDeclaration entryClassDeclaration) {
        return this.visit((ClassDeclaration) entryClassDeclaration);
    }

    @Override
    public Integer visit(FieldDeclaration fieldDeclaration) {
        return printErrors(fieldDeclaration);
    }

    @Override
    public Integer visit(ParameterDeclaration parameterDeclaration) {
        return printErrors(parameterDeclaration);
    }

    @Override
    public Integer visit(MethodDeclaration methodDeclaration) {
        int numOfErrors = printErrors(methodDeclaration);
        for (ParameterDeclaration pd : methodDeclaration.getArgs())
            numOfErrors += pd.accept(this);
        for (Statement stmt : methodDeclaration.getBody())
            numOfErrors += stmt.accept(this);
        return numOfErrors;
    }

    @Override
    public Integer visit(LocalVarsDefinitions localVarsDefinitions) {
        int numOfErrors = 0;
        for (LocalVarDef lvd : localVarsDefinitions.getVarDefinitions()) {
            numOfErrors += lvd.accept(this);
        }
        return numOfErrors;
    }

    @Override
    public Integer visit(Program program) {
        int numOfErrors = printErrors(program);
        for (ClassDeclaration cd : program.getClasses()) {
            numOfErrors += cd.accept(this);
        }
        return numOfErrors;
    }
    public Integer visit(Plus plusExpr) {
        return report(plusExpr);
    }

    public Integer visit(Minus minusExpr) {
        return report(minusExpr);
    }

    public Integer visit(Times timesExpr) {
        return report(timesExpr);
    }

    public Integer visit(Division divExpr) {
        return report(divExpr);
    }

    public Integer visit(Modulo moduloExpr) {
        return report(moduloExpr);
    }

    public Integer visit(Equals equalsExpr) {
        return report(equalsExpr);
    }

    public Integer visit(GreaterThan gtExpr) {
        return report(gtExpr);
    }

    public Integer visit(LessThan lessThanExpr) {
        return report(lessThanExpr);
    }

    public Integer visit(And andExpr) {
        return report(andExpr);
    }

    public Integer visit(Or orExpr) {
        return report(orExpr);
    }

    public Integer visit(Neg negExpr) {
        return report(negExpr);
    }

    public Integer visit(Not notExpr) {
        return report(notExpr);
    }

    public Integer visit(MethodCall methodCall) {
        int numOfErrors = printErrors(methodCall);
        numOfErrors += methodCall.getInstance().accept(this);
        return numOfErrors;
    }

    public Integer visit(Identifier identifier) {
        return printErrors(identifier);
    }

    public Integer visit(Self self) {
        return 0;
    }

    public Integer visit(IntValue intValue) {
        return 0;
    }

    public Integer visit(NewArray newArray) {
        int numOfErrors = printErrors(newArray);
        numOfErrors += newArray.getLength().accept(this);
        return numOfErrors;
    }

    public Integer visit(BoolValue booleanValue) {
        return 0;
    }

    public Integer visit(StringValue stringValue) {
        return 0;
    }

    public Integer visit(NewClassInstance newClassInstance) {
        return printErrors(newClassInstance);
    }

    public Integer visit(FieldCall fieldCall) {
        int numOfErrors = printErrors(fieldCall);
        numOfErrors += fieldCall.getInstance().accept(this);
        return numOfErrors;
    }

    public Integer visit(ArrayCall arrayCall) {
        int numOfErrors = printErrors(arrayCall);
        numOfErrors += arrayCall.getInstance().accept(this);
        numOfErrors += arrayCall.getIndex().accept(this);
        return numOfErrors;
    }

    public Integer visit(NotEquals notEquals) {
        return report(notEquals);
    }

    public Integer visit(PrintLine printStat) {
        int numOfErrors = printErrors(printStat);
        numOfErrors += printStat.getArg().accept(this);
        return numOfErrors;
    }

    public Integer visit(Assign assignStat) {
        int numOfErrors = printErrors(assignStat);
        numOfErrors += assignStat.getLvalue().accept(this);
        numOfErrors += assignStat.getRvalue().accept(this);
        return numOfErrors;
    }




    public Integer visit(Return returnStat) {
        int numOfErrors = printErrors(returnStat);
        numOfErrors += returnStat.getReturnedExpr().accept(this);
        return numOfErrors;
    }

    public Integer visit(Break breakStat) {
        return printErrors(breakStat);
    }

    public Integer visit(Continue continueStat) {
        return printErrors(continueStat);
    }

    public Integer visit(Skip skip) {
        return 0;
    }


    public Integer visit(IncStatement incStatement) {
        int numOfErrors = printErrors(incStatement);
        numOfErrors += incStatement.getOperand().accept(this);
        return numOfErrors;
    }

    public Integer visit(DecStatement decStatement) {
        int numOfErrors = printErrors(decStatement);
        numOfErrors += decStatement.getOperand().accept(this);
        return numOfErrors;
    }







}
