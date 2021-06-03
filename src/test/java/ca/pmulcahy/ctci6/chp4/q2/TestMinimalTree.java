package ca.pmulcahy.ctci6.chp4.q2;

import ca.pmulcahy.ctci6.chp4.TreeNode;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestMinimalTree {

	@Test
	public void zeroNodes() {
		final Integer[] inputArr = {};
		final List<Integer> inputList = Arrays.asList(inputArr);
		final TreeNode<Integer> rootNode = MinimalTree.buildBinaryTree(inputList);
		assertNull(rootNode);
	}

	@Test
	public void oneNode() {
		final Integer[] inputArr = {1};
		final List<Integer> inputList = Arrays.asList(inputArr);
		final TreeNode<Integer> rootNode = MinimalTree.buildBinaryTree(inputList);
		assertEquals(1, rootNode.getData());
		assertNull(rootNode.getLeft());
		assertNull(rootNode.getRight());
	}

	@Test
	public void twoNodes() {
		final Integer[] inputArr = {1, 2};
		final List<Integer> inputList = Arrays.asList(inputArr);
		final TreeNode<Integer> rootNode = MinimalTree.buildBinaryTree(inputList);
		assertEquals(2, rootNode.getData());
		final TreeNode<Integer> leftNode = rootNode.getLeft();
		assertEquals(1, leftNode.getData());
		assertNull(leftNode.getLeft());
		assertNull(leftNode.getRight());
		assertNull(rootNode.getRight());
	}
	
	@Test
	public void threeNodes() {
		final Integer[] inputArr = {1, 2, 3};
		final List<Integer> inputList = Arrays.asList(inputArr);
		final TreeNode<Integer> rootNode = MinimalTree.buildBinaryTree(inputList);
		assertEquals(2, rootNode.getData());
		final TreeNode<Integer> leftNode = rootNode.getLeft();
		assertEquals(1, leftNode.getData());
		assertNull(leftNode.getLeft());
		assertNull(leftNode.getRight());
		final TreeNode<Integer> rightNode = rootNode.getRight();
		assertEquals(3, rightNode.getData());
		assertNull(rightNode.getLeft());
		assertNull(rightNode.getRight());
	}
	
	@Test
	public void fourNodes() {
		final Integer[] inputArr = {1, 2, 3, 4};
		final List<Integer> inputList = Arrays.asList(inputArr);
		final TreeNode<Integer> rootNode = MinimalTree.buildBinaryTree(inputList);
		assertEquals(3, rootNode.getData());
		final TreeNode<Integer> leftNode = rootNode.getLeft();
		assertEquals(2, leftNode.getData());
		final TreeNode<Integer> leftLeftNode = leftNode.getLeft();
		assertEquals(1, leftLeftNode.getData());
		assertNull(leftLeftNode.getLeft());
		assertNull(leftLeftNode.getRight());
		assertNull(leftNode.getRight());
		final TreeNode<Integer> rightNode = rootNode.getRight();
		assertEquals(4, rightNode.getData());
		assertNull(rightNode.getLeft());
		assertNull(rightNode.getRight());
	}
	
	@Test
	public void fiveNodes() {
		final Integer[] inputArr = {1, 2, 3, 4, 5};
		final List<Integer> inputList = Arrays.asList(inputArr);
		final TreeNode<Integer> rootNode = MinimalTree.buildBinaryTree(inputList);
		assertEquals(3, rootNode.getData());
		final TreeNode<Integer> leftNode = rootNode.getLeft();
		assertEquals(2, leftNode.getData());
		final TreeNode<Integer> leftLeftNode = leftNode.getLeft();
		assertEquals(1, leftLeftNode.getData());
		assertNull(leftLeftNode.getLeft());
		assertNull(leftLeftNode.getRight());
		assertNull(leftNode.getRight());
		final TreeNode<Integer> rightNode = rootNode.getRight();
		assertEquals(5, rightNode.getData());
		final TreeNode<Integer> rightLeftNode = rightNode.getLeft();
		assertEquals(4, rightLeftNode.getData());
		assertNull(rightLeftNode.getLeft());
		assertNull(rightLeftNode.getRight());
		assertNull(rightNode.getRight());
	}
	
	@Test
	public void sixNodes() {
		final Integer[] inputArr = {1, 2, 3, 4, 5, 6};
		final List<Integer> inputList = Arrays.asList(inputArr);
		final TreeNode<Integer> rootNode = MinimalTree.buildBinaryTree(inputList);
		assertEquals(4, rootNode.getData());
		final TreeNode<Integer> leftNode = rootNode.getLeft();
		assertEquals(2, leftNode.getData());
		final TreeNode<Integer> leftLeftNode = leftNode.getLeft();
		assertEquals(1, leftLeftNode.getData());
		assertNull(leftLeftNode.getLeft());
		assertNull(leftLeftNode.getRight());
		final TreeNode<Integer> leftRightNode = leftNode.getRight();
		assertEquals(3, leftRightNode.getData());
		assertNull(leftRightNode.getLeft());
		assertNull(leftRightNode.getRight());		
		final TreeNode<Integer> rightNode = rootNode.getRight();
		assertEquals(6, rightNode.getData());
		final TreeNode<Integer> rightLeftNode = rightNode.getLeft();
		assertEquals(5, rightLeftNode.getData());
		assertNull(rightLeftNode.getLeft());
		assertNull(rightLeftNode.getRight());
		assertNull(rightNode.getRight());
	}
	
	@Test
	public void sevenNodes() {
		final Integer[] inputArr = {1, 2, 3, 4, 5, 6, 7};
		final List<Integer> inputList = Arrays.asList(inputArr);
		final TreeNode<Integer> rootNode = MinimalTree.buildBinaryTree(inputList);
		assertEquals(4, rootNode.getData());
		final TreeNode<Integer> leftNode = rootNode.getLeft();
		assertEquals(2, leftNode.getData());
		final TreeNode<Integer> leftLeftNode = leftNode.getLeft();
		assertEquals(1, leftLeftNode.getData());
		assertNull(leftLeftNode.getLeft());
		assertNull(leftLeftNode.getRight());
		final TreeNode<Integer> leftRightNode = leftNode.getRight();
		assertEquals(3, leftRightNode.getData());
		assertNull(leftRightNode.getLeft());
		assertNull(leftRightNode.getRight());		
		final TreeNode<Integer> rightNode = rootNode.getRight();
		assertEquals(6, rightNode.getData());
		final TreeNode<Integer> rightLeftNode = rightNode.getLeft();
		assertEquals(5, rightLeftNode.getData());
		assertNull(rightLeftNode.getLeft());
		assertNull(rightLeftNode.getRight());
		final TreeNode<Integer> rightRightNode = rightNode.getRight();
		assertEquals(7, rightRightNode.getData());
		assertNull(rightRightNode.getLeft());
		assertNull(rightRightNode.getRight());
	}

}
