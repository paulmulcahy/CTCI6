package ca.pmulcahy.ctci6.chp4.q2;

import ca.pmulcahy.ctci6.chp4.TreeNode;

import java.util.List;

/*
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search tree with minimal height;
 *
 * This is the generic implementation. As generic arrays cannot be used in java, lists are used instead. See MinimalTreeInt.java for the Array/Integer implementation.
 */
public class MinimalTree {
	public static <T extends Comparable<T>> TreeNode<T> buildBinaryTree(final List<T> sortedUniques) {
		return buildBinaryTree(sortedUniques, 0, sortedUniques.size());
	}
	
	private static <T extends Comparable<T>> TreeNode<T> buildBinaryTree(final List<T> sortedUniques, final int start, final int end) {
		if(end - start > 1) {
			final int mid = (end + start) / 2;
			final TreeNode<T> parent = new TreeNode<T>(sortedUniques.get(mid));
			parent.setLeft(buildBinaryTree(sortedUniques, start, mid));
			parent.setRight(buildBinaryTree(sortedUniques, mid + 1, end));
			return parent;
		} else if (end - start == 1) {
			return new TreeNode<T>(sortedUniques.get(start));
		} else {
			return null;
		}
	}
}
