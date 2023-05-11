package ca.pmulcahy.ctci6.chp04.q04;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ca.pmulcahy.ctci6.chp04.TreeNode;
import org.junit.jupiter.api.Test;

class TestCheckBalanced_BreadthFirstSearch {

  @Test
  void zeroNodes() {
    final TreeNode<Integer> rootNode = null;
    final boolean balanced = CheckBalanced_BreadthFirstSearch.isBalanced(rootNode);
    assertTrue(balanced);
  }

  @Test
  void oneNode() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final boolean balanced = CheckBalanced_BreadthFirstSearch.isBalanced(rootNode);
    assertTrue(balanced);
  }

  @Test
  void twoNodesLeftHeavy() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(2);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
    rootNode.setLeft(leftNode);
    final boolean balanced = CheckBalanced_BreadthFirstSearch.isBalanced(rootNode);
    assertTrue(balanced);
  }

  @Test
  void twoNodesRightHeavy() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(2);
    rootNode.setRight(rightNode);
    final boolean balanced = CheckBalanced_BreadthFirstSearch.isBalanced(rootNode);
    assertTrue(balanced);
  }

  @Test
  void threeNodesBalanced() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(2);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(3);
    rootNode.setRight(rightNode);
    final boolean balanced = CheckBalanced_BreadthFirstSearch.isBalanced(rootNode);
    assertTrue(balanced);
  }

  @Test
  void threeNodesLeftLeftHeavy() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(1);
    leftNode.setLeft(leftLeftNode);
    final boolean balanced = CheckBalanced_BreadthFirstSearch.isBalanced(rootNode);
    assertFalse(balanced);
  }

  @Test
  void threeNodesLeftRightHeavy() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> leftRightNode = new TreeNode<Integer>(2);
    leftNode.setRight(leftRightNode);
    final boolean balanced = CheckBalanced_BreadthFirstSearch.isBalanced(rootNode);
    assertFalse(balanced);
  }

  @Test
  void threeNodesRightLeftHeavy() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(3);
    rootNode.setRight(rightNode);
    final TreeNode<Integer> rightLeftNode = new TreeNode<Integer>(2);
    rightNode.setLeft(rightLeftNode);
    final boolean balanced = CheckBalanced_BreadthFirstSearch.isBalanced(rootNode);
    assertFalse(balanced);
  }

  @Test
  void threeNodesRightRightHeavy() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(2);
    rootNode.setRight(rightNode);
    final TreeNode<Integer> rightRightNode = new TreeNode<Integer>(3);
    rightNode.setRight(rightRightNode);
    final boolean balanced = CheckBalanced_BreadthFirstSearch.isBalanced(rootNode);
    assertFalse(balanced);
  }

  @Test
  void fourNodesLeftLeftHeavy() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(4);
    rootNode.setRight(rightNode);
    final TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(1);
    leftNode.setLeft(leftLeftNode);
    final boolean balanced = CheckBalanced_BreadthFirstSearch.isBalanced(rootNode);
    assertTrue(balanced);
  }

  @Test
  void fourNodesLeftHeavy() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(4);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(1);
    leftNode.setLeft(leftLeftNode);
    final TreeNode<Integer> leftRightNode = new TreeNode<Integer>(3);
    leftNode.setRight(leftRightNode);
    final boolean balanced = CheckBalanced_BreadthFirstSearch.isBalanced(rootNode);
    assertFalse(balanced);
  }
}
