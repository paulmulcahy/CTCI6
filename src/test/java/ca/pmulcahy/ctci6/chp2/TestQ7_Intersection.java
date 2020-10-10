package ca.pmulcahy.ctci6.chp2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestQ7_Intersection {
	
	@Test
	public void empty() {
		final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();			
		
		final SinglyLinkedList.Node<Integer> expected = null;
		
		final SinglyLinkedList.Node<Integer> actual = Q7_Intersection.getIntersection(sList, sList);
		assertEquals(expected, actual,  "The lists: " + sList + " and " + sList + " are empty and therefore " + expected + " equals " + actual);
	}
	
	@Test
	public void singleIntersectingNode() {
		final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
		final SinglyLinkedList.Node<Integer> expected = new SinglyLinkedList.Node<>(1);
		sList.addNode(expected);
		
		final SinglyLinkedList.Node<Integer> actual = Q7_Intersection.getIntersection(sList, sList);
		assertEquals(expected, actual,  "The lists: " + sList + " and " + sList + " have a single intersecting node and so the returning node " + actual + " should equals the expected node " + expected + ".");
	}
	
	@Test
	public void singleNonIntersectingNode() {
		final SinglyLinkedList<Integer> sList1 = new SinglyLinkedList<>();
		sList1.add(1);
		final SinglyLinkedList<Integer> sList2 = new SinglyLinkedList<>();
		sList2.add(2);
		
		final SinglyLinkedList.Node<Integer> actual = Q7_Intersection.getIntersection(sList1, sList2);
		assertNull(actual,  "The lists: " + sList1 + " and " + sList2 + " have no intersecting nodes and so should return null.");
	}
	
	@Test
	public void singleNonIntersectingNodeSameData() {
		final SinglyLinkedList<Integer> sList1 = new SinglyLinkedList<>();
		sList1.add(1);
		final SinglyLinkedList<Integer> sList2 = new SinglyLinkedList<>();
		sList2.add(1);
		
		final SinglyLinkedList.Node<Integer> actual = Q7_Intersection.getIntersection(sList1, sList2);
		assertNull(actual,  "The lists: " + sList1 + " and " + sList2 + " have no intersecting nodes and so should return null.");
	}
	
	@Test
	public void firstIntersectingNodes() {
		final SinglyLinkedList.Node<Integer> expected = new SinglyLinkedList.Node<>(1);
		final SinglyLinkedList<Integer> sList1 = new SinglyLinkedList<>();
		sList1.addNode(expected);
		sList1.add(2);
		final SinglyLinkedList<Integer> sList2 = new SinglyLinkedList<>();
		sList2.addNode(expected);
		sList2.add(3);	
		final SinglyLinkedList.Node<Integer> actual = Q7_Intersection.getIntersection(sList1, sList2);
		assertEquals(expected, actual,  "The lists: " + sList1 + " and " + sList2 + " have a single intersecting node and so the expected value of " + expected + " should matched the actual value of " + actual + ".");
	}
	
	@Test
	public void nonFirstIntersectingNodes() {
		final SinglyLinkedList.Node<Integer> expected = new SinglyLinkedList.Node<>(1);
		final SinglyLinkedList<Integer> sList1 = new SinglyLinkedList<>();
		sList1.add(2);
		sList1.addNode(expected);
		final SinglyLinkedList<Integer> sList2 = new SinglyLinkedList<>();
		sList2.add(3);	
		sList2.addNode(expected);
		final SinglyLinkedList.Node<Integer> actual = Q7_Intersection.getIntersection(sList1, sList2);
		assertEquals(expected, actual,  "The lists: " + sList1 + " and " + sList2 + " have a single intersecting node and so the expected value of " + expected + " should matched the actual value of " + actual + ".");
	}
	
	@Test
	public void intersectingNodeInJumble() {
		final SinglyLinkedList.Node<Integer> expected = new SinglyLinkedList.Node<>(1);
		final SinglyLinkedList<Integer> sList1 = new SinglyLinkedList<>();
		sList1.add(2);
		sList1.addNode(expected);
		sList1.add(4);
		final SinglyLinkedList<Integer> sList2 = new SinglyLinkedList<>();
		sList2.add(3);	
		sList2.addNode(expected);
		sList2.add(5);
		final SinglyLinkedList.Node<Integer> actual = Q7_Intersection.getIntersection(sList1, sList2);
		assertEquals(expected, actual,  "The lists: " + sList1 + " and " + sList2 + " have a single intersecting node and so the expected value of " + expected + " should matched the actual value of " + actual + ".");
	}
}
