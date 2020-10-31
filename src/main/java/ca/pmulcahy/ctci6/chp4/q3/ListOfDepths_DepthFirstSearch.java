package ca.pmulcahy.ctci6.chp4.q3;

import ca.pmulcahy.ctci6.chp4.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (eg, if you have a tree with depth D, you'll have D linked lists).
 */
public class ListOfDepths_DepthFirstSearch {
	public static <T extends Comparable<T>> List<LinkedList<TreeNode<T>>> getListOfDepths(TreeNode<T> root) {

		List<LinkedList<TreeNode<T>>> listOfNodeLists = new ArrayList<LinkedList<TreeNode<T>>>();
		if(root!=null) {
			addToList(listOfNodeLists, root, 0);
		}
		
		return listOfNodeLists;
	}
	
	private static <T extends Comparable<T>> void addToList(List<LinkedList<TreeNode<T>>> listOfNodeLists, TreeNode<T> treeNode, int depth) {
		if(listOfNodeLists.size() == depth) {
			listOfNodeLists.add(new LinkedList<TreeNode<T>>());
		}
		listOfNodeLists.get(depth).add(treeNode);
		TreeNode<T> leftNode = treeNode.getLeft();
		if(leftNode!=null) {
			addToList(listOfNodeLists, leftNode, depth + 1);
		}
		TreeNode<T> rightNode = treeNode.getRight();
		if(rightNode!=null) {
			addToList(listOfNodeLists, rightNode, depth + 1);
		}

	}
}
