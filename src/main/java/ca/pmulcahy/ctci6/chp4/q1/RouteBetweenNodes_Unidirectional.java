package ca.pmulcahy.ctci6.chp4.q1;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/*
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
public class RouteBetweenNodes_Unidirectional {
	
	public static boolean isRouteBetweenNodes(Node startNode, Node endNode) {
		Queue<Node> nodesToSearch = new ArrayDeque<>();
		nodesToSearch.add(startNode);
		
		Set<Node> connectedNodes = new HashSet<>();
		connectedNodes.add(startNode);
		
		while(!nodesToSearch.isEmpty()) {
			Node node = nodesToSearch.remove();
			Set<Node> childNodes = node.getChildren();
			
			for(Node child : childNodes) {
				if(child.equals(endNode)) {
					return true;
				}
				if(connectedNodes.add(child)) {
					nodesToSearch.add(child);
				}
			}
		}
		return false;		
	}
}
