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
		List<Integer> inputList = Arrays.asList(inputArr);
		TreeNode<Integer> rootNode = MinimalTree.buildBinaryTree(inputList);
		assertNull(rootNode);
	}

	@Test
	public void oneNode() {
		final Integer[] inputArr = {1};
		List<Integer> inputList = Arrays.asList(inputArr);
		TreeNode<Integer> rootNode = MinimalTree.buildBinaryTree(inputList);
		assertEquals(1, rootNode.getData());
		assertNull(rootNode.getLeft());
		assertNull(rootNode.getRight());
	}

	@Test
	public void twoNodes() {
		final Integer[] inputArr = {1, 2};
		List<Integer> inputList = Arrays.asList(inputArr);
		TreeNode<Integer> rootNode = MinimalTree.buildBinaryTree(inputList);
		assertEquals(2, rootNode.getData());
		TreeNode<Integer> leftNode = rootNode.getLeft();
		assertEquals(1, leftNode.getData());
		assertNull(leftNode.getLeft());
		assertNull(leftNode.getRight());
		assertNull(rootNode.getRight());
	}
	
	@Test
	public void threeNodes() {
		final Integer[] inputArr = {1, 2, 3};
		List<Integer> inputList = Arrays.asList(inputArr);
		TreeNode<Integer> rootNode = MinimalTree.buildBinaryTree(inputList);
		assertEquals(2, rootNode.getData());
		TreeNode<Integer> leftNode = rootNode.getLeft();
		assertEquals(1, leftNode.getData());
		assertNull(leftNode.getLeft());
		assertNull(leftNode.getRight());
		TreeNode<Integer> rightNode = rootNode.getRight();
		assertEquals(3, rightNode.getData());
		assertNull(rightNode.getLeft());
		assertNull(rightNode.getRight());
	}
	
	@Test
	public void fourNodes() {
		final Integer[] inputArr = {1, 2, 3, 4};
		List<Integer> inputList = Arrays.asList(inputArr);
		TreeNode<Integer> rootNode = MinimalTree.buildBinaryTree(inputList);
		assertEquals(3, rootNode.getData());
		TreeNode<Integer> leftNode = rootNode.getLeft();
		assertEquals(2, leftNode.getData());
		TreeNode<Integer> leftLeftNode = leftNode.getLeft();
		assertEquals(1, leftLeftNode.getData());
		assertNull(leftLeftNode.getLeft());
		assertNull(leftLeftNode.getRight());
		assertNull(leftNode.getRight());
		TreeNode<Integer> rightNode = rootNode.getRight();
		assertEquals(4, rightNode.getData());
		assertNull(rightNode.getLeft());
		assertNull(rightNode.getRight());
	}
	
	@Test
	public void fiveNodes() {
		final Integer[] inputArr = {1, 2, 3, 4, 5};
		List<Integer> inputList = Arrays.asList(inputArr);
		TreeNode<Integer> rootNode = MinimalTree.buildBinaryTree(inputList);
		assertEquals(3, rootNode.getData());
		TreeNode<Integer> leftNode = rootNode.getLeft();
		assertEquals(2, leftNode.getData());
		TreeNode<Integer> leftLeftNode = leftNode.getLeft();
		assertEquals(1, leftLeftNode.getData());
		assertNull(leftLeftNode.getLeft());
		assertNull(leftLeftNode.getRight());
		assertNull(leftNode.getRight());
		TreeNode<Integer> rightNode = rootNode.getRight();
		assertEquals(5, rightNode.getData());
		TreeNode<Integer> rightLeftNode = rightNode.getLeft();
		assertEquals(4, rightLeftNode.getData());
		assertNull(rightLeftNode.getLeft());
		assertNull(rightLeftNode.getRight());
		assertNull(rightNode.getRight());
	}
	
	@Test
	public void sixNodes() {
		final Integer[] inputArr = {1, 2, 3, 4, 5, 6};
		List<Integer> inputList = Arrays.asList(inputArr);
		TreeNode<Integer> rootNode = MinimalTree.buildBinaryTree(inputList);
		assertEquals(4, rootNode.getData());
		TreeNode<Integer> leftNode = rootNode.getLeft();
		assertEquals(2, leftNode.getData());
		TreeNode<Integer> leftLeftNode = leftNode.getLeft();
		assertEquals(1, leftLeftNode.getData());
		assertNull(leftLeftNode.getLeft());
		assertNull(leftLeftNode.getRight());
		TreeNode<Integer> leftRightNode = leftNode.getRight();
		assertEquals(3, leftRightNode.getData());
		assertNull(leftRightNode.getLeft());
		assertNull(leftRightNode.getRight());		
		TreeNode<Integer> rightNode = rootNode.getRight();
		assertEquals(6, rightNode.getData());
		TreeNode<Integer> rightLeftNode = rightNode.getLeft();
		assertEquals(5, rightLeftNode.getData());
		assertNull(rightLeftNode.getLeft());
		assertNull(rightLeftNode.getRight());
		assertNull(rightNode.getRight());
	}
	
	@Test
	public void sevenNodes() {
		final Integer[] inputArr = {1, 2, 3, 4, 5, 6, 7};
		List<Integer> inputList = Arrays.asList(inputArr);
		TreeNode<Integer> rootNode = MinimalTree.buildBinaryTree(inputList);
		assertEquals(4, rootNode.getData());
		TreeNode<Integer> leftNode = rootNode.getLeft();
		assertEquals(2, leftNode.getData());
		TreeNode<Integer> leftLeftNode = leftNode.getLeft();
		assertEquals(1, leftLeftNode.getData());
		assertNull(leftLeftNode.getLeft());
		assertNull(leftLeftNode.getRight());
		TreeNode<Integer> leftRightNode = leftNode.getRight();
		assertEquals(3, leftRightNode.getData());
		assertNull(leftRightNode.getLeft());
		assertNull(leftRightNode.getRight());		
		TreeNode<Integer> rightNode = rootNode.getRight();
		assertEquals(6, rightNode.getData());
		TreeNode<Integer> rightLeftNode = rightNode.getLeft();
		assertEquals(5, rightLeftNode.getData());
		assertNull(rightLeftNode.getLeft());
		assertNull(rightLeftNode.getRight());
		TreeNode<Integer> rightRightNode = rightNode.getRight();
		assertEquals(7, rightRightNode.getData());
		assertNull(rightRightNode.getLeft());
		assertNull(rightRightNode.getRight());
	}

}
