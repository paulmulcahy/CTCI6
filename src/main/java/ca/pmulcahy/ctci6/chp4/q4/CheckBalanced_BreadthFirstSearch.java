package ca.pmulcahy.ctci6.chp4.q4;

import ca.pmulcahy.ctci6.chp4.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
 */
public class CheckBalanced_BreadthFirstSearch {
	public static <T> boolean isBalanced(TreeNode<T> root) {		

		boolean isBalanced = true;		
		List<TreeNode<T>> nodesAtDepth = new ArrayList<TreeNode<T>>();
		
		if(root!=null) {
			nodesAtDepth.add(root);
		}
		
		while(!nodesAtDepth.isEmpty()) {
			nodesAtDepth = getChildNodes(nodesAtDepth);
			if(nodesAtDepth.contains(null)) {
				while(nodesAtDepth.contains(null)) {
					nodesAtDepth.remove(null);
				}
				nodesAtDepth = getChildNodes(nodesAtDepth);
				while(nodesAtDepth.contains(null)) {
					nodesAtDepth.remove(null);
				}
				if(!nodesAtDepth.isEmpty()) {
					isBalanced = false;
				}
			}
		}
			
		return isBalanced;
	}
	
	private static <T> List<TreeNode<T>> getChildNodes(List<TreeNode<T>> treeNodes) {
		List<TreeNode<T>> childNodes = new ArrayList<TreeNode<T>>();
		for(TreeNode<T> treeNode : treeNodes) {
			childNodes.add(treeNode.getLeft());
			childNodes.add(treeNode.getRight());				
		}
		return childNodes;
	}
}
