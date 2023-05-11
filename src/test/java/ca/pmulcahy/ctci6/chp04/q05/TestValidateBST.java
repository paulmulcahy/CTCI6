package ca.pmulcahy.ctci6.chp04.q05;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ca.pmulcahy.ctci6.chp04.TreeNode;
import org.junit.jupiter.api.Test;

class TestValidateBST {

  @Test
  void zeroNodes() {
    final TreeNode<Integer> rootNode = null;
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertTrue(validBST);
  }

  @Test
  void oneNode() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertTrue(validBST);
  }

  @Test
  void twoNodesLeftHeavyValid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(2);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
    rootNode.setLeft(leftNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertTrue(validBST);
  }

  @Test
  void twoNodesLeftHeavyEqual() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
    rootNode.setLeft(leftNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertTrue(validBST);
  }

  @Test
  void twoNodesLeftHeavyInvalid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
    rootNode.setLeft(leftNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertFalse(validBST);
  }

  @Test
  void twoNodesRightHeavyValid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(2);
    rootNode.setRight(rightNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertTrue(validBST);
  }

  @Test
  void twoNodesRightHeavyInvalid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(2);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(1);
    rootNode.setRight(rightNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertFalse(validBST);
  }

  @Test
  void twoNodesRightHeavyEqual() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(1);
    rootNode.setRight(rightNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertFalse(validBST);
  }

  @Test
  void threeNodesBalancedValid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(2);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(3);
    rootNode.setRight(rightNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertTrue(validBST);
  }

  @Test
  void threeNodesBalancedInvalid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(2);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(3);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(1);
    rootNode.setRight(rightNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertFalse(validBST);
  }

  @Test
  void threeNodesLeftLeftHeavyValid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(1);
    leftNode.setLeft(leftLeftNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertTrue(validBST);
  }

  @Test
  void threeNodesLeftLeftHeavyInvalid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(2);
    leftNode.setLeft(leftLeftNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertFalse(validBST);
  }

  @Test
  void threeNodesLeftRightHeavyValid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> leftRightNode = new TreeNode<Integer>(2);
    leftNode.setRight(leftRightNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertTrue(validBST);
  }

  @Test
  void threeNodesLeftRightHeavyInvalid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> leftRightNode = new TreeNode<Integer>(1);
    leftNode.setRight(leftRightNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertFalse(validBST);
  }

  @Test
  void threeNodesRightLeftHeavyValid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(3);
    rootNode.setRight(rightNode);
    final TreeNode<Integer> rightLeftNode = new TreeNode<Integer>(2);
    rightNode.setLeft(rightLeftNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertTrue(validBST);
  }

  @Test
  void threeNodesRightLeftHeavyInvalid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(2);
    rootNode.setRight(rightNode);
    final TreeNode<Integer> rightLeftNode = new TreeNode<Integer>(3);
    rightNode.setLeft(rightLeftNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertFalse(validBST);
  }

  @Test
  void threeNodesRightRightHeavyValid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(2);
    rootNode.setRight(rightNode);
    final TreeNode<Integer> rightRightNode = new TreeNode<Integer>(3);
    rightNode.setRight(rightRightNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertTrue(validBST);
  }

  @Test
  void threeNodesRightRightHeavyInvalid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(1);
    rootNode.setRight(rightNode);
    final TreeNode<Integer> rightRightNode = new TreeNode<Integer>(1);
    rightNode.setRight(rightRightNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertFalse(validBST);
  }

  @Test
  void fourNodesLeftLeftHeavyValid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(4);
    rootNode.setRight(rightNode);
    final TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(1);
    leftNode.setLeft(leftLeftNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertTrue(validBST);
  }

  @Test
  void fourNodesLeftLeftHeavyInvalid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(3);
    rootNode.setRight(rightNode);
    final TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(1);
    leftNode.setLeft(leftLeftNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertFalse(validBST);
  }

  @Test
  void fourNodesLeftHeavyValid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(4);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(1);
    leftNode.setLeft(leftLeftNode);
    final TreeNode<Integer> leftRightNode = new TreeNode<Integer>(3);
    leftNode.setRight(leftRightNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertTrue(validBST);
  }

  @Test
  void fourNodesLeftHeavyInvalid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(4);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(2);
    leftNode.setLeft(leftLeftNode);
    final TreeNode<Integer> leftRightNode = new TreeNode<Integer>(2);
    leftNode.setRight(leftRightNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertFalse(validBST);
  }
}
