package ca.pmulcahy.ctci6.chp4.q2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestMinimalTreeInt {

	@Test
	public void zeroNodes() {
		final int[] inputArr = {};
		TreeNodeInt rootNode = MinimalTreeInt.buildBinaryTree(inputArr);
		assertNull(rootNode);
	}

	@Test
	public void oneNode() {
		final int[] inputArr = {1};
		TreeNodeInt rootNode = MinimalTreeInt.buildBinaryTree(inputArr);
		assertEquals(1, rootNode.getData());
		assertNull(rootNode.getLeft());
		assertNull(rootNode.getRight());
	}

	@Test
	public void twoNodes() {
		final int[] inputArr = {1, 2};
		TreeNodeInt rootNode = MinimalTreeInt.buildBinaryTree(inputArr);
		assertEquals(2, rootNode.getData());
		TreeNodeInt leftNode = rootNode.getLeft();
		assertEquals(1, leftNode.getData());
		assertNull(leftNode.getLeft());
		assertNull(leftNode.getRight());
		assertNull(rootNode.getRight());
	}
	
	@Test
	public void threeNodes() {
		final int[] inputArr = {1, 2, 3};
		TreeNodeInt rootNode = MinimalTreeInt.buildBinaryTree(inputArr);
		assertEquals(2, rootNode.getData());
		TreeNodeInt leftNode = rootNode.getLeft();
		assertEquals(1, leftNode.getData());
		assertNull(leftNode.getLeft());
		assertNull(leftNode.getRight());
		TreeNodeInt rightNode = rootNode.getRight();
		assertEquals(3, rightNode.getData());
		assertNull(rightNode.getLeft());
		assertNull(rightNode.getRight());
	}
	
	@Test
	public void fourNodes() {
		final int[] inputArr = {1, 2, 3, 4};
		TreeNodeInt rootNode = MinimalTreeInt.buildBinaryTree(inputArr);
		assertEquals(3, rootNode.getData());
		TreeNodeInt leftNode = rootNode.getLeft();
		assertEquals(2, leftNode.getData());
		TreeNodeInt leftLeftNode = leftNode.getLeft();
		assertEquals(1, leftLeftNode.getData());
		assertNull(leftLeftNode.getLeft());
		assertNull(leftLeftNode.getRight());
		assertNull(leftNode.getRight());
		TreeNodeInt rightNode = rootNode.getRight();
		assertEquals(4, rightNode.getData());
		assertNull(rightNode.getLeft());
		assertNull(rightNode.getRight());
	}
	
	@Test
	public void fiveNodes() {
		final int[] inputArr = {1, 2, 3, 4, 5};
		TreeNodeInt rootNode = MinimalTreeInt.buildBinaryTree(inputArr);
		assertEquals(3, rootNode.getData());
		TreeNodeInt leftNode = rootNode.getLeft();
		assertEquals(2, leftNode.getData());
		TreeNodeInt leftLeftNode = leftNode.getLeft();
		assertEquals(1, leftLeftNode.getData());
		assertNull(leftLeftNode.getLeft());
		assertNull(leftLeftNode.getRight());
		assertNull(leftNode.getRight());
		TreeNodeInt rightNode = rootNode.getRight();
		assertEquals(5, rightNode.getData());
		TreeNodeInt rightLeftNode = rightNode.getLeft();
		assertEquals(4, rightLeftNode.getData());
		assertNull(rightLeftNode.getLeft());
		assertNull(rightLeftNode.getRight());
		assertNull(rightNode.getRight());
	}
	
	@Test
	public void sixNodes() {
		final int[] inputArr = {1, 2, 3, 4, 5, 6};
		TreeNodeInt rootNode = MinimalTreeInt.buildBinaryTree(inputArr);
		assertEquals(4, rootNode.getData());
		TreeNodeInt leftNode = rootNode.getLeft();
		assertEquals(2, leftNode.getData());
		TreeNodeInt leftLeftNode = leftNode.getLeft();
		assertEquals(1, leftLeftNode.getData());
		assertNull(leftLeftNode.getLeft());
		assertNull(leftLeftNode.getRight());
		TreeNodeInt leftRightNode = leftNode.getRight();
		assertEquals(3, leftRightNode.getData());
		assertNull(leftRightNode.getLeft());
		assertNull(leftRightNode.getRight());		
		TreeNodeInt rightNode = rootNode.getRight();
		assertEquals(6, rightNode.getData());
		TreeNodeInt rightLeftNode = rightNode.getLeft();
		assertEquals(5, rightLeftNode.getData());
		assertNull(rightLeftNode.getLeft());
		assertNull(rightLeftNode.getRight());
		assertNull(rightNode.getRight());
	}
	
	@Test
	public void sevenNodes() {
		final int[] inputArr = {1, 2, 3, 4, 5, 6, 7};
		TreeNodeInt rootNode = MinimalTreeInt.buildBinaryTree(inputArr);
		assertEquals(4, rootNode.getData());
		TreeNodeInt leftNode = rootNode.getLeft();
		assertEquals(2, leftNode.getData());
		TreeNodeInt leftLeftNode = leftNode.getLeft();
		assertEquals(1, leftLeftNode.getData());
		assertNull(leftLeftNode.getLeft());
		assertNull(leftLeftNode.getRight());
		TreeNodeInt leftRightNode = leftNode.getRight();
		assertEquals(3, leftRightNode.getData());
		assertNull(leftRightNode.getLeft());
		assertNull(leftRightNode.getRight());		
		TreeNodeInt rightNode = rootNode.getRight();
		assertEquals(6, rightNode.getData());
		TreeNodeInt rightLeftNode = rightNode.getLeft();
		assertEquals(5, rightLeftNode.getData());
		assertNull(rightLeftNode.getLeft());
		assertNull(rightLeftNode.getRight());
		TreeNodeInt rightRightNode = rightNode.getRight();
		assertEquals(7, rightRightNode.getData());
		assertNull(rightRightNode.getLeft());
		assertNull(rightRightNode.getRight());
	}

}
