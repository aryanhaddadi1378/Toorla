package toorla.nameAnalyzer;

import toorla.ast.Program;
import toorla.ast.declaration.classDecs.ClassDeclaration;
import toorla.ast.declaration.classDecs.EntryClassDeclaration;
import toorla.ast.declaration.classDecs.classMembersDecs.ClassMemberDeclaration;
import toorla.ast.declaration.classDecs.classMembersDecs.FieldDeclaration;
import toorla.ast.declaration.classDecs.classMembersDecs.MethodDeclaration;
import toorla.ast.declaration.localVarDecs.ParameterDeclaration;
import toorla.ast.statement.Block;
import toorla.ast.statement.Conditional;
import toorla.ast.statement.Statement;
import toorla.ast.statement.While;
import toorla.ast.statement.localVarStats.LocalVarDef;
import toorla.ast.statement.localVarStats.LocalVarsDefinitions;
import toorla.compileErrorException.nameErrors.FieldRedefinitionException;
import toorla.compileErrorException.nameErrors.MethodRedefinitionException;
import toorla.symbolTable.SymbolTable;
import toorla.symbolTable.exceptions.ItemNotFoundException;
import toorla.symbolTable.symbolTableItem.MethodSymbolTableItem;
import toorla.symbolTable.symbolTableItem.SymbolTableItem;
import toorla.symbolTable.symbolTableItem.varItems.VarSymbolTableItem;
import toorla.visitor.Visitor;

public class NameCheckingPass extends Visitor<Void> implements INameAnalyzingPass<Void> {
    private ClassDeclaration currentClass;

    @Override
    public Void visit(Block block) {
        SymbolTable.pushFromQueue();
        for (Statement stmt : block.body)
            stmt.accept(this);
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(Conditional conditional) {
        SymbolTable.pushFromQueue();
        conditional.getThenStatement().accept(this);
        SymbolTable.pop();
        SymbolTable.pushFromQueue();
        conditional.getElseStatement().accept(this);
        SymbolTable.pop();
        return null;

    }

    @Override
    public Void visit(While whileStat) {
        SymbolTable.pushFromQueue();
        whileStat.body.accept(this);
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(ClassDeclaration classDeclaration) {
        SymbolTable.pushFromQueue();
        currentClass = classDeclaration;
        for (ClassMemberDeclaration cmd : classDeclaration.getClassMembers())
            cmd.accept(this);
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(EntryClassDeclaration entryClassDeclaration) {
        this.visit((ClassDeclaration) entryClassDeclaration);
        return null;
    }

    @Override
    public Void visit(FieldDeclaration fieldDeclaration) {
        if (!fieldDeclaration.hasError())
            try {
                SymbolTableItem sameFieldInParents = SymbolTable.top().getInParentScopes(
                        VarSymbolTableItem.var_modifier + fieldDeclaration.getIdentifier().getName());
                FieldRedefinitionException e = new FieldRedefinitionException(
                        fieldDeclaration.getIdentifier().getName(), fieldDeclaration.line, fieldDeclaration.col);
                fieldDeclaration.addError(e);
            } catch (ItemNotFoundException ignored) {
            }
        return null;
    }

    @Override
    public Void visit(MethodDeclaration methodDeclaration) {
        if (!methodDeclaration.hasError())
            try {
                SymbolTableItem sameMethodInParents = SymbolTable.top().getInParentScopes(
                        MethodSymbolTableItem.methodModifier + methodDeclaration.getName().getName());
                MethodRedefinitionException e = new MethodRedefinitionException(methodDeclaration.getName().getName(),
                        methodDeclaration.getName().line, methodDeclaration.getName().col);
                methodDeclaration.addError(e);
            } catch (ItemNotFoundException ignored) {
            }
        SymbolTable.pushFromQueue();
        for (ParameterDeclaration pd : methodDeclaration.getArgs())
            pd.accept(this);
        for (Statement stmt : methodDeclaration.getBody())
            stmt.accept(this);
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(LocalVarsDefinitions localVarsDefinitions) {
        for (LocalVarDef lvd : localVarsDefinitions.getVarDefinitions()) {
            lvd.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Program program) {
        SymbolTable.pushFromQueue();
        for (ClassDeclaration cd : program.getClasses()) {
            cd.accept(this);
        }
        SymbolTable.pop();
        return null;
    }

    @Override
    public void analyze(Program program) {
        currentClass = null;
        this.visit(program);
    }

    @Override
    public Void getResult() {
        return null;
    }
}
