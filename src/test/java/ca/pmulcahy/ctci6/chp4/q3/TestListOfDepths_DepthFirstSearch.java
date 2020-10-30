package ca.pmulcahy.ctci6.chp4.q3;

import ca.pmulcahy.ctci6.chp4.TreeNode;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestListOfDepths_DepthFirstSearch {

	@Test
	public void zeroNodes() {
		TreeNode<Integer> rootNode = null;
		List<LinkedList<TreeNode<Integer>>> listOfNodes = ListOfDepths_DepthFirstSearch.getListOfDepths(rootNode);
		assertEquals(0, listOfNodes.size());
	}

	@Test
	public void oneNode() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
		List<LinkedList<TreeNode<Integer>>> listOfNodes = ListOfDepths_DepthFirstSearch.getListOfDepths(rootNode);
		assertEquals(1, listOfNodes.size());
		assertEquals(1, listOfNodes.get(0).size());
		assertEquals(1, listOfNodes.get(0).get(0).getData());
	}
	
	@Test
	public void twoNodesLeftHeavy() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(2);
		TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
		rootNode.setLeft(leftNode);		
		List<LinkedList<TreeNode<Integer>>> listOfNodes = ListOfDepths_DepthFirstSearch.getListOfDepths(rootNode);
		assertEquals(2, listOfNodes.size());
		assertEquals(1, listOfNodes.get(0).size());
		assertEquals(2, listOfNodes.get(0).get(0).getData());
		assertEquals(1, listOfNodes.get(1).size());
		assertEquals(1, listOfNodes.get(1).get(0).getData());		
	}

	@Test
	public void twoNodesRightHeavy() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
		TreeNode<Integer> rightNode = new TreeNode<Integer>(2);
		rootNode.setRight(rightNode);		
		List<LinkedList<TreeNode<Integer>>> listOfNodes = ListOfDepths_DepthFirstSearch.getListOfDepths(rootNode);
		assertEquals(2, listOfNodes.size());
		assertEquals(1, listOfNodes.get(0).size());
		assertEquals(1, listOfNodes.get(0).get(0).getData());
		assertEquals(1, listOfNodes.get(1).size());
		assertEquals(2, listOfNodes.get(1).get(0).getData());		
	}
	
	@Test
	public void threeNodesBalanced() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(2);
		TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
		rootNode.setLeft(leftNode);
		TreeNode<Integer> rightNode = new TreeNode<Integer>(3);
		rootNode.setRight(rightNode);
		List<LinkedList<TreeNode<Integer>>> listOfNodes = ListOfDepths_DepthFirstSearch.getListOfDepths(rootNode);
		assertEquals(2, listOfNodes.size());
		assertEquals(1, listOfNodes.get(0).size());
		assertEquals(2, listOfNodes.get(0).get(0).getData());
		assertEquals(2, listOfNodes.get(1).size());
		assertEquals(1, listOfNodes.get(1).get(0).getData());
		assertEquals(3, listOfNodes.get(1).get(1).getData());		
	}
	
	@Test
	public void threeNodesLeftLeftHeavy() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
		TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
		rootNode.setLeft(leftNode);
		TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(1);
		leftNode.setLeft(leftLeftNode);
		List<LinkedList<TreeNode<Integer>>> listOfNodes = ListOfDepths_DepthFirstSearch.getListOfDepths(rootNode);
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
		TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
		TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
		rootNode.setLeft(leftNode);
		TreeNode<Integer> leftRightNode = new TreeNode<Integer>(2);
		leftNode.setRight(leftRightNode);
		List<LinkedList<TreeNode<Integer>>> listOfNodes = ListOfDepths_DepthFirstSearch.getListOfDepths(rootNode);
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
		TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
		TreeNode<Integer> rightNode = new TreeNode<Integer>(3);
		rootNode.setRight(rightNode);
		TreeNode<Integer> rightLeftNode = new TreeNode<Integer>(2);
		rightNode.setLeft(rightLeftNode);
		List<LinkedList<TreeNode<Integer>>> listOfNodes = ListOfDepths_DepthFirstSearch.getListOfDepths(rootNode);
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
		TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
		TreeNode<Integer> rightNode = new TreeNode<Integer>(2);
		rootNode.setRight(rightNode);
		TreeNode<Integer> rightRightNode = new TreeNode<Integer>(3);
		rightNode.setRight(rightRightNode);
		List<LinkedList<TreeNode<Integer>>> listOfNodes = ListOfDepths_DepthFirstSearch.getListOfDepths(rootNode);
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
		TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
		TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
		rootNode.setLeft(leftNode);
		TreeNode<Integer> rightNode = new TreeNode<Integer>(4);
		rootNode.setRight(rightNode);
		TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(1);
		leftNode.setLeft(leftLeftNode);
		List<LinkedList<TreeNode<Integer>>> listOfNodes = ListOfDepths_DepthFirstSearch.getListOfDepths(rootNode);
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
		TreeNode<Integer> rootNode = new TreeNode<Integer>(4);
		TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
		rootNode.setLeft(leftNode);
		TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(1);
		leftNode.setLeft(leftLeftNode);
		TreeNode<Integer> leftRightNode = new TreeNode<Integer>(3);
		leftNode.setRight(leftRightNode);
		List<LinkedList<TreeNode<Integer>>> listOfNodes = ListOfDepths_DepthFirstSearch.getListOfDepths(rootNode);
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
