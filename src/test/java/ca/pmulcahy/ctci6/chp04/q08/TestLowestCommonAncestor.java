package ca.pmulcahy.ctci6.chp04.q08;

import org.junit.jupiter.api.Test;
import ca.pmulcahy.ctci6.chp04.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestLowestCommonAncestor {

	private TreeNode<Integer> getTree() {
		final TreeNode<Integer> root = new TreeNode<Integer>(3);
		final TreeNode<Integer> six =  new TreeNode<Integer>(6);
		root.setLeft(six);
		final TreeNode<Integer> two =  new TreeNode<Integer>(2);
		six.setLeft(two);
		final TreeNode<Integer> eleven =  new TreeNode<Integer>(11);
		six.setRight(eleven);
		final TreeNode<Integer> nine =  new TreeNode<Integer>(9);
		eleven.setLeft(nine);
		final TreeNode<Integer> five =  new TreeNode<Integer>(5);
		eleven.setRight(five);
		final TreeNode<Integer> eight =  new TreeNode<Integer>(8);
		root.setRight(eight);
		final TreeNode<Integer> thirteen = new TreeNode<Integer>(13);
		eight.setRight(thirteen);
		final TreeNode<Integer> seven =  new TreeNode<Integer>(7);
		thirteen.setLeft(seven);
		
		return root;
	}
	
	@Test
	public void nullArg1() {
		final TreeNode<Integer> root = getTree();
		assertThrows(IllegalArgumentException.class, () -> LowestCommonAncestor.getLowestCommonAncestor(root, null, 3));
	}	

	@Test
	public void nullArg2() {
		final TreeNode<Integer> root = getTree();
		assertThrows(IllegalArgumentException.class, () -> LowestCommonAncestor.getLowestCommonAncestor(root, 3, null));
	}
	
	@Test
	public void neitherInTree() {
		final TreeNode<Integer> root = getTree();
		final TreeNode<Integer> result = LowestCommonAncestor.getLowestCommonAncestor(root, 20, 30);
		assertNull(result);
	}
	
	@Test
	public void twoEight() {
		final Integer expected = 3;
		final TreeNode<Integer> root = getTree();
		final Integer result = LowestCommonAncestor.getLowestCommonAncestor(root, 2, 8)
												   .getData();
		assertEquals(expected, result);
	}

	@Test
	public void twoFive() {
		final Integer expected = 6;
		final TreeNode<Integer> root = getTree();
		final Integer result = LowestCommonAncestor.getLowestCommonAncestor(root, 2, 5)
												   .getData();
		assertEquals(expected, result);
	}
	
	@Test
	public void nineFive() {
		final Integer expected = 11;
		final TreeNode<Integer> root = getTree();
		final Integer result = LowestCommonAncestor.getLowestCommonAncestor(root, 9, 5)
												   .getData();
		assertEquals(expected, result);
	}
	
	@Test
	public void eightSeven() {
		final Integer expected = 8;
		final TreeNode<Integer> root = getTree();
		final Integer result = LowestCommonAncestor.getLowestCommonAncestor(root, 7, 8)
												   .getData();
		assertEquals(expected, result);
	}
	
	@Test
	public void nineThree() {
		final Integer expected = 3;
		final TreeNode<Integer> root = getTree();
		final Integer result = LowestCommonAncestor.getLowestCommonAncestor(root, 9, 3)
												   .getData();
		assertEquals(expected, result);
	}
	
}
