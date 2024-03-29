package graphe.graph;

import java.util.Iterator;
import java.util.List;

public interface IGraph {
	/**
	 * ajoute un noeud au graph
	 */
	public void addNode(Node _node);
	
	/**
	 * 
	 * @return tous les noeuds du graph
	 */
	public List<Node> getAllNodes();
	/**
	 * 
	 * @return le nombre de noeuds du graph
	 */
	public int getNbNodes();

	/**
	 * renvoie tous les noeuds du graph qui sont destination d'un arc dont la source est _n
	 */
	public List<Node> getAdjNodes(Node _n);
	
	/**
	 * renvoi un iterateur pour recherche en largeur
	 */
	public Iterator<Node> creerBFSIterator(Node n);
	
	/**
	 * renvoi un iterateur pour recherche en profondeur
	 */
	public Iterator<Node> creerDFSIterator(Node n);
}
