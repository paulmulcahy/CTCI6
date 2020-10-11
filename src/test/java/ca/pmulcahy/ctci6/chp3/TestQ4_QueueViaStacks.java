package ca.pmulcahy.ctci6.chp3;

import java.util.NoSuchElementException;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestQ4_QueueViaStacks {
	
	@Test
	public void isEmpty() {
		final Q4_QueueViaStacks<Integer> queue = new Q4_QueueViaStacks<>();
		assertTrue(queue.isEmpty());
	}

	@Test
	public void isNotEmpty0() {
		final Q4_QueueViaStacks<Integer> queue = new Q4_QueueViaStacks<>();
		queue.add(1);
		assertFalse(queue.isEmpty());
	}

	@Test
	public void addRemove() {
		final Q4_QueueViaStacks<Integer> queue = new Q4_QueueViaStacks<>();
		queue.add(1);
		assertEquals(1, queue.remove());
	}

	@Test
	public void addPeek() {
		final Q4_QueueViaStacks<Integer> queue = new Q4_QueueViaStacks<>();
		queue.add(1);
		assertEquals(1, queue.peek());
	}

	@Test
	public void removeEmpty() {
		final Q4_QueueViaStacks<Integer> queue = new Q4_QueueViaStacks<>();
		assertThrows(NoSuchElementException.class, () -> queue.remove());
	}

	@Test
	public void peekEmpty() {
		final Q4_QueueViaStacks<Integer> queue = new Q4_QueueViaStacks<>();
		assertThrows(NoSuchElementException.class, () -> queue.peek());
	}

	@Test
	public void addaddRemove() {
		final Q4_QueueViaStacks<Integer> queue = new Q4_QueueViaStacks<>();
		queue.add(1);
		queue.add(2);
		assertEquals(1, queue.remove());
	}

	@Test
	public void addaddPeek() {
		final Q4_QueueViaStacks<Integer> queue = new Q4_QueueViaStacks<>();
		queue.add(1);
		queue.add(2);
		assertEquals(1, queue.peek());
	}

	@Test
	public void addaddRemoveRemove() {
		final Q4_QueueViaStacks<Integer> queue = new Q4_QueueViaStacks<>();
		queue.add(1);
		queue.add(2);
		queue.remove();
		assertEquals(2, queue.remove());
	}

	@Test
	public void addaddRemovePeek() {
		final Q4_QueueViaStacks<Integer> queue = new Q4_QueueViaStacks<>();
		queue.add(1);
		queue.add(2);
		queue.remove();
		assertEquals(2, queue.peek());
	}
}
