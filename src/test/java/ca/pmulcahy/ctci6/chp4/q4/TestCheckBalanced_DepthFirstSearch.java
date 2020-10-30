package ca.pmulcahy.ctci6.chp4.q4;

import ca.pmulcahy.ctci6.chp4.TreeNode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestCheckBalanced_DepthFirstSearch {

	@Test
	public void zeroNodes() {
		TreeNode<Integer> rootNode = null;
		boolean balanced = CheckBalanced_DepthFirstSearch.isBalanced(rootNode);
		assertTrue(balanced);
	}

	@Test
	public void oneNode() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
		boolean balanced = CheckBalanced_DepthFirstSearch.isBalanced(rootNode);
		assertTrue(balanced);
	}
	
	@Test
	public void twoNodesLeftHeavy() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(2);
		TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
		rootNode.setLeft(leftNode);		
		boolean balanced = CheckBalanced_DepthFirstSearch.isBalanced(rootNode);
		assertTrue(balanced);		
	}

	@Test
	public void twoNodesRightHeavy() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
		TreeNode<Integer> rightNode = new TreeNode<Integer>(2);
		rootNode.setRight(rightNode);		
		boolean balanced = CheckBalanced_DepthFirstSearch.isBalanced(rootNode);
		assertTrue(balanced);	
	}
	
	@Test
	public void threeNodesBalanced() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(2);
		TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
		rootNode.setLeft(leftNode);
		TreeNode<Integer> rightNode = new TreeNode<Integer>(3);
		rootNode.setRight(rightNode);
		boolean balanced = CheckBalanced_DepthFirstSearch.isBalanced(rootNode);
		assertTrue(balanced);	
	}
	
	@Test
	public void threeNodesLeftLeftHeavy() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
		TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
		rootNode.setLeft(leftNode);
		TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(1);
		leftNode.setLeft(leftLeftNode);
		boolean balanced = CheckBalanced_DepthFirstSearch.isBalanced(rootNode);
		assertFalse(balanced);		
	}	

	@Test
	public void threeNodesLeftRightHeavy() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
		TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
		rootNode.setLeft(leftNode);
		TreeNode<Integer> leftRightNode = new TreeNode<Integer>(2);
		leftNode.setRight(leftRightNode);
		boolean balanced = CheckBalanced_DepthFirstSearch.isBalanced(rootNode);
		assertFalse(balanced);		
	}

	@Test
	public void threeNodesRightLeftHeavy() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
		TreeNode<Integer> rightNode = new TreeNode<Integer>(3);
		rootNode.setRight(rightNode);
		TreeNode<Integer> rightLeftNode = new TreeNode<Integer>(2);
		rightNode.setLeft(rightLeftNode);
		boolean balanced = CheckBalanced_DepthFirstSearch.isBalanced(rootNode);
		assertFalse(balanced);			
	}

	@Test
	public void threeNodesRightRightHeavy() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
		TreeNode<Integer> rightNode = new TreeNode<Integer>(2);
		rootNode.setRight(rightNode);
		TreeNode<Integer> rightRightNode = new TreeNode<Integer>(3);
		rightNode.setRight(rightRightNode);
		boolean balanced = CheckBalanced_DepthFirstSearch.isBalanced(rootNode);
		assertFalse(balanced);		
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
		boolean balanced = CheckBalanced_DepthFirstSearch.isBalanced(rootNode);
		assertTrue(balanced);	
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
		boolean balanced = CheckBalanced_DepthFirstSearch.isBalanced(rootNode);
		assertFalse(balanced);
	}
}
