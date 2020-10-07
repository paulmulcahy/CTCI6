package ca.pmulcahy.ctci6.chp2;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestQ8_LoopDetection {

	@Test
	public void empty() {
		final SinglyLinkedList<Character> sList = new SinglyLinkedList<>();			
		
		final SinglyLinkedList.Node<Character> actual = Q8_LoopDetection.detectLoop(sList);
		assertNull(actual,  "The list is empty and a null value should be returned instead of " + actual + ".");
	}

	@Test
	public void noLoop() {
		final SinglyLinkedList<Character> sList = new SinglyLinkedList<>();			
		sList.add('A');
		sList.add('B');
		sList.add('C');
		sList.add('D');
		sList.add('E');
		
		final SinglyLinkedList.Node<Character> actual = Q8_LoopDetection.detectLoop(sList);
		assertNull(actual,  "The list has no and a null value should be returned instead of " + actual + ".");
	}

	@Test
	public void duplicateAtBeginning() {
		final SinglyLinkedList.Node<Character> duplicate = new SinglyLinkedList.Node<>('A');
		final SinglyLinkedList<Character> sList = new SinglyLinkedList<>();			
		sList.addNode(duplicate);
		sList.add('B');
		sList.add('C');
		sList.addNode(duplicate);
		
		final SinglyLinkedList.Node<Character> actual = Q8_LoopDetection.detectLoop(sList);
		assertEquals(duplicate, actual,  "The list has a loop at " + duplicate + " and that value should be returned instead of " + actual + ".");
	}
	
	@Test
	public void immediateDuplicate() {
		final SinglyLinkedList.Node<Character> duplicate = new SinglyLinkedList.Node<>('C');
		final SinglyLinkedList<Character> sList = new SinglyLinkedList<>();			
		sList.add('A');
		sList.add('B');
		sList.addNode(duplicate);
		sList.addNode(duplicate);
		
		final SinglyLinkedList.Node<Character> actual = Q8_LoopDetection.detectLoop(sList);
		assertEquals(duplicate, actual,  "The list has a loop at " + duplicate + " and that value should be returned instead of " + actual + ".");
	}
	
	@Test
	public void bookExample() {
		final SinglyLinkedList.Node<Character> duplicate = new SinglyLinkedList.Node<>('C');
		final SinglyLinkedList<Character> sList = new SinglyLinkedList<>();			
		sList.add('A');
		sList.add('B');
		sList.addNode(duplicate);
		sList.add('D');
		sList.add('E');
		sList.addNode(duplicate);
		
		final SinglyLinkedList.Node<Character> actual = Q8_LoopDetection.detectLoop(sList);
		assertEquals(duplicate, actual,  "The list has a loop at " + duplicate + " and that value should be returned instead of " + actual + ".");
	}
}
