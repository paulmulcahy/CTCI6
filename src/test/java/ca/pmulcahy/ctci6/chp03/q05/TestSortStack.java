package ca.pmulcahy.ctci6.chp03.q05;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSortStack {
	
	@Test
	public void isEmpty() {
		final SortStack<Integer> stack = new SortStack<>();
		assertTrue(stack.isEmpty());
	}

	@Test
	public void isNotEmpty0() {
		final SortStack<Integer> stack = new SortStack<>();
		stack.push(1);
		assertFalse(stack.isEmpty());
	}

	@Test
	public void pushPop() {
		final SortStack<Integer> stack = new SortStack<>();
		stack.push(1);
		assertEquals(1, stack.pop());
	}

	@Test
	public void pushPeek() {
		final SortStack<Integer> stack = new SortStack<>();
		stack.push(1);
		assertEquals(1, stack.peek());
	}

	@Test
	public void popEmpty() {
		final SortStack<Integer> stack = new SortStack<>();
		assertThrows(EmptyStackException.class, () -> stack.pop());
	}

	@Test
	public void peekEmpty() {
		final SortStack<Integer> stack = new SortStack<>();
		assertThrows(EmptyStackException.class, () -> stack.peek());
	}

	@Test
	public void pushPushPop() {
		final SortStack<Integer> stack = new SortStack<>();
		stack.push(1);
		stack.push(2);
		assertEquals(2, stack.pop());
	}

	@Test
	public void pushPushPeek() {
		final SortStack<Integer> stack = new SortStack<>();
		stack.push(1);
		stack.push(2);
		assertEquals(2, stack.peek());
	}

	@Test
	public void pushPushPopPop() {
		final SortStack<Integer> stack = new SortStack<>();
		stack.push(1);
		stack.push(2);
		stack.pop();
		assertEquals(1, stack.pop());
	}

	@Test
	public void pushPushPopPeek() {
		final SortStack<Integer> stack = new SortStack<>();
		stack.push(1);
		stack.push(2);
		stack.pop();
		assertEquals(1, stack.peek());
	}
	
	@Test
	public void pushPushSortPop() {
		final SortStack<Integer> stack = new SortStack<>();
		stack.push(2);
		stack.push(1);
		stack.sort();
		assertEquals(1, stack.pop());
	}
	
	@Test
	public void pushPushAlreadySortedPeek() {
		final SortStack<Integer> stack = new SortStack<>();
		stack.push(1);
		stack.push(2);
		stack.sort();
		assertEquals(1, stack.peek());
	}

	@Test
	public void many() {
		final SortStack<Integer> stack = new SortStack<>();
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
