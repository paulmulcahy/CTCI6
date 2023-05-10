package ca.pmulcahy.ctci6.chp04.q03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ca.pmulcahy.ctci6.chp04.TreeNode;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestListOfDepths_BreadthFirstSearch {

  @Test
  public void zeroNodes() {
    final TreeNode<Integer> rootNode = null;
    final List<LinkedList<TreeNode<Integer>>> listOfNodes =
        ListOfDepths_BreadthFirstSearch.getListOfDepths(rootNode);
    assertEquals(0, listOfNodes.size());
  }

  @Test
  public void oneNode() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final List<LinkedList<TreeNode<Integer>>> listOfNodes =
        ListOfDepths_BreadthFirstSearch.getListOfDepths(rootNode);
    assertEquals(1, listOfNodes.size());
    assertEquals(1, listOfNodes.get(0).size());
    assertEquals(1, listOfNodes.get(0).get(0).getData());
  }

  @Test
  public void twoNodesLeftHeavy() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(2);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
    rootNode.setLeft(leftNode);
    final List<LinkedList<TreeNode<Integer>>> listOfNodes =
        ListOfDepths_BreadthFirstSearch.getListOfDepths(rootNode);
    assertEquals(2, listOfNodes.size());
    assertEquals(1, listOfNodes.get(0).size());
    assertEquals(2, listOfNodes.get(0).get(0).getData());
    assertEquals(1, listOfNodes.get(1).size());
    assertEquals(1, listOfNodes.get(1).get(0).getData());
  }

  @Test
  public void twoNodesRightHeavy() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(2);
    rootNode.setRight(rightNode);
    final List<LinkedList<TreeNode<Integer>>> listOfNodes =
        ListOfDepths_BreadthFirstSearch.getListOfDepths(rootNode);
    assertEquals(2, listOfNodes.size());
    assertEquals(1, listOfNodes.get(0).size());
    assertEquals(1, listOfNodes.get(0).get(0).getData());
    assertEquals(1, listOfNodes.get(1).size());
    assertEquals(2, listOfNodes.get(1).get(0).getData());
  }

  @Test
  public void threeNodesBalanced() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(2);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(3);
    rootNode.setRight(rightNode);
    final List<LinkedList<TreeNode<Integer>>> listOfNodes =
        ListOfDepths_BreadthFirstSearch.getListOfDepths(rootNode);
    assertEquals(2, listOfNodes.size());
    assertEquals(1, listOfNodes.get(0).size());
    assertEquals(2, listOfNodes.get(0).get(0).getData());
    assertEquals(2, listOfNodes.get(1).size());
    assertEquals(1, listOfNodes.get(1).get(0).getData());
    assertEquals(3, listOfNodes.get(1).get(1).getData());
  }

  @Test
  public void threeNodesLeftLeftHeavy() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(1);
    leftNode.setLeft(leftLeftNode);
    final List<LinkedList<TreeNode<Integer>>> listOfNodes =
        ListOfDepths_BreadthFirstSearch.getListOfDepths(rootNode);
    assertEquals(3, listOfNodes.size());
    assertEquals(1, listOfNodes.get(0).size());
    assertEquals(3, listOfNodes.get(0).get(0).getData());
    assertEquals(1, listOfNodes.get(1).size());
    assertEquals(2, listOfNodes.get(1).get(0).getData());
    assertEquals(1, listOfNodes.get(2).size());
    assertEquals(1, listOfNodes.get(2).get(0).getData());
  }

  @Test
  public void threeNodesLeftRightHeavy() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> leftRightNode = new TreeNode<Integer>(2);
    leftNode.setRight(leftRightNode);
    final List<LinkedList<TreeNode<Integer>>> listOfNodes =
        ListOfDepths_BreadthFirstSearch.getListOfDepths(rootNode);
    assertEquals(3, listOfNodes.size());
    assertEquals(1, listOfNodes.get(0).size());
    assertEquals(3, listOfNodes.get(0).get(0).getData());
    assertEquals(1, listOfNodes.get(1).size());
    assertEquals(1, listOfNodes.get(1).get(0).getData());
    assertEquals(1, listOfNodes.get(2).size());
    assertEquals(2, listOfNodes.get(2).get(0).getData());
  }

  @Test
  public void threeNodesRightLeftHeavy() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(3);
    rootNode.setRight(rightNode);
    final TreeNode<Integer> rightLeftNode = new TreeNode<Integer>(2);
    rightNode.setLeft(rightLeftNode);
    final List<LinkedList<TreeNode<Integer>>> listOfNodes =
        ListOfDepths_BreadthFirstSearch.getListOfDepths(rootNode);
    assertEquals(3, listOfNodes.size());
    assertEquals(1, listOfNodes.get(0).size());
    assertEquals(1, listOfNodes.get(0).get(0).getData());
    assertEquals(1, listOfNodes.get(1).size());
    assertEquals(3, listOfNodes.get(1).get(0).getData());
    assertEquals(1, listOfNodes.get(2).size());
    assertEquals(2, listOfNodes.get(2).get(0).getData());
  }

  @Test
  public void threeNodesRightRightHeavy() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(2);
    rootNode.setRight(rightNode);
    final TreeNode<Integer> rightRightNode = new TreeNode<Integer>(3);
    rightNode.setRight(rightRightNode);
    final List<LinkedList<TreeNode<Integer>>> listOfNodes =
        ListOfDepths_BreadthFirstSearch.getListOfDepths(rootNode);
    assertEquals(3, listOfNodes.size());
    assertEquals(1, listOfNodes.get(0).size());
    assertEquals(1, listOfNodes.get(0).get(0).getData());
    assertEquals(1, listOfNodes.get(1).size());
    assertEquals(2, listOfNodes.get(1).get(0).getData());
    assertEquals(1, listOfNodes.get(2).size());
    assertEquals(3, listOfNodes.get(2).get(0).getData());
  }

  @Test
  public void fourNodesLeftLeftHeavy() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> rightNode = new TreeNode<Integer>(4);
    rootNode.setRight(rightNode);
    final TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(1);
    leftNode.setLeft(leftLeftNode);
    final List<LinkedList<TreeNode<Integer>>> listOfNodes =
        ListOfDepths_BreadthFirstSearch.getListOfDepths(rootNode);
    assertEquals(3, listOfNodes.size());
    assertEquals(1, listOfNodes.get(0).size());
    assertEquals(3, listOfNodes.get(0).get(0).getData());
    assertEquals(2, listOfNodes.get(1).size());
    assertEquals(2, listOfNodes.get(1).get(0).getData());
    assertEquals(4, listOfNodes.get(1).get(1).getData());
    assertEquals(1, listOfNodes.get(2).size());
    assertEquals(1, listOfNodes.get(2).get(0).getData());
  }

  @Test
  public void fourNodesLeftHeavy() {
    final TreeNode<Integer> rootNode = new TreeNode<Integer>(4);
    final TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
    rootNode.setLeft(leftNode);
    final TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(1);
    leftNode.setLeft(leftLeftNode);
    final TreeNode<Integer> leftRightNode = new TreeNode<Integer>(3);
    leftNode.setRight(leftRightNode);
    final List<LinkedList<TreeNode<Integer>>> listOfNodes =
        ListOfDepths_BreadthFirstSearch.getListOfDepths(rootNode);
    assertEquals(3, listOfNodes.size());
    assertEquals(1, listOfNodes.get(0).size());
    assertEquals(4, listOfNodes.get(0).get(0).getData());
    assertEquals(1, listOfNodes.get(1).size());
    assertEquals(2, listOfNodes.get(1).get(0).getData());
    assertEquals(2, listOfNodes.get(2).size());
    assertEquals(1, listOfNodes.get(2).get(0).getData());
    assertEquals(3, listOfNodes.get(2).get(1).getData());
  }
}
