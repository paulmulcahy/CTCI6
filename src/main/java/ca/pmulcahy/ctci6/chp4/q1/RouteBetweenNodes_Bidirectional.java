package ca.pmulcahy.ctci6.chp4.q1;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/*
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 *
 */
public class RouteBetweenNodes_Bidirectional {
	
	public static boolean isRouteBetweenNodes(NodeWithParents startNode, NodeWithParents endNode) {	
		Queue<NodeWithParents> nodesToSearchFromStart = new ArrayDeque<>();
		nodesToSearchFromStart.add(startNode);
		Queue<NodeWithParents> nodesToSearchFromEnd = new ArrayDeque<>();
		nodesToSearchFromEnd.add(endNode);
		
		Set<NodeWithParents> nodesConnectedToStart = new HashSet<>();
		nodesConnectedToStart.add(startNode);
		Set<NodeWithParents> nodesConnectedToEnd = new HashSet<>();
		nodesConnectedToEnd.add(endNode);
		
		while(!nodesToSearchFromStart.isEmpty() || !nodesToSearchFromEnd.isEmpty()) {
			
			if(!nodesToSearchFromStart.isEmpty()) {
				NodeWithParents node = nodesToSearchFromStart.remove();
				Set<NodeWithParents> childNodes = node.getChildren();
				
				for(NodeWithParents child : childNodes) {
					if(nodesConnectedToEnd.contains(child)) {
						return true;
					}
					if(nodesConnectedToStart.add(child)) {
						nodesToSearchFromStart.add(child);
					}
				}
			}
			
			if(!nodesToSearchFromEnd.isEmpty()) {
				NodeWithParents node = nodesToSearchFromEnd.remove();
				Set<NodeWithParents> parentNodes = node.getParents();
				
				for(NodeWithParents parent : parentNodes) {
					if(nodesConnectedToStart.contains(parent)) {
						return true;
					}
					if(nodesConnectedToEnd.add(parent)) {
						nodesToSearchFromEnd.add(parent);
					}
				}
			}

		}
		return false;
		
	}

}