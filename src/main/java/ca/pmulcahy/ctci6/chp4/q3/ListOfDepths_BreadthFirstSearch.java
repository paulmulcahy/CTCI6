package ca.pmulcahy.ctci6.chp4.q3;

import ca.pmulcahy.ctci6.chp4.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (eg, if you have a tree with depth D, you'll have D linked lists).
 */
public class ListOfDepths_BreadthFirstSearch {
	public static <T extends Comparable<T>> List<LinkedList<TreeNode<T>>> getListOfDepths(final TreeNode<T> root) {

		final List<LinkedList<TreeNode<T>>> listOfNodeLists = new ArrayList<LinkedList<TreeNode<T>>>();
		LinkedList<TreeNode<T>> nodesAtDepth = new LinkedList<TreeNode<T>>();
		if(root!=null) {
			nodesAtDepth.add(root);
		}
		for(int i=0; !nodesAtDepth.isEmpty(); i++) {
			listOfNodeLists.add(nodesAtDepth);
			nodesAtDepth = new LinkedList<TreeNode<T>>();
			for(TreeNode<T> treeNode : listOfNodeLists.get(i)) {
				if(treeNode.getLeft()!=null) {
				nodesAtDepth.add(treeNode.getLeft());
				}
				if(treeNode.getRight()!=null) {
					nodesAtDepth.add(treeNode.getRight());
				}
			}
		}
		
		return listOfNodeLists;
	}
}
