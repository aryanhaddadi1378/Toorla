package toorla.nameAnalyzer;

import toorla.ast.Program;
import toorla.ast.declaration.classDecs.ClassDeclaration;
import toorla.symbolTable.SymbolTable;
import toorla.symbolTable.exceptions.ItemNotFoundException;
import toorla.symbolTable.symbolTableItem.ClassSymbolTableItem;
import toorla.utilities.graph.Graph;
import toorla.utilities.graph.GraphDoesNotContainNodeException;
import toorla.utilities.graph.NodeAlreadyExists;

public class ClassParentshipExtractorPass implements INameAnalyzingPass<Graph<String>> {
    private Graph<String> inheritanceGraph;

    public ClassParentshipExtractorPass() {
        inheritanceGraph = new Graph<>();
    }

    @Override
    public void analyze(Program program) {
        try {
            inheritanceGraph.addNode("Any");
        } catch (NodeAlreadyExists ignored) {
            System.out.println("code error:it must not come here.");
        }
        for (ClassDeclaration cd : program.getClasses()) {
            String className = cd.getName().getName();
            try {
                inheritanceGraph.addNode(className);
            } catch (NodeAlreadyExists ignored) {
            }
            if (cd.getParentName().getName() == null) {
                try {
                    inheritanceGraph.addNodeAsParentOf(className, "Any");
                } catch (GraphDoesNotContainNodeException ignored) {
                }
                continue;
            }
            String parentName = cd.getParentName().getName();
            try {
                inheritanceGraph.addNodeAsParentOf(className, parentName);
                ClassSymbolTableItem parentSTI = (ClassSymbolTableItem) SymbolTable.root
                        .get(ClassSymbolTableItem.classModifier + parentName);
                ClassSymbolTableItem thisClassSTI = (ClassSymbolTableItem) SymbolTable.root
                        .get(ClassSymbolTableItem.classModifier + cd.getName().getName());
                thisClassSTI.setParentSymbolTable(parentSTI.getSymbolTable());
                thisClassSTI.getSymbolTable().setPreSymbolTable(parentSTI.getSymbolTable());
            } catch (ItemNotFoundException | GraphDoesNotContainNodeException ignored) {
            }
        }
    }

    @Override
    public Graph<String> getResult() {
        return inheritanceGraph;
    }
}
