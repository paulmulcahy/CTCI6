package ca.pmulcahy.ctci6.chp4.q4;

import ca.pmulcahy.ctci6.chp4.TreeNode;

/*
 * Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
 */
public class CheckBalanced_DepthFirstSearch {
	public static <T extends Comparable<T>> boolean isBalanced(TreeNode<T> root) {		
		int depth = 0;
		
		if(root!=null) {
			depth = getDepth(root);
		}
		
		if(depth == -1) {
			return false;
		}
		return true;
	}
	
	private static <T extends Comparable<T>> int getDepth(TreeNode<T> treeNode) {
		int depth;
		int leftDepth = 0;
		int rightDepth = 0;
		
		if(treeNode.getLeft()!=null) {
			leftDepth = 1 + getDepth(treeNode.getLeft());
		}
		if(treeNode.getRight()!=null) {
			rightDepth = 1 + getDepth(treeNode.getRight()); 
		}
		
		if(leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth-rightDepth) > 1) {
			depth = -1; //unbalanced tree - heights of two subtrees of any node may never differ by more than one
		} else {
			depth = Math.max(leftDepth, rightDepth);
		}
		
		return depth;
	}
}
