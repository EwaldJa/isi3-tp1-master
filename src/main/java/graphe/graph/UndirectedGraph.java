package graphe.graph;

public class UndirectedGraph extends Graph implements IUndirectedGraph {
    /**
     * Ajoute une arête au graphe non-orienté, en ajoutant un arc de n1 vers n2 et un arc de n2 vers n1 dans Graph
     * @param _node1
     * @param _node2
     * @see Graph#addArc(Arc)
     */
    @Override
    public void addEdge(Node _node1, Node _node2) {
        Arc n1_n2 = new Arc(_node1, _node2, null);
        super.addArc(n1_n2);
        Arc n2_n1 = new Arc(_node2, _node1, null);
        super.addArc(n2_n1);
    }

    /**
     * Vérifie si une arête existe entre n1 et n2 en vérifiant si un des deux arcs correspondant a été enregistré dans Graph
     * @param _node1
     * @param _node2
     * @return boolean, true si une arête existe entre n1 et n2, false sinon
     * @see Graph#hasArc(Node, Node)
     */
    @Override
    public boolean hasEdge(Node _node1, Node _node2) {
        return super.hasArc(_node1, _node2);
    }
}
