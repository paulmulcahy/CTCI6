package ca.pmulcahy.ctci6.chp4.q5;

import ca.pmulcahy.ctci6.chp4.TreeNode;

/*
 * Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
 */
public class ValidateBST {
	public static <T extends Comparable<T>> boolean isBinarySearchTree(final TreeNode<T> treeNode) {		
		boolean isNodeValid = true;
		if(treeNode!=null) {
			isNodeValid = isBST(treeNode);
		}
		return isNodeValid;
	}
	
	private static <T extends Comparable<T>> boolean isBST(final TreeNode<T> treeNode) {
		boolean isNodeValid = true;
		final T nodeData = treeNode.getData();
		
		if(nodeData!=null){
			final TreeNode<T> leftNode = treeNode.getLeft();
			final TreeNode<T> rightNode = treeNode.getRight();
			if(leftNode!=null) {
				final T leftData = leftNode.getData();
				if(nodeData.compareTo(leftData) < 0 || !isBST(leftNode)) {
					isNodeValid = false;
				}
			}
			if(rightNode!=null) {
				final T rightData = rightNode.getData();
				if(nodeData.compareTo(rightData) >= 0 || !isBST(rightNode)) {
					isNodeValid = false;
				}
			}
		} else {
			isNodeValid = false;
		}

		return isNodeValid;		
	}
}
