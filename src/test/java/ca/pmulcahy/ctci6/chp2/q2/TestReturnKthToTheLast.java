package ca.pmulcahy.ctci6.chp2.q2;

import ca.pmulcahy.ctci6.chp2.SinglyLinkedList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestReturnKthToTheLast {
	
	@Test
	public void empty() {
		final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();			
								
		final Integer actual = ReturnKthToTheLast.returnKthToTheLast(sList, 0);
		assertEquals(null, actual,  "The list: " + sList + " is empty and k equals 0- both conditions should return null.");
	}

	@Test
	public void kIsZero() {	
		final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();	
		sList.add(1);
		final Integer actual = ReturnKthToTheLast.returnKthToTheLast(sList, 0);
		assertEquals(null, actual,  "K equals 0 and anything zero or below should return null.");
	}
	
	@Test
	public void kIsBelowZero() {	
		final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();	
		sList.add(1);
		final Integer actual = ReturnKthToTheLast.returnKthToTheLast(sList, -1);
		assertEquals(null, actual,  "K equals -1 and anything zero or below should return null.");
	}

	@Test
	public void singleValue() {
		Integer singleInt = 1;
		
		final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();	
		sList.add(singleInt);
								
		final Integer actual = ReturnKthToTheLast.returnKthToTheLast(sList, 1);
		assertEquals(singleInt, actual,  "The list: " + sList + " contains 1 element (1) and the 1st to the last element should return the same element.");
	}

	@Test
	public void singleNullValue() {
		Integer singleInt = null;
		
		final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();	
		sList.add(singleInt);
								
		final Integer actual = ReturnKthToTheLast.returnKthToTheLast(sList, 1);
		assertEquals(singleInt, actual,  "The list: " + sList + " contains 1 element (1) and the 1st to the last element should return the same element.");
	}

	@Test
	public void twoValuesReturnFirst() {
		Integer firstInt = 1;
		Integer secondInt = 2;
		
		final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();	
		sList.add(firstInt);
		sList.add(secondInt);
								
		final Integer actual = ReturnKthToTheLast.returnKthToTheLast(sList, 2);
		assertEquals(firstInt, actual,  "The list: " + sList + " contains 2 elements and the 2nd to the last element should return the first element.");
	}

	@Test
	public void twoValuesReturnLast() {
		Integer firstInt = 1;
		Integer secondInt = 2;
		
		final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();	
		sList.add(firstInt);
		sList.add(secondInt);
								
		final Integer actual = ReturnKthToTheLast.returnKthToTheLast(sList, 1);
		assertEquals(secondInt, actual,  "The list: " + sList + " contains 2 elements and the 1st to the last element should return the second element.");
	}

	@Test
	public void kTooLarge() {
		Integer firstInt = 1;
		Integer secondInt = 2;
		
		final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();	
		sList.add(firstInt);
		sList.add(secondInt);
								
		final Integer actual = ReturnKthToTheLast.returnKthToTheLast(sList, 3);
		assertEquals(null, actual,  "The list: " + sList + " contains less elements than the requested k and should return null.");
	}
	
	@Test
	public void threeValuesReturnFirst() {
		Integer firstInt = 1;
		Integer secondInt = null;
		Integer thirdInt = 3;
		
		final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();	
		sList.add(firstInt);
		sList.add(secondInt);
		sList.add(thirdInt);
								
		final Integer actual = ReturnKthToTheLast.returnKthToTheLast(sList, 3);
		assertEquals(firstInt, actual,  "The list: " + sList + " contains 3 elements and the 3rd to the last element should return the first element.");
	}

	@Test
	public void threeValuesReturnMiddle() {
		Integer firstInt = 1;
		Integer secondInt = null;
		Integer thirdInt = 3;
		
		final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();	
		sList.add(firstInt);
		sList.add(secondInt);
		sList.add(thirdInt);
								
		final Integer actual = ReturnKthToTheLast.returnKthToTheLast(sList, 2);
		assertEquals(secondInt, actual,  "The list: " + sList + " contains 3 elements and the 2nd to the last element should return the second element.");
	}

	@Test
	public void threeValuesReturnLast() {
		Integer firstInt = 1;
		Integer secondInt = null;
		Integer thirdInt = 3;
		
		final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();	
		sList.add(firstInt);
		sList.add(secondInt);
		sList.add(thirdInt);
								
		final Integer actual = ReturnKthToTheLast.returnKthToTheLast(sList, 1);
		assertEquals(thirdInt, actual,  "The list: " + sList + " contains 3 elements and the 1st to the last element should return the third element.");
	}
	
}
