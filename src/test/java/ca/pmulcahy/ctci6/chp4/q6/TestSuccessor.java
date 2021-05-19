package ca.pmulcahy.ctci6.chp4.q6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestSuccessor {

	@Test
	public void zeroNodes() {
		TreeNodeParentLinked<Integer> rootNode = null;
		TreeNodeParentLinked<Integer> rootNodeSuccessor = Successor.getSuccessor(rootNode);
		assertNull(rootNodeSuccessor);
	}

	@Test
	public void oneNode() {
		TreeNodeParentLinked<Integer> rootNode = new TreeNodeParentLinked<Integer>(1);
		TreeNodeParentLinked<Integer> rootNodeSuccessor = Successor.getSuccessor(rootNode);
		assertNull(rootNodeSuccessor);
	}
	
	@Test
	public void twoNodesLeftHeavy() {
		TreeNodeParentLinked<Integer> rootNode = new TreeNodeParentLinked<Integer>(2);
		TreeNodeParentLinked<Integer> leftNode = new TreeNodeParentLinked<Integer>(1);
		rootNode.setLeft(leftNode);
		TreeNodeParentLinked<Integer> rootNodeSuccessor = Successor.getSuccessor(rootNode);
		assertNull(rootNodeSuccessor);
		TreeNodeParentLinked<Integer> leftNodeSuccessor = Successor.getSuccessor(leftNode);
		assertEquals(rootNode, leftNodeSuccessor);		
	}	

	@Test
	public void twoNodesRightHeavy() {
		TreeNodeParentLinked<Integer> rootNode = new TreeNodeParentLinked<Integer>(1);
		TreeNodeParentLinked<Integer> rightNode = new TreeNodeParentLinked<Integer>(2);
		rootNode.setRight(rightNode);		
		TreeNodeParentLinked<Integer> rootNodeSuccessor = Successor.getSuccessor(rootNode);
		assertEquals(rightNode, rootNodeSuccessor);
		TreeNodeParentLinked<Integer> rightNodeSuccessor = Successor.getSuccessor(rightNode);
		assertNull(rightNodeSuccessor);
	}
	
	@Test
	public void threeNodesBalanced() {
		TreeNodeParentLinked<Integer> rootNode = new TreeNodeParentLinked<Integer>(2);
		TreeNodeParentLinked<Integer> leftNode = new TreeNodeParentLinked<Integer>(1);
		rootNode.setLeft(leftNode);
		TreeNodeParentLinked<Integer> rightNode = new TreeNodeParentLinked<Integer>(3);
		rootNode.setRight(rightNode);
		
		TreeNodeParentLinked<Integer> rootNodeSuccessor = Successor.getSuccessor(rootNode);
		assertEquals(rightNode, rootNodeSuccessor);
		TreeNodeParentLinked<Integer> leftNodeSuccessor = Successor.getSuccessor(leftNode);
		assertEquals(rootNode, leftNodeSuccessor);	
		TreeNodeParentLinked<Integer> rightNodeSuccessor = Successor.getSuccessor(rightNode);
		assertNull(rightNodeSuccessor);
	}
	
	@Test
	public void threeNodesLeftLeftHeavy() {
		TreeNodeParentLinked<Integer> rootNode = new TreeNodeParentLinked<Integer>(3);
		TreeNodeParentLinked<Integer> leftNode = new TreeNodeParentLinked<Integer>(2);
		rootNode.setLeft(leftNode);
		TreeNodeParentLinked<Integer> leftLeftNode = new TreeNodeParentLinked<Integer>(1);
		leftNode.setLeft(leftLeftNode);

		TreeNodeParentLinked<Integer> rootNodeSuccessor = Successor.getSuccessor(rootNode);
		assertNull(rootNodeSuccessor);
		TreeNodeParentLinked<Integer> leftNodeSuccessor = Successor.getSuccessor(leftNode);
		assertEquals(rootNode, leftNodeSuccessor);	
		TreeNodeParentLinked<Integer> leftLeftNodeSuccessor = Successor.getSuccessor(leftLeftNode);
		assertEquals(leftNode, leftLeftNodeSuccessor);		
	}	

	@Test
	public void threeNodesLeftRightHeavy() {
		TreeNodeParentLinked<Integer> rootNode = new TreeNodeParentLinked<Integer>(3);
		TreeNodeParentLinked<Integer> leftNode = new TreeNodeParentLinked<Integer>(1);
		rootNode.setLeft(leftNode);
		TreeNodeParentLinked<Integer> leftRightNode = new TreeNodeParentLinked<Integer>(2);
		leftNode.setRight(leftRightNode);

		TreeNodeParentLinked<Integer> rootNodeSuccessor = Successor.getSuccessor(rootNode);
		assertNull(rootNodeSuccessor);
		TreeNodeParentLinked<Integer> leftNodeSuccessor = Successor.getSuccessor(leftNode);
		assertEquals(leftRightNode, leftNodeSuccessor);	
		TreeNodeParentLinked<Integer> leftRightNodeSuccessor = Successor.getSuccessor(leftRightNode);
		assertEquals(rootNode, leftRightNodeSuccessor);		
	}
	

	@Test
	public void threeNodesRightLeftHeavy() {
		TreeNodeParentLinked<Integer> rootNode = new TreeNodeParentLinked<Integer>(1);
		TreeNodeParentLinked<Integer> rightNode = new TreeNodeParentLinked<Integer>(3);
		rootNode.setRight(rightNode);
		TreeNodeParentLinked<Integer> rightLeftNode = new TreeNodeParentLinked<Integer>(2);
		rightNode.setLeft(rightLeftNode);

		TreeNodeParentLinked<Integer> rootNodeSuccessor = Successor.getSuccessor(rootNode);
		assertEquals(rightLeftNode, rootNodeSuccessor);
		TreeNodeParentLinked<Integer> rightNodeSuccessor = Successor.getSuccessor(rightNode);
		assertNull(rightNodeSuccessor);	
		TreeNodeParentLinked<Integer> rightLeftNodeSuccessor = Successor.getSuccessor(rightLeftNode);
		assertEquals(rightNode, rightLeftNodeSuccessor);		
	}


	@Test
	public void threeNodesRightRightHeavy() {
		TreeNodeParentLinked<Integer> rootNode = new TreeNodeParentLinked<Integer>(1);
		TreeNodeParentLinked<Integer> rightNode = new TreeNodeParentLinked<Integer>(2);
		rootNode.setRight(rightNode);
		TreeNodeParentLinked<Integer> rightRightNode = new TreeNodeParentLinked<Integer>(3);
		rightNode.setRight(rightRightNode);

		TreeNodeParentLinked<Integer> rootNodeSuccessor = Successor.getSuccessor(rootNode);
		assertEquals(rightNode, rootNodeSuccessor);
		TreeNodeParentLinked<Integer> rightNodeSuccessor = Successor.getSuccessor(rightNode);
		assertEquals(rightRightNode, rightNodeSuccessor);	
		TreeNodeParentLinked<Integer> rightRightNodeSuccessor = Successor.getSuccessor(rightRightNode);
		assertNull(rightRightNodeSuccessor);	
	}	

	@Test
	public void fourNodesLeftLeftHeavy() {
		TreeNodeParentLinked<Integer> rootNode = new TreeNodeParentLinked<Integer>(3);
		TreeNodeParentLinked<Integer> leftNode = new TreeNodeParentLinked<Integer>(2);
		rootNode.setLeft(leftNode);
		TreeNodeParentLinked<Integer> rightNode = new TreeNodeParentLinked<Integer>(4);
		rootNode.setRight(rightNode);
		TreeNodeParentLinked<Integer> leftLeftNode = new TreeNodeParentLinked<Integer>(1);
		leftNode.setLeft(leftLeftNode);

		TreeNodeParentLinked<Integer> rootNodeSuccessor = Successor.getSuccessor(rootNode);
		assertEquals(rightNode, rootNodeSuccessor);
		TreeNodeParentLinked<Integer> leftNodeSuccessor = Successor.getSuccessor(leftNode);
		assertEquals(rootNode, leftNodeSuccessor);	
		TreeNodeParentLinked<Integer> rightNodeSuccessor = Successor.getSuccessor(rightNode);
		assertNull(rightNodeSuccessor);
		TreeNodeParentLinked<Integer> leftLeftNodeSuccessor = Successor.getSuccessor(leftLeftNode);
		assertEquals(leftNode, leftLeftNodeSuccessor);	
	}
	
	@Test
	public void fourNodesLeftHeavy() {
		TreeNodeParentLinked<Integer> rootNode = new TreeNodeParentLinked<Integer>(4);
		TreeNodeParentLinked<Integer> leftNode = new TreeNodeParentLinked<Integer>(2);
		rootNode.setLeft(leftNode);
		TreeNodeParentLinked<Integer> leftLeftNode = new TreeNodeParentLinked<Integer>(1);
		leftNode.setLeft(leftLeftNode);
		TreeNodeParentLinked<Integer> leftRightNode = new TreeNodeParentLinked<Integer>(3);
		leftNode.setRight(leftRightNode);

		TreeNodeParentLinked<Integer> rootNodeSuccessor = Successor.getSuccessor(rootNode);
		assertNull(rootNodeSuccessor);
		TreeNodeParentLinked<Integer> leftNodeSuccessor = Successor.getSuccessor(leftNode);
		assertEquals(leftRightNode, leftNodeSuccessor);	
		TreeNodeParentLinked<Integer> leftLeftNodeSuccessor = Successor.getSuccessor(leftLeftNode);
		assertEquals(leftNode, leftLeftNodeSuccessor);	
		TreeNodeParentLinked<Integer> leftRightNodeSuccessor = Successor.getSuccessor(leftRightNode);
		assertEquals(rootNode, leftRightNodeSuccessor);	
	}
	
}
