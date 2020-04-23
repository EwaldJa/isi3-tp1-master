package graphe;

import java.util.ArrayList;
import java.util.List;

public class DFSIterator extends ASearchAlgoIterator {

    private List<Node> _explored_nodes; //noeuds déjà traités

    public DFSIterator(Node start, IGraph g) {
        super(start, g);
        _explored_nodes = new ArrayList<>();
    }

    protected Node getNextNode() {
        Node res;
        int i = 0;
        do { /*On récupère le premier noeud non déjà traité en partant de la fin de la liste*/
            res = _nodeList.get(_nodeList.size() - 1 - i);
            i++; }
        while (_explored_nodes.contains(res));
        _explored_nodes.add(res);
        _index++; //pour le hasNext()
        return res;
    }

}
