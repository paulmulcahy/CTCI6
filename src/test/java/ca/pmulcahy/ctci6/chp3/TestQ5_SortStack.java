package ca.pmulcahy.ctci6.chp3;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestQ5_SortStack {
	
	@Test
	public void isEmpty() {
		final Q5_SortStack<Integer> stack = new Q5_SortStack<>();
		assertTrue(stack.isEmpty());
	}

	@Test
	public void isNotEmpty0() {
		final Q5_SortStack<Integer> stack = new Q5_SortStack<>();
		stack.push(1);
		assertFalse(stack.isEmpty());
	}

	@Test
	public void pushPop() {
		final Q5_SortStack<Integer> stack = new Q5_SortStack<>();
		stack.push(1);
		assertEquals(1, stack.pop());
	}

	@Test
	public void pushPeek() {
		final Q5_SortStack<Integer> stack = new Q5_SortStack<>();
		stack.push(1);
		assertEquals(1, stack.peek());
	}

	@Test
	public void popEmpty() {
		final Q5_SortStack<Integer> stack = new Q5_SortStack<>();
		assertThrows(EmptyStackException.class, () -> stack.pop());
	}

	@Test
	public void peekEmpty() {
		final Q5_SortStack<Integer> stack = new Q5_SortStack<>();
		assertThrows(EmptyStackException.class, () -> stack.peek());
	}

	@Test
	public void pushPushPop() {
		final Q5_SortStack<Integer> stack = new Q5_SortStack<>();
		stack.push(1);
		stack.push(2);
		assertEquals(2, stack.pop());
	}

	@Test
	public void pushPushPeek() {
		final Q5_SortStack<Integer> stack = new Q5_SortStack<>();
		stack.push(1);
		stack.push(2);
		assertEquals(2, stack.peek());
	}

	@Test
	public void pushPushPopPop() {
		final Q5_SortStack<Integer> stack = new Q5_SortStack<>();
		stack.push(1);
		stack.push(2);
		stack.pop();
		assertEquals(1, stack.pop());
	}

	@Test
	public void pushPushPopPeek() {
		final Q5_SortStack<Integer> stack = new Q5_SortStack<>();
		stack.push(1);
		stack.push(2);
		stack.pop();
		assertEquals(1, stack.peek());
	}
	
	@Test
	public void pushPushSortPop() {
		final Q5_SortStack<Integer> stack = new Q5_SortStack<>();
		stack.push(2);
		stack.push(1);
		stack.sort();
		assertEquals(1, stack.pop());
	}
	
	@Test
	public void pushPushAlreadySortedPeek() {
		final Q5_SortStack<Integer> stack = new Q5_SortStack<>();
		stack.push(1);
		stack.push(2);
		stack.sort();
		assertEquals(1, stack.peek());
	}

	@Test
	public void many() {
		final Q5_SortStack<Integer> stack = new Q5_SortStack<>();
		stack.push(7);
		stack.push(5);
		stack.push(2);
		stack.push(9);
		stack.push(3);
		stack.push(8);
		stack.push(1);
		stack.push(6);
		stack.push(4);
		stack.push(0);
		stack.sort();
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());		
		}
		assertEquals("0123456789", sb.toString());
	}

}
