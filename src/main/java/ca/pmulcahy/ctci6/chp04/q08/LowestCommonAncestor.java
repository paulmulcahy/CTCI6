package ca.pmulcahy.ctci6.chp04.q08;

import ca.pmulcahy.ctci6.chp04.TreeNode;

/*
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 *  Avoid storing nodes in a data structure. NOTE: This is not necessarily a binary search tree.
 */
public class LowestCommonAncestor {
  public static <T extends Comparable<T>> TreeNode<T> getLowestCommonAncestor(
      final TreeNode<T> root, final T data1, final T data2) {
    // Input Validation
    if (data1 == null || data2 == null) {
      throw new IllegalArgumentException("Data arguments cannot be null");
    }
    return lca(root, data1, data2);
  }

  private static <T extends Comparable<T>> TreeNode<T> lca(
      final TreeNode<T> root, final T data1, final T data2) {
    if (root == null) {
      // 1st Base Case
      return null;
    }
    if (data1.equals(root.getData()) || data2.equals(root.getData())) {
      // 2nd Base Case
      return root;
    }

    // Divide
    final var leftNode = lca(root.getLeft(), data1, data2);
    final var rightNode = lca(root.getRight(), data1, data2);

    // (and Conquer)
    if (leftNode != null && rightNode != null) {
      return root;
    }
    if (leftNode == null && rightNode == null) {
      return null;
    }
    if (leftNode != null) {
      return leftNode;
    }
    return rightNode;
  }
}
