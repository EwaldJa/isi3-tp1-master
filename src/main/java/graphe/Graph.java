package graphe;

import java.util.*;


public class Graph implements IDirectedGraph {

	/**
	 * A chaque cle=noeud est associe la liste des arcs sortants de ce noeud
	 */
	private Map<Node,List<Arc>> adjacence; 
	
	public Graph(){
		
		adjacence = new HashMap<Node,List<Arc>>();
		
		
	
	}
	/**
	 * 
	 * @param _n1
	 * @param _n2
	 * @return vrai si graph possede arc de src _n1 et destination _n2
	 */
	public boolean hasArc(Node _n1, Node _n2){
		List<Arc> arretesAdj = adjacence.get(_n1);
		for (Arc _a : arretesAdj){
			if (_n1.equals(_a.getSource()) && _n2.equals(_a.getDestination()))
				return true;
		}
		return false;
	}
	
	public void addNode(Node _node){
		adjacence.put(_node, new ArrayList<Arc>());

	}
	
	public void addArc(Arc _edge){
	
		if (!hasArc(_edge.getSource(),_edge.getDestination()))
			adjacence.get(_edge.getSource()).add(_edge);
	
	}
	
	public List<Node> getAllNodes(){
		//A COMPLETER
		return new ArrayList<>(this.adjacence.keySet());
	}
	
	public int getNbNodes(){
		//A COMPLETER
		return this.adjacence.size();
	}
	
	/**
	 * 
	 * @param _n
	 * @return tous les arcs de source _n
	 */
	public List<Arc> getArc(Node _n){
		return adjacence.get(_n);
	}


	/**
	 * renvoie tous les noeuds qui sont destination d'un arc dont la source est _n
	 */
	public List<Node> getAdjNodes(Node _n){
		//A COMPLETER
		List<Node> adj_nodes = new ArrayList<>();
		for (Arc _n_arc:this.adjacence.get(_n)) {
			adj_nodes.add(_n_arc.getDestination());
		}
		return adj_nodes;
	}

	@Override
	public Iterator<Node> creerBFSIterator(Node n) {
		return new BFSIterator(n, this);
	}

	@Override
	public Iterator<Node> creerDFSIterator(Node n) {
		return new DFSIterator(n, this);
	}


	@Override
	public String toString() {
		//A COMPLETER
		StringBuffer sb = new StringBuffer();
		sb.append("Graph \n");
		for (Node n:getAllNodes()) {
			sb.append(" * noeud = " + n + " : ");
			sb.append("[");
			List<Arc> n_arcs = getArc(n);
			for (int i = 0; i < n_arcs.size() - 1; i++) {
				sb.append(n_arcs.get(i) + ", "); }
			if(!n_arcs.isEmpty()) {
				sb.append(n_arcs.get(n_arcs.size() - 1)); }
			sb.append("] \n"); }
		return sb.toString();
	}


	
}
