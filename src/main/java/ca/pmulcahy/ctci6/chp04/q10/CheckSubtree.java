package ca.pmulcahy.ctci6.chp04.q10;

import ca.pmulcahy.ctci6.chp04.TreeNode;

/*
 * T1 and T2 are two very large binary trees, with T1 much larger than T2. Create an algorithm to determine if T2 is a subtree of T1.
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2.
 * That is, if you cut off the tree at node n, the two trees would be identical.
 */
public class CheckSubtree {

  public static <T extends Comparable<T>> boolean checkSubTree(
      final TreeNode<T> t1Node, final TreeNode<T> t2Node) {
    if (t1Node == null || t2Node == null) {
      return false;
    }
    return checkSubTreeInternal(t1Node, t2Node);
  }

  private static <T extends Comparable<T>> boolean checkSubTreeInternal(
      final TreeNode<T> t1Node, final TreeNode<T> t2Node) {
    if (t1Node == null && t2Node == null) {
      return true;
    }
    if ((t1Node != null && t2Node == null) || (t1Node == null && t2Node != null)) {
      return false;
    }
    if ((t1Node.getData() == null && t2Node.getData() == null)
        || (t1Node.getData() != null && t1Node.getData().equals(t2Node.getData()))) {
      if (checkSubTreeInternal(t1Node.getLeft(), t2Node.getLeft())
          && checkSubTreeInternal(t1Node.getRight(), t2Node.getRight())) {
        return true;
      }
    }
    if (checkSubTreeInternal(t1Node.getLeft(), t2Node)
        || checkSubTreeInternal(t1Node.getRight(), t2Node)) {
      return true;
    }
    return false;
  }
}
