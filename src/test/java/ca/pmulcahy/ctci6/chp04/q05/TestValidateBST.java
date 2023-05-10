package ca.pmulcahy.ctci6.chp04.q05;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ca.pmulcahy.ctci6.chp04.TreeNode;
import org.junit.jupiter.api.Test;

public class TestValidateBST {

  @Test
  public void zeroNodes() {
    final TreeNode<Integer> rootNode = null;
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertTrue(validBST);
  }

  @Test
  public void oneNode() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertTrue(validBST);
  }

  @Test
  public void twoNodesLeftHeavyValid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(2);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
    rootNode.setLeft(leftNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertTrue(validBST);
  }

  @Test
  public void twoNodesLeftHeavyEqual() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
    rootNode.setLeft(leftNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertTrue(validBST);
  }

  @Test
  public void twoNodesLeftHeavyInvalid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
    rootNode.setLeft(leftNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertFalse(validBST);
  }

  @Test
  public void twoNodesRightHeavyValid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(2);
    rootNode.setRight(rightNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertTrue(validBST);
  }

  @Test
  public void twoNodesRightHeavyInvalid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(2);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(1);
    rootNode.setRight(rightNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertFalse(validBST);
  }

  @Test
  public void twoNodesRightHeavyEqual() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(1);
    rootNode.setRight(rightNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertFalse(validBST);
  }

  @Test
  public void threeNodesBalancedValid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(2);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(3);
    rootNode.setRight(rightNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertTrue(validBST);
  }

  @Test
  public void threeNodesBalancedInvalid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(2);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(3);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(1);
    rootNode.setRight(rightNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertFalse(validBST);
  }

  @Test
  public void threeNodesLeftLeftHeavyValid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(1);
    leftNode.setLeft(leftLeftNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertTrue(validBST);
  }

  @Test
  public void threeNodesLeftLeftHeavyInvalid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(2);
    leftNode.setLeft(leftLeftNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertFalse(validBST);
  }

  @Test
  public void threeNodesLeftRightHeavyValid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> leftRightNode = new TreeNode<Integer>(2);
    leftNode.setRight(leftRightNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertTrue(validBST);
  }

  @Test
  public void threeNodesLeftRightHeavyInvalid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> leftRightNode = new TreeNode<Integer>(1);
    leftNode.setRight(leftRightNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertFalse(validBST);
  }

  @Test
  public void threeNodesRightLeftHeavyValid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(3);
    rootNode.setRight(rightNode);
    final TreeNode<Integer> rightLeftNode = new TreeNode<Integer>(2);
    rightNode.setLeft(rightLeftNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertTrue(validBST);
  }

  @Test
  public void threeNodesRightLeftHeavyInvalid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(2);
    rootNode.setRight(rightNode);
    final TreeNode<Integer> rightLeftNode = new TreeNode<Integer>(3);
    rightNode.setLeft(rightLeftNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertFalse(validBST);
  }

  @Test
  public void threeNodesRightRightHeavyValid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(2);
    rootNode.setRight(rightNode);
    final TreeNode<Integer> rightRightNode = new TreeNode<Integer>(3);
    rightNode.setRight(rightRightNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertTrue(validBST);
  }

  @Test
  public void threeNodesRightRightHeavyInvalid() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(1);
    rootNode.setRight(rightNode);
    final TreeNode<Integer> rightRightNode = new TreeNode<Integer>(1);
    rightNode.setRight(rightRightNode);
    final boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
    assertFalse(validBST);
  }

  @Test
  public void fourNodesLeftLeftHeavyValid() {
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
  public void fourNodesLeftLeftHeavyInvalid() {
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
  public void fourNodesLeftHeavyValid() {
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
  public void fourNodesLeftHeavyInvalid() {
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
