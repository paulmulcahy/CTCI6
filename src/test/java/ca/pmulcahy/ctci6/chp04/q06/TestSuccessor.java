package ca.pmulcahy.ctci6.chp04.q06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class TestSuccessor {

  @Test
  void zeroNodes() {
    final TreeNodeParentLinked<Integer> rootNode = null;
    final TreeNodeParentLinked<Integer> rootNodeSuccessor = Successor.getSuccessor(rootNode);
    assertNull(rootNodeSuccessor);
  }

  @Test
  void oneNode() {
    final TreeNodeParentLinked<Integer> rootNode = new TreeNodeParentLinked<Integer>(1);
    final TreeNodeParentLinked<Integer> rootNodeSuccessor = Successor.getSuccessor(rootNode);
    assertNull(rootNodeSuccessor);
  }

  @Test
  void twoNodesLeftHeavy() {
    final TreeNodeParentLinked<Integer> rootNode = new TreeNodeParentLinked<Integer>(2);
    final TreeNodeParentLinked<Integer> leftNode = new TreeNodeParentLinked<Integer>(1);
    rootNode.setLeft(leftNode);
    final TreeNodeParentLinked<Integer> rootNodeSuccessor = Successor.getSuccessor(rootNode);
    assertNull(rootNodeSuccessor);
    final TreeNodeParentLinked<Integer> leftNodeSuccessor = Successor.getSuccessor(leftNode);
    assertEquals(rootNode, leftNodeSuccessor);
  }

  @Test
  void twoNodesRightHeavy() {
    final TreeNodeParentLinked<Integer> rootNode = new TreeNodeParentLinked<Integer>(1);
    final TreeNodeParentLinked<Integer> rightNode = new TreeNodeParentLinked<Integer>(2);
    rootNode.setRight(rightNode);
    final TreeNodeParentLinked<Integer> rootNodeSuccessor = Successor.getSuccessor(rootNode);
    assertEquals(rightNode, rootNodeSuccessor);
    final TreeNodeParentLinked<Integer> rightNodeSuccessor = Successor.getSuccessor(rightNode);
    assertNull(rightNodeSuccessor);
  }

  @Test
  void threeNodesBalanced() {
    final TreeNodeParentLinked<Integer> rootNode = new TreeNodeParentLinked<Integer>(2);
    final TreeNodeParentLinked<Integer> leftNode = new TreeNodeParentLinked<Integer>(1);
    rootNode.setLeft(leftNode);
    final TreeNodeParentLinked<Integer> rightNode = new TreeNodeParentLinked<Integer>(3);
    rootNode.setRight(rightNode);

    final TreeNodeParentLinked<Integer> rootNodeSuccessor = Successor.getSuccessor(rootNode);
    assertEquals(rightNode, rootNodeSuccessor);
    final TreeNodeParentLinked<Integer> leftNodeSuccessor = Successor.getSuccessor(leftNode);
    assertEquals(rootNode, leftNodeSuccessor);
    final TreeNodeParentLinked<Integer> rightNodeSuccessor = Successor.getSuccessor(rightNode);
    assertNull(rightNodeSuccessor);
  }

  @Test
  void threeNodesLeftLeftHeavy() {
    final TreeNodeParentLinked<Integer> rootNode = new TreeNodeParentLinked<Integer>(3);
    final TreeNodeParentLinked<Integer> leftNode = new TreeNodeParentLinked<Integer>(2);
    rootNode.setLeft(leftNode);
    final TreeNodeParentLinked<Integer> leftLeftNode = new TreeNodeParentLinked<Integer>(1);
    leftNode.setLeft(leftLeftNode);

    final TreeNodeParentLinked<Integer> rootNodeSuccessor = Successor.getSuccessor(rootNode);
    assertNull(rootNodeSuccessor);
    final TreeNodeParentLinked<Integer> leftNodeSuccessor = Successor.getSuccessor(leftNode);
    assertEquals(rootNode, leftNodeSuccessor);
    final TreeNodeParentLinked<Integer> leftLeftNodeSuccessor =
        Successor.getSuccessor(leftLeftNode);
    assertEquals(leftNode, leftLeftNodeSuccessor);
  }

  @Test
  void threeNodesLeftRightHeavy() {
    final TreeNodeParentLinked<Integer> rootNode = new TreeNodeParentLinked<Integer>(3);
    final TreeNodeParentLinked<Integer> leftNode = new TreeNodeParentLinked<Integer>(1);
    rootNode.setLeft(leftNode);
    final TreeNodeParentLinked<Integer> leftRightNode = new TreeNodeParentLinked<Integer>(2);
    leftNode.setRight(leftRightNode);

    final TreeNodeParentLinked<Integer> rootNodeSuccessor = Successor.getSuccessor(rootNode);
    assertNull(rootNodeSuccessor);
    final TreeNodeParentLinked<Integer> leftNodeSuccessor = Successor.getSuccessor(leftNode);
    assertEquals(leftRightNode, leftNodeSuccessor);
    final TreeNodeParentLinked<Integer> leftRightNodeSuccessor =
        Successor.getSuccessor(leftRightNode);
    assertEquals(rootNode, leftRightNodeSuccessor);
  }

  @Test
  void threeNodesRightLeftHeavy() {
    final TreeNodeParentLinked<Integer> rootNode = new TreeNodeParentLinked<Integer>(1);
    final TreeNodeParentLinked<Integer> rightNode = new TreeNodeParentLinked<Integer>(3);
    rootNode.setRight(rightNode);
    final TreeNodeParentLinked<Integer> rightLeftNode = new TreeNodeParentLinked<Integer>(2);
    rightNode.setLeft(rightLeftNode);

    final TreeNodeParentLinked<Integer> rootNodeSuccessor = Successor.getSuccessor(rootNode);
    assertEquals(rightLeftNode, rootNodeSuccessor);
    final TreeNodeParentLinked<Integer> rightNodeSuccessor = Successor.getSuccessor(rightNode);
    assertNull(rightNodeSuccessor);
    final TreeNodeParentLinked<Integer> rightLeftNodeSuccessor =
        Successor.getSuccessor(rightLeftNode);
    assertEquals(rightNode, rightLeftNodeSuccessor);
  }

  @Test
  void threeNodesRightRightHeavy() {
    final TreeNodeParentLinked<Integer> rootNode = new TreeNodeParentLinked<Integer>(1);
    final TreeNodeParentLinked<Integer> rightNode = new TreeNodeParentLinked<Integer>(2);
    rootNode.setRight(rightNode);
    final TreeNodeParentLinked<Integer> rightRightNode = new TreeNodeParentLinked<Integer>(3);
    rightNode.setRight(rightRightNode);

    final TreeNodeParentLinked<Integer> rootNodeSuccessor = Successor.getSuccessor(rootNode);
    assertEquals(rightNode, rootNodeSuccessor);
    final TreeNodeParentLinked<Integer> rightNodeSuccessor = Successor.getSuccessor(rightNode);
    assertEquals(rightRightNode, rightNodeSuccessor);
    final TreeNodeParentLinked<Integer> rightRightNodeSuccessor =
        Successor.getSuccessor(rightRightNode);
    assertNull(rightRightNodeSuccessor);
  }

  @Test
  void fourNodesLeftLeftHeavy() {
    final TreeNodeParentLinked<Integer> rootNode = new TreeNodeParentLinked<Integer>(3);
    final TreeNodeParentLinked<Integer> leftNode = new TreeNodeParentLinked<Integer>(2);
    rootNode.setLeft(leftNode);
    final TreeNodeParentLinked<Integer> rightNode = new TreeNodeParentLinked<Integer>(4);
    rootNode.setRight(rightNode);
    final TreeNodeParentLinked<Integer> leftLeftNode = new TreeNodeParentLinked<Integer>(1);
    leftNode.setLeft(leftLeftNode);

    final TreeNodeParentLinked<Integer> rootNodeSuccessor = Successor.getSuccessor(rootNode);
    assertEquals(rightNode, rootNodeSuccessor);
    final TreeNodeParentLinked<Integer> leftNodeSuccessor = Successor.getSuccessor(leftNode);
    assertEquals(rootNode, leftNodeSuccessor);
    final TreeNodeParentLinked<Integer> rightNodeSuccessor = Successor.getSuccessor(rightNode);
    assertNull(rightNodeSuccessor);
    final TreeNodeParentLinked<Integer> leftLeftNodeSuccessor =
        Successor.getSuccessor(leftLeftNode);
    assertEquals(leftNode, leftLeftNodeSuccessor);
  }

  @Test
  void fourNodesLeftHeavy() {
    final TreeNodeParentLinked<Integer> rootNode = new TreeNodeParentLinked<Integer>(4);
    final TreeNodeParentLinked<Integer> leftNode = new TreeNodeParentLinked<Integer>(2);
    rootNode.setLeft(leftNode);
    final TreeNodeParentLinked<Integer> leftLeftNode = new TreeNodeParentLinked<Integer>(1);
    leftNode.setLeft(leftLeftNode);
    final TreeNodeParentLinked<Integer> leftRightNode = new TreeNodeParentLinked<Integer>(3);
    leftNode.setRight(leftRightNode);

    final TreeNodeParentLinked<Integer> rootNodeSuccessor = Successor.getSuccessor(rootNode);
    assertNull(rootNodeSuccessor);
    final TreeNodeParentLinked<Integer> leftNodeSuccessor = Successor.getSuccessor(leftNode);
    assertEquals(leftRightNode, leftNodeSuccessor);
    final TreeNodeParentLinked<Integer> leftLeftNodeSuccessor =
        Successor.getSuccessor(leftLeftNode);
    assertEquals(leftNode, leftLeftNodeSuccessor);
    final TreeNodeParentLinked<Integer> leftRightNodeSuccessor =
        Successor.getSuccessor(leftRightNode);
    assertEquals(rootNode, leftRightNodeSuccessor);
  }
}
