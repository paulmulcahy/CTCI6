package ca.pmulcahy.ctci6.chp4.q8;

import ca.pmulcahy.ctci6.chp4.TreeNode;

/*
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 *  Avoid storing nodes in a data structure. NOTE: This is not necessarily a binary search tree.
 */
public class LowestCommonAncestor {
	public static <T extends Comparable<T>> TreeNode<T> getLowestCommonAncestor(final TreeNode<T> root, T data1, T data2) {
		if(data1 == null || data2 == null) {
			throw new IllegalArgumentException("Data arguments must be non-null values");
		}
		return lca(root, data1, data2);
	}
	
	public static <T extends Comparable<T>> TreeNode<T> lca(final TreeNode<T> root, T data1, T data2) {
		if(root == null) {
			return null;
		}
		if(data1.equals(root.getData()) || data2.equals(root.getData())) {
			return root;
		}
		
		final TreeNode<T> leftNode = lca(root.getLeft(), data1, data2);
		final TreeNode<T> rightNode = lca(root.getRight(), data1, data2);
		
		if(leftNode != null && rightNode != null) {
			return root;
		}
		if(leftNode == null && rightNode == null) {
			return null;
		}
		
		if(leftNode != null) {
			return leftNode;
		}
		return rightNode;
	}
}
