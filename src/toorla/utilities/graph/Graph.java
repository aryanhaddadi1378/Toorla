package toorla.utilities.graph;

import java.util.*;

public class Graph<Node> {
    private Map<Node, Set<Node>> parentShipRelation;

    public Graph() {
        parentShipRelation = new HashMap<>();
    }

    public void addNodeAsParentOf(Node desired, Node parentNode) throws GraphDoesNotContainNodeException {
        if (!parentShipRelation.containsKey(desired))
            throw new GraphDoesNotContainNodeException();
        else
            parentShipRelation.get(desired).add(parentNode);
    }

    public Collection<Node> getParentsOfNode(Node desired) throws GraphDoesNotContainNodeException {
        if (!parentShipRelation.containsKey(desired))
            throw new GraphDoesNotContainNodeException();
        return parentShipRelation.get(desired);
    }

    private boolean _isSecondNodeAncestorOf(Node first, Node second, Set<Node> visitedNodes)
    {
        try {
            if( first.equals(second) )
                return true;
            Collection<Node> parents = getParentsOfNode(first);
            for( Node node : parents )
                if( node.equals(second))
                    return true;
                else
                {
                    if(visitedNodes.contains(node))
                        continue;
                    visitedNodes.add(node);
                    if(_isSecondNodeAncestorOf(node, second, visitedNodes))
                        return true;
                }
        }
        catch(GraphDoesNotContainNodeException ignored)
        {
        }
        return false;
    }

    public boolean isSecondNodeAncestorOf(Node first , Node second ) {
        Set<Node> visitedNodes = new HashSet<>();
        return _isSecondNodeAncestorOf(first,second, visitedNodes);
    }

    public void addNode(Node desired) throws NodeAlreadyExists {
        if (parentShipRelation.containsKey(desired))
            throw new NodeAlreadyExists();
        parentShipRelation.put(desired, new HashSet<>());
    }

    public boolean doesGraphContainNode(Node desired) {
        return parentShipRelation.containsKey(desired);
    }
}
