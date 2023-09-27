package ca.pmulcahy.ctci6.chp04.q09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ca.pmulcahy.ctci6.chp04.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class TestBSTSequences {

  @Test
  void empty() {
    final Set<List<Integer>> expected = Set.of(List.of());
    final Set<LinkedList<Integer>> result = BSTSequences.getSequences(null);
    assertEquals(expected, result);
  }

  @Test
  void rootOnly() {
    final Set<List<Integer>> expected = Set.of(List.of(1));
    final TreeNode<Integer> root = new TreeNode<>(1);
    final Set<LinkedList<Integer>> result = BSTSequences.getSequences(root);
    assertEquals(expected, result);
  }

  @Test
  void duplicate() {
    final Set<List<Integer>> expected = Set.of(List.of(1, 1));
    final TreeNode<Integer> root = new TreeNode<>(List.of(1, 1));
    final Set<LinkedList<Integer>> result = BSTSequences.getSequences(root);
    assertEquals(expected, result);
  }

  /*     2
   *    /
   *   1
   */
  @Test
  void left() {
    final Set<List<Integer>> expected = Set.of(List.of(2, 1));
    final TreeNode<Integer> root = new TreeNode<>(List.of(2, 1));
    final Set<LinkedList<Integer>> result = BSTSequences.getSequences(root);
    assertEquals(expected, result);
  }

  /*   2
   * 	\
   *     3
   */
  @Test
  void right() {
    final Set<List<Integer>> expected = Set.of(List.of(2, 3));
    final TreeNode<Integer> root = new TreeNode<>(List.of(2, 3));
    final Set<LinkedList<Integer>> result = BSTSequences.getSequences(root);
    assertEquals(expected, result);
  }

  /*       2
   *      / \
   *     1   3
   */
  @Test
  void book() {
    final Set<List<Integer>> expected = Set.of(List.of(2, 1, 3), List.of(2, 3, 1));
    final TreeNode<Integer> root = new TreeNode<>(List.of(2, 1, 3));
    final Set<LinkedList<Integer>> result = BSTSequences.getSequences(root);
    assertEquals(expected, result);
  }

  /*       2
   *      / \
   *     2   3
   */
  @Test
  void bookDuplicate() {
    final Set<List<Integer>> expected = Set.of(List.of(2, 2, 3), List.of(2, 3, 2));
    final TreeNode<Integer> root = new TreeNode<>(List.of(2, 2, 3));
    final Set<LinkedList<Integer>> result = BSTSequences.getSequences(root);
    assertEquals(expected, result);
  }

  /*        _4
   *       /
   *      2
   *     / \
   *    1   3
   */
  @Test
  void four() {
    final Set<List<Integer>> expected = Set.of(List.of(4, 2, 1, 3), List.of(4, 2, 3, 1));
    final TreeNode<Integer> root = new TreeNode<>(List.of(4, 2, 1, 3));
    final Set<LinkedList<Integer>> result = BSTSequences.getSequences(root);
    assertEquals(expected, result);
  }

  /*        _4_
   *       /   \
   *      2     6
   *     / \
   *    1   3
   */
  @Test
  void five() {
    final Set<List<Integer>> expected =
        Set.of(
            List.of(4, 2, 1, 3, 6),
            List.of(4, 2, 1, 6, 3),
            List.of(4, 2, 6, 1, 3),
            List.of(4, 6, 2, 1, 3),
            List.of(4, 2, 3, 1, 6),
            List.of(4, 2, 3, 6, 1),
            List.of(4, 2, 6, 3, 1),
            List.of(4, 6, 2, 3, 1));
    final TreeNode<Integer> root = new TreeNode<>(List.of(4, 2, 1, 3, 6));
    final Set<LinkedList<Integer>> result = BSTSequences.getSequences(root);
    assertEquals(expected, result);
  }

  /*        _4_
   *       /   \
   *      2     6
   *     / \   /
   *    1   3 5
   */
  @Test
  void six() {
    final Set<List<Integer>> expected =
        Set.of(
            List.of(4, 2, 1, 3, 6, 5),
            List.of(4, 2, 1, 6, 5, 3),
            List.of(4, 2, 1, 6, 3, 5),
            List.of(4, 2, 6, 5, 1, 3),
            List.of(4, 2, 6, 1, 5, 3),
            List.of(4, 2, 6, 1, 3, 5),
            List.of(4, 6, 5, 2, 1, 3),
            List.of(4, 6, 2, 5, 1, 3),
            List.of(4, 6, 2, 1, 5, 3),
            List.of(4, 6, 2, 1, 3, 5),
            List.of(4, 2, 3, 1, 6, 5),
            List.of(4, 2, 3, 6, 5, 1),
            List.of(4, 2, 3, 6, 1, 5),
            List.of(4, 2, 6, 5, 3, 1),
            List.of(4, 2, 6, 3, 5, 1),
            List.of(4, 2, 6, 3, 1, 5),
            List.of(4, 6, 5, 2, 3, 1),
            List.of(4, 6, 2, 5, 3, 1),
            List.of(4, 6, 2, 3, 5, 1),
            List.of(4, 6, 2, 3, 1, 5));
    final TreeNode<Integer> root = new TreeNode<>(List.of(4, 2, 1, 3, 6, 5));
    final Set<LinkedList<Integer>> result = BSTSequences.getSequences(root);
    assertEquals(expected, result);
  }

  /*        _4_
   *       /   \
   *      2     6
   *     / \   / \
   *    1   3 5   7
   */
  @Test
  void seven() {
    final Set<List<Integer>> expected =
        Set.of(
            List.of(4, 2, 1, 3, 6, 5, 7),
            List.of(4, 2, 1, 3, 6, 7, 5),
            List.of(4, 2, 1, 6, 5, 3, 7),
            List.of(4, 2, 1, 6, 5, 7, 3),
            List.of(4, 2, 1, 6, 7, 5, 3),
            List.of(4, 2, 1, 6, 3, 5, 7),
            List.of(4, 2, 1, 6, 3, 7, 5),
            List.of(4, 2, 1, 6, 7, 3, 5),
            List.of(4, 2, 6, 5, 1, 3, 7),
            List.of(4, 2, 6, 5, 1, 7, 3),
            List.of(4, 2, 6, 5, 7, 1, 3),
            List.of(4, 2, 6, 7, 5, 1, 3),
            List.of(4, 2, 6, 1, 5, 3, 7),
            List.of(4, 2, 6, 1, 5, 7, 3),
            List.of(4, 2, 6, 1, 7, 5, 3),
            List.of(4, 2, 6, 7, 1, 5, 3),
            List.of(4, 2, 6, 1, 3, 5, 7),
            List.of(4, 2, 6, 1, 3, 7, 5),
            List.of(4, 2, 6, 1, 7, 3, 5),
            List.of(4, 2, 6, 7, 1, 3, 5),
            List.of(4, 6, 5, 2, 1, 3, 7),
            List.of(4, 6, 5, 2, 1, 7, 3),
            List.of(4, 6, 5, 2, 7, 1, 3),
            List.of(4, 6, 5, 7, 2, 1, 3),
            List.of(4, 6, 7, 5, 2, 1, 3),
            List.of(4, 6, 2, 5, 1, 3, 7),
            List.of(4, 6, 2, 5, 1, 7, 3),
            List.of(4, 6, 2, 5, 7, 1, 3),
            List.of(4, 6, 2, 7, 5, 1, 3),
            List.of(4, 6, 7, 2, 5, 1, 3),
            List.of(4, 6, 2, 1, 5, 3, 7),
            List.of(4, 6, 2, 1, 5, 7, 3),
            List.of(4, 6, 2, 1, 7, 5, 3),
            List.of(4, 6, 2, 7, 1, 5, 3),
            List.of(4, 6, 7, 2, 1, 5, 3),
            List.of(4, 6, 2, 1, 3, 5, 7),
            List.of(4, 6, 2, 1, 3, 7, 5),
            List.of(4, 6, 2, 1, 7, 3, 5),
            List.of(4, 6, 2, 7, 1, 3, 5),
            List.of(4, 6, 7, 2, 1, 3, 5),
            List.of(4, 2, 3, 1, 6, 5, 7),
            List.of(4, 2, 3, 1, 6, 7, 5),
            List.of(4, 2, 3, 6, 5, 1, 7),
            List.of(4, 2, 3, 6, 5, 7, 1),
            List.of(4, 2, 3, 6, 7, 5, 1),
            List.of(4, 2, 3, 6, 1, 5, 7),
            List.of(4, 2, 3, 6, 1, 7, 5),
            List.of(4, 2, 3, 6, 7, 1, 5),
            List.of(4, 2, 6, 5, 3, 1, 7),
            List.of(4, 2, 6, 5, 3, 7, 1),
            List.of(4, 2, 6, 5, 7, 3, 1),
            List.of(4, 2, 6, 7, 5, 3, 1),
            List.of(4, 2, 6, 3, 5, 1, 7),
            List.of(4, 2, 6, 3, 5, 7, 1),
            List.of(4, 2, 6, 3, 7, 5, 1),
            List.of(4, 2, 6, 7, 3, 5, 1),
            List.of(4, 2, 6, 3, 1, 5, 7),
            List.of(4, 2, 6, 3, 1, 7, 5),
            List.of(4, 2, 6, 3, 7, 1, 5),
            List.of(4, 2, 6, 7, 3, 1, 5),
            List.of(4, 6, 5, 2, 3, 1, 7),
            List.of(4, 6, 5, 2, 3, 7, 1),
            List.of(4, 6, 5, 2, 7, 3, 1),
            List.of(4, 6, 5, 7, 2, 3, 1),
            List.of(4, 6, 7, 5, 2, 3, 1),
            List.of(4, 6, 2, 5, 3, 1, 7),
            List.of(4, 6, 2, 5, 3, 7, 1),
            List.of(4, 6, 2, 5, 7, 3, 1),
            List.of(4, 6, 2, 7, 5, 3, 1),
            List.of(4, 6, 7, 2, 5, 3, 1),
            List.of(4, 6, 2, 3, 5, 1, 7),
            List.of(4, 6, 2, 3, 5, 7, 1),
            List.of(4, 6, 2, 3, 7, 5, 1),
            List.of(4, 6, 2, 7, 3, 5, 1),
            List.of(4, 6, 7, 2, 3, 5, 1),
            List.of(4, 6, 2, 3, 1, 5, 7),
            List.of(4, 6, 2, 3, 1, 7, 5),
            List.of(4, 6, 2, 3, 7, 1, 5),
            List.of(4, 6, 2, 7, 3, 1, 5),
            List.of(4, 6, 7, 2, 3, 1, 5));
    final TreeNode<Integer> root = new TreeNode<>(List.of(4, 2, 1, 3, 6, 5, 7));
    final Set<LinkedList<Integer>> result = BSTSequences.getSequences(root);
    assertEquals(expected, result);
  }
}
