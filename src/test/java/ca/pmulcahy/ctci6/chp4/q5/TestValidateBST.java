package ca.pmulcahy.ctci6.chp4.q5;

import ca.pmulcahy.ctci6.chp4.TreeNode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestValidateBST {

	@Test
	public void zeroNodes() {
		TreeNode<Integer> rootNode = null;
		boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
		assertTrue(validBST);
	}

	@Test
	public void oneNode() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
		boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
		assertTrue(validBST);
	}
	
	@Test
	public void twoNodesLeftHeavyValid() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(2);
		TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
		rootNode.setLeft(leftNode);		
		boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
		assertTrue(validBST);		
	}
	
	@Test
	public void twoNodesLeftHeavyEqual() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
		TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
		rootNode.setLeft(leftNode);		
		boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
		assertTrue(validBST);		
	}
	
	@Test
	public void twoNodesLeftHeavyInvalid() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
		TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
		rootNode.setLeft(leftNode);		
		boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
		assertFalse(validBST);		
	}

	@Test
	public void twoNodesRightHeavyValid() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
		TreeNode<Integer> rightNode = new TreeNode<Integer>(2);
		rootNode.setRight(rightNode);		
		boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
		assertTrue(validBST);
	}
	
	@Test
	public void twoNodesRightHeavyInvalid() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(2);
		TreeNode<Integer> rightNode = new TreeNode<Integer>(1);
		rootNode.setRight(rightNode);		
		boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
		assertFalse(validBST);
	}
	
	@Test
	public void twoNodesRightHeavyEqual() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
		TreeNode<Integer> rightNode = new TreeNode<Integer>(1);
		rootNode.setRight(rightNode);		
		boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
		assertFalse(validBST);
	}
	
	@Test
	public void threeNodesBalancedValid() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(2);
		TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
		rootNode.setLeft(leftNode);
		TreeNode<Integer> rightNode = new TreeNode<Integer>(3);
		rootNode.setRight(rightNode);
		boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
		assertTrue(validBST);	
	}
	
	@Test
	public void threeNodesBalancedInvalid() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(2);
		TreeNode<Integer> leftNode = new TreeNode<Integer>(3);
		rootNode.setLeft(leftNode);
		TreeNode<Integer> rightNode = new TreeNode<Integer>(1);
		rootNode.setRight(rightNode);
		boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
		assertFalse(validBST);	
	}
	
	@Test
	public void threeNodesLeftLeftHeavyValid() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
		TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
		rootNode.setLeft(leftNode);
		TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(1);
		leftNode.setLeft(leftLeftNode);
		boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
		assertTrue(validBST);		
	}	

	@Test
	public void threeNodesLeftLeftHeavyInvalid() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
		TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
		rootNode.setLeft(leftNode);
		TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(2);
		leftNode.setLeft(leftLeftNode);
		boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
		assertFalse(validBST);		
	}

	@Test
	public void threeNodesLeftRightHeavyValid() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
		TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
		rootNode.setLeft(leftNode);
		TreeNode<Integer> leftRightNode = new TreeNode<Integer>(2);
		leftNode.setRight(leftRightNode);
		boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
		assertTrue(validBST);		
	}
	
	@Test
	public void threeNodesLeftRightHeavyInvalid() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
		TreeNode<Integer> leftNode = new TreeNode<Integer>(1);
		rootNode.setLeft(leftNode);
		TreeNode<Integer> leftRightNode = new TreeNode<Integer>(1);
		leftNode.setRight(leftRightNode);
		boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
		assertFalse(validBST);		
	}

	@Test
	public void threeNodesRightLeftHeavyValid() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
		TreeNode<Integer> rightNode = new TreeNode<Integer>(3);
		rootNode.setRight(rightNode);
		TreeNode<Integer> rightLeftNode = new TreeNode<Integer>(2);
		rightNode.setLeft(rightLeftNode);
		boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
		assertTrue(validBST);			
	}

	@Test
	public void threeNodesRightLeftHeavyInvalid() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
		TreeNode<Integer> rightNode = new TreeNode<Integer>(2);
		rootNode.setRight(rightNode);
		TreeNode<Integer> rightLeftNode = new TreeNode<Integer>(3);
		rightNode.setLeft(rightLeftNode);
		boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
		assertFalse(validBST);			
	}

	@Test
	public void threeNodesRightRightHeavyValid() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
		TreeNode<Integer> rightNode = new TreeNode<Integer>(2);
		rootNode.setRight(rightNode);
		TreeNode<Integer> rightRightNode = new TreeNode<Integer>(3);
		rightNode.setRight(rightRightNode);
		boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
		assertTrue(validBST);	
	}
	
	@Test
	public void threeNodesRightRightHeavyInvalid() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(1);
		TreeNode<Integer> rightNode = new TreeNode<Integer>(1);
		rootNode.setRight(rightNode);
		TreeNode<Integer> rightRightNode = new TreeNode<Integer>(1);
		rightNode.setRight(rightRightNode);
		boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
		assertFalse(validBST);	
	}

	@Test
	public void fourNodesLeftLeftHeavyValid() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
		TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
		rootNode.setLeft(leftNode);
		TreeNode<Integer> rightNode = new TreeNode<Integer>(4);
		rootNode.setRight(rightNode);
		TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(1);
		leftNode.setLeft(leftLeftNode);
		boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
		assertTrue(validBST);	
	}
	
	@Test
	public void fourNodesLeftLeftHeavyInvalid() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(3);
		TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
		rootNode.setLeft(leftNode);
		TreeNode<Integer> rightNode = new TreeNode<Integer>(3);
		rootNode.setRight(rightNode);
		TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(1);
		leftNode.setLeft(leftLeftNode);
		boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
		assertFalse(validBST);	
	}
	
	@Test
	public void fourNodesLeftHeavyValid() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(4);
		TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
		rootNode.setLeft(leftNode);
		TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(1);
		leftNode.setLeft(leftLeftNode);
		TreeNode<Integer> leftRightNode = new TreeNode<Integer>(3);
		leftNode.setRight(leftRightNode);
		boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
		assertTrue(validBST);
	}
	
	@Test
	public void fourNodesLeftHeavyInvalid() {
		TreeNode<Integer> rootNode = new TreeNode<Integer>(4);
		TreeNode<Integer> leftNode = new TreeNode<Integer>(2);
		rootNode.setLeft(leftNode);
		TreeNode<Integer> leftLeftNode = new TreeNode<Integer>(2);
		leftNode.setLeft(leftLeftNode);
		TreeNode<Integer> leftRightNode = new TreeNode<Integer>(2);
		leftNode.setRight(leftRightNode);
		boolean validBST = ValidateBST.isBinarySearchTree(rootNode);
		assertFalse(validBST);
	}
}
