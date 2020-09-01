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

public interface IVisitor<R> {
	// Expression
	R visit(Plus plusExpr);

	R visit(Minus minusExpr);

	R visit(Times timesExpr);

	R visit(Division divExpr);

	R visit(Modulo moduloExpr);

	R visit(Equals equalsExpr);

	R visit(GreaterThan gtExpr);

	R visit(LessThan lessThanExpr);

	R visit(And andExpr);

	R visit(Or orExpr);

	R visit(Neg negExpr);

	R visit(Not notExpr);

	R visit(MethodCall methodCall);

	R visit(Identifier identifier);

	R visit(Self self);

	R visit(IntValue intValue);

	R visit(NewArray newArray);

	R visit(BoolValue booleanValue);

	R visit(StringValue stringValue);

	R visit(NewClassInstance newClassInstance);

	R visit(FieldCall fieldCall);

	R visit(ArrayCall arrayCall);

	R visit(NotEquals notEquals);

	// Statement
	R visit(PrintLine printStat);

	R visit(Assign assignStat);

	R visit(Block block);

	R visit(Conditional conditional);

	R visit(While whileStat);

	R visit(Return returnStat);

	R visit(Break breakStat);

	R visit(Continue continueStat);

	R visit(Skip skip);

	R visit(LocalVarDef localVarDef);

	R visit(IncStatement incStatement);

	R visit(DecStatement decStatement);

	// declarations
	R visit(ClassDeclaration classDeclaration);

	R visit(EntryClassDeclaration entryClassDeclaration);

	R visit(FieldDeclaration fieldDeclaration);

	R visit(ParameterDeclaration parameterDeclaration);

	R visit(MethodDeclaration methodDeclaration);

	R visit(LocalVarsDefinitions localVarsDefinitions);

	R visit(Program program);

}