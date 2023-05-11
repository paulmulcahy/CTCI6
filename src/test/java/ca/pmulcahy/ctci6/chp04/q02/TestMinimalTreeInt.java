package ca.pmulcahy.ctci6.chp04.q02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class TestMinimalTreeInt {

  @Test
  void zeroNodes() {
    final int[] inputArr = {};
    final TreeNodeInt rootNode = MinimalTreeInt.buildBinaryTree(inputArr);
    assertNull(rootNode);
  }

  @Test
  void oneNode() {
    final int[] inputArr = {1};
    final TreeNodeInt rootNode = MinimalTreeInt.buildBinaryTree(inputArr);
    assertEquals(1, rootNode.getData());
    assertNull(rootNode.getLeft());
    assertNull(rootNode.getRight());
  }

  @Test
  void twoNodes() {
    final int[] inputArr = {1, 2};
    final TreeNodeInt rootNode = MinimalTreeInt.buildBinaryTree(inputArr);
    assertEquals(2, rootNode.getData());
    final TreeNodeInt leftNode = rootNode.getLeft();
    assertEquals(1, leftNode.getData());
    assertNull(leftNode.getLeft());
    assertNull(leftNode.getRight());
    assertNull(rootNode.getRight());
  }

  @Test
  void threeNodes() {
    final int[] inputArr = {1, 2, 3};
    final TreeNodeInt rootNode = MinimalTreeInt.buildBinaryTree(inputArr);
    assertEquals(2, rootNode.getData());
    final TreeNodeInt leftNode = rootNode.getLeft();
    assertEquals(1, leftNode.getData());
    assertNull(leftNode.getLeft());
    assertNull(leftNode.getRight());
    final TreeNodeInt rightNode = rootNode.getRight();
    assertEquals(3, rightNode.getData());
    assertNull(rightNode.getLeft());
    assertNull(rightNode.getRight());
  }

  @Test
  void fourNodes() {
    final int[] inputArr = {1, 2, 3, 4};
    final TreeNodeInt rootNode = MinimalTreeInt.buildBinaryTree(inputArr);
    assertEquals(3, rootNode.getData());
    final TreeNodeInt leftNode = rootNode.getLeft();
    assertEquals(2, leftNode.getData());
    final TreeNodeInt leftLeftNode = leftNode.getLeft();
    assertEquals(1, leftLeftNode.getData());
    assertNull(leftLeftNode.getLeft());
    assertNull(leftLeftNode.getRight());
    assertNull(leftNode.getRight());
    final TreeNodeInt rightNode = rootNode.getRight();
    assertEquals(4, rightNode.getData());
    assertNull(rightNode.getLeft());
    assertNull(rightNode.getRight());
  }

  @Test
  void fiveNodes() {
    final int[] inputArr = {1, 2, 3, 4, 5};
    final TreeNodeInt rootNode = MinimalTreeInt.buildBinaryTree(inputArr);
    assertEquals(3, rootNode.getData());
    final TreeNodeInt leftNode = rootNode.getLeft();
    assertEquals(2, leftNode.getData());
    final TreeNodeInt leftLeftNode = leftNode.getLeft();
    assertEquals(1, leftLeftNode.getData());
    assertNull(leftLeftNode.getLeft());
    assertNull(leftLeftNode.getRight());
    assertNull(leftNode.getRight());
    final TreeNodeInt rightNode = rootNode.getRight();
    assertEquals(5, rightNode.getData());
    final TreeNodeInt rightLeftNode = rightNode.getLeft();
    assertEquals(4, rightLeftNode.getData());
    assertNull(rightLeftNode.getLeft());
    assertNull(rightLeftNode.getRight());
    assertNull(rightNode.getRight());
  }

  @Test
  void sixNodes() {
    final int[] inputArr = {1, 2, 3, 4, 5, 6};
    final TreeNodeInt rootNode = MinimalTreeInt.buildBinaryTree(inputArr);
    assertEquals(4, rootNode.getData());
    final TreeNodeInt leftNode = rootNode.getLeft();
    assertEquals(2, leftNode.getData());
    final TreeNodeInt leftLeftNode = leftNode.getLeft();
    assertEquals(1, leftLeftNode.getData());
    assertNull(leftLeftNode.getLeft());
    assertNull(leftLeftNode.getRight());
    final TreeNodeInt leftRightNode = leftNode.getRight();
    assertEquals(3, leftRightNode.getData());
    assertNull(leftRightNode.getLeft());
    assertNull(leftRightNode.getRight());
    final TreeNodeInt rightNode = rootNode.getRight();
    assertEquals(6, rightNode.getData());
    final TreeNodeInt rightLeftNode = rightNode.getLeft();
    assertEquals(5, rightLeftNode.getData());
    assertNull(rightLeftNode.getLeft());
    assertNull(rightLeftNode.getRight());
    assertNull(rightNode.getRight());
  }

  @Test
  void sevenNodes() {
    final int[] inputArr = {1, 2, 3, 4, 5, 6, 7};
    final TreeNodeInt rootNode = MinimalTreeInt.buildBinaryTree(inputArr);
    assertEquals(4, rootNode.getData());
    final TreeNodeInt leftNode = rootNode.getLeft();
    assertEquals(2, leftNode.getData());
    final TreeNodeInt leftLeftNode = leftNode.getLeft();
    assertEquals(1, leftLeftNode.getData());
    assertNull(leftLeftNode.getLeft());
    assertNull(leftLeftNode.getRight());
    final TreeNodeInt leftRightNode = leftNode.getRight();
    assertEquals(3, leftRightNode.getData());
    assertNull(leftRightNode.getLeft());
    assertNull(leftRightNode.getRight());
    final TreeNodeInt rightNode = rootNode.getRight();
    assertEquals(6, rightNode.getData());
    final TreeNodeInt rightLeftNode = rightNode.getLeft();
    assertEquals(5, rightLeftNode.getData());
    assertNull(rightLeftNode.getLeft());
    assertNull(rightLeftNode.getRight());
    final TreeNodeInt rightRightNode = rightNode.getRight();
    assertEquals(7, rightRightNode.getData());
    assertNull(rightRightNode.getLeft());
    assertNull(rightRightNode.getRight());
  }
}
