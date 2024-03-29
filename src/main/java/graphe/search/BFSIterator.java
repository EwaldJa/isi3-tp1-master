package graphe.search;

import graphe.graph.IGraph;
import graphe.graph.Node;

public class BFSIterator extends ASearchAlgoIterator {


    public BFSIterator(Node start, IGraph g) {
        super(start, g);
    }

    protected Node getNextNode() {
        return _nodeList.get(_index++);
    }
}
