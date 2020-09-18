package ca.pmulcahy.ctci6.chp2;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestQ4_Partition {
	
	@Test
	public void empty() {
		final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();			
								
		final SinglyLinkedList<Integer> actual = Q4_Partition.partition(sList, 0);
		assertEquals(sList, actual,  "The list: " + sList + " is empty and so the empty list should be returned.");
	}
	
	@Test
	public void lengthOne() {
		final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();			
		sList.add(1);
						
		final SinglyLinkedList<Integer> actual = Q4_Partition.partition(sList, 0);
		assertEquals(sList, actual,  "The list: " + sList + " has only 1 element and so the original list should be returned.");
	}
	
	
	@Test
	public void lengthTwoNonNullPartitionNonNull() {
		final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();			
		sList.add(2);
		sList.add(1);

		final SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
		expected.add(1);
		expected.add(2);
						
		final SinglyLinkedList<Integer> actual = Q4_Partition.partition(sList, 2);
		assertEquals(expected, actual,  "The list: " + sList + " has 2 elements, and when partitioned by 2 should look like" + expected);
	}
	
	@Test
	public void lengthTwoNullPartitionNonNull() {
		final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();			
		sList.add(1);
		sList.add(null);

		final SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
		expected.add(null);
		expected.add(1);
						
		final SinglyLinkedList<Integer> actual = Q4_Partition.partition(sList, 1);
		assertEquals(expected, actual,  "The list: " + sList + " has 2 elements, and when partitioned by 1 should look like" + expected);
	}
	
	@Test
	public void lengthTwoNonNullPartitionNull() {
		final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();			
		sList.add(2);
		sList.add(1);
						
		final SinglyLinkedList<Integer> actual = Q4_Partition.partition(sList, null);
		assertEquals(sList, actual,  "The list: " + sList + " has 2 elements, and when partitioned by null the original list should be returned.");
	}
	
	@Test
	public void lengthTwoNullPartitionNull() {
		final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();			
		sList.add(2);
		sList.add(null);
						
		final SinglyLinkedList<Integer> actual = Q4_Partition.partition(sList, null);
		assertEquals(sList, actual,  "The list: " + sList + " has 2 elements, and when partitioned by null the original list should be returned.");
	}
	
	@Test
	public void bookExample() {
		final Integer[] inputArr = new Integer[]{ 3,5,8,5,10,2,1 };
		final List<Integer> inputList = Arrays.asList(inputArr);		
		final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();		
		sList.addAll(inputList);

		final Integer[] expectedArr = new Integer[]{ 1,2,3,5,8,5,10 };
		final List<Integer> expectedList = Arrays.asList(expectedArr);		
		final SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();		
		expected.addAll(expectedList);
		
		final SinglyLinkedList<Integer> actual = Q4_Partition.partition(sList, 5);
		assertEquals(expected, actual,  "The list: " + sList + " when partitioned by 5 should look like" + expected);
	}
	
}
