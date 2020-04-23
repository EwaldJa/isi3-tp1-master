package graphe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class ASearchAlgoIterator implements Iterator<Node> {

    protected List<Node> _nodeList;
    protected IGraph _graph;
    protected int _index;

    protected ASearchAlgoIterator(Node start, IGraph graph) {
        _nodeList = new ArrayList<>();
        _nodeList.add(start);
        _graph = graph;
        _index = 0;
    }

    public boolean hasNext() {
        return !(_index == _nodeList.size());
    }

    public Node next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more nodes"); }
        Node res = getNextNode();
        for(Node adj_n:_graph.getAdjNodes(res)){
            if(!_nodeList.contains(adj_n)) { _nodeList.add(adj_n); } }
        return res;
    }

    protected abstract Node getNextNode();
}
