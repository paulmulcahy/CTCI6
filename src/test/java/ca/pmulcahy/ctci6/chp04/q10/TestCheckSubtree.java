package ca.pmulcahy.ctci6.chp04.q10;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ca.pmulcahy.ctci6.chp04.TreeNode;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestCheckSubtree {

  @Test
  void bothNull() {
    assertFalse(CheckSubtree.checkSubTree(null, null));
  }

  @Test
  void t1NodeNull() {
    assertFalse(CheckSubtree.checkSubTree(null, new TreeNode<Integer>(1)));
    assertFalse(CheckSubtree.checkSubTree(null, new TreeNode<Integer>((Integer) null)));
  }

  @Test
  void t2NodeNull() {
    assertFalse(CheckSubtree.checkSubTree(new TreeNode<Integer>(1), null));
    assertFalse(CheckSubtree.checkSubTree(new TreeNode<Integer>((Integer) null), null));
  }

  @Test
  void simple() {
    assertTrue(CheckSubtree.checkSubTree(new TreeNode<Integer>(1), new TreeNode<Integer>(1)));
    assertTrue(
        CheckSubtree.checkSubTree(
            new TreeNode<Integer>((Integer) null), new TreeNode<Integer>((Integer) null)));
  }

  @Test
  void simpleButTheyDontEqual() {
    assertFalse(CheckSubtree.checkSubTree(new TreeNode<Integer>(1), new TreeNode<Integer>(2)));
    assertFalse(
        CheckSubtree.checkSubTree(new TreeNode<Integer>(1), new TreeNode<Integer>((Integer) null)));
    assertFalse(
        CheckSubtree.checkSubTree(new TreeNode<Integer>((Integer) null), new TreeNode<Integer>(2)));
  }

  /*     2
   *    /
   *   1
   */
  @Test
  void left() {
    final TreeNode<Integer> tree = new TreeNode<>(List.of(2, 1));
    assertTrue(CheckSubtree.checkSubTree(tree, tree));
  }

  @Test
  void leftButTheyDoNotEqual() {
    final TreeNode<Integer> tree1 = new TreeNode<>(List.of(2, 1));
    final TreeNode<Integer> tree2 = new TreeNode<>(List.of(2, 0));
    assertFalse(CheckSubtree.checkSubTree(tree1, tree2));
  }

  @Test
  void leftSubTree() {
    final TreeNode<Integer> tree1 = new TreeNode<>(List.of(2, 1));
    final TreeNode<Integer> tree2 = new TreeNode<>(List.of(1));
    assertTrue(CheckSubtree.checkSubTree(tree1, tree2));
  }

  @Test
  void leftNotASubTree() {
    final TreeNode<Integer> tree1 = new TreeNode<>(List.of(2, 1));
    final TreeNode<Integer> tree2 = new TreeNode<>(List.of(2));
    assertFalse(CheckSubtree.checkSubTree(tree1, tree2));
  }

  /*   2
   * 	\
   *     3
   */
  @Test
  void right() {
    final TreeNode<Integer> tree = new TreeNode<>(List.of(2, 3));
    assertTrue(CheckSubtree.checkSubTree(tree, tree));
  }

  @Test
  void rightButTheyDoNotEqual() {
    final TreeNode<Integer> tree1 = new TreeNode<>(List.of(2, 3));
    final TreeNode<Integer> tree2 = new TreeNode<>(List.of(2, 4));
    assertFalse(CheckSubtree.checkSubTree(tree1, tree2));
  }

  @Test
  void rightSubTree() {
    final TreeNode<Integer> tree1 = new TreeNode<>(List.of(2, 3));
    final TreeNode<Integer> tree2 = new TreeNode<>(List.of(3));
    assertTrue(CheckSubtree.checkSubTree(tree1, tree2));
  }

  @Test
  void rightNotASubTree() {
    final TreeNode<Integer> tree1 = new TreeNode<>(List.of(2, 3));
    final TreeNode<Integer> tree2 = new TreeNode<>(List.of(2));
    assertFalse(CheckSubtree.checkSubTree(tree1, tree2));
  }

  /*       2
   *      / \
   *     1   3
   */
  @Test
  void even() {
    final TreeNode<Integer> tree = new TreeNode<>(List.of(2, 1, 3));
    assertTrue(CheckSubtree.checkSubTree(tree, tree));
  }

  @Test
  void evenLeft() {
    final TreeNode<Integer> tree1 = new TreeNode<>(List.of(2, 1, 3));
    final TreeNode<Integer> tree2 = new TreeNode<>(1);
    assertTrue(CheckSubtree.checkSubTree(tree1, tree2));
  }

  @Test
  void evenRight() {
    final TreeNode<Integer> tree1 = new TreeNode<>(List.of(2, 1, 3));
    final TreeNode<Integer> tree2 = new TreeNode<>(3);
    assertTrue(CheckSubtree.checkSubTree(tree1, tree2));
  }

  @Test
  void evenRoot() {
    final TreeNode<Integer> tree1 = new TreeNode<>(List.of(2, 1, 3));
    final TreeNode<Integer> tree2 = new TreeNode<>(2);
    assertFalse(CheckSubtree.checkSubTree(tree1, tree2));
  }

  @Test
  void evenNull() {
    final TreeNode<Integer> tree1 = new TreeNode<>(List.of(2, 1, 3));
    final TreeNode<Integer> tree2 = new TreeNode<>((Integer) null);
    assertFalse(CheckSubtree.checkSubTree(tree1, tree2));
  }

  /*        _4_
   *       /   \
   *      2     6
   *     / \   / \
   *    1   3 5   7
   */
  @Test
  void complicated() {
    final TreeNode<Integer> tree = new TreeNode<>(List.of(4, 2, 1, 3, 6, 5, 7));
    assertTrue(CheckSubtree.checkSubTree(tree, tree));
  }

  @Test
  void complicatedLeft() {
    final TreeNode<Integer> tree1 = new TreeNode<>(List.of(4, 2, 1, 3, 6, 5, 7));
    final TreeNode<Integer> tree2 = new TreeNode<>(List.of(2, 1, 3));
    assertTrue(CheckSubtree.checkSubTree(tree1, tree2));
  }

  @Test
  void complicatedRight() {
    final TreeNode<Integer> tree1 = new TreeNode<>(List.of(4, 2, 1, 3, 6, 5, 7));
    final TreeNode<Integer> tree2 = new TreeNode<>(List.of(6, 5, 7));
    assertTrue(CheckSubtree.checkSubTree(tree1, tree2));
  }
}
