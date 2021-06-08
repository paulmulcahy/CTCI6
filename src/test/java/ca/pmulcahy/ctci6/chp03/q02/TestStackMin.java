package ca.pmulcahy.ctci6.chp03.q02;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStackMin {
	
	@Test
	public void isEmpty() {
		final StackMin<Integer> stack = new StackMin<>();
		assertTrue(stack.isEmpty());
	}

	@Test
	public void isNotEmpty0() {
		final StackMin<Integer> stack = new StackMin<>();
		stack.push(1);
		assertFalse(stack.isEmpty());
	}

	@Test
	public void pushPop() {
		final StackMin<Integer> stack = new StackMin<>();
		stack.push(1);
		assertEquals(1, stack.pop());
	}

	@Test
	public void pushPeek() {
		final StackMin<Integer> stack = new StackMin<>();
		stack.push(1);
		assertEquals(1, stack.peek());
	}

	@Test
	public void increaseStackSize() {
		final StackMin<Integer> stack = new StackMin<>(3);
		stack.push(9);
		stack.push(8);
		stack.push(7);
		stack.push(6);
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		stack.push(0);
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());		
		}
		assertEquals("0123456789", sb.toString());
	}

	@Test
	public void pushMin() {
		final StackMin<Integer> stack = new StackMin<>();
		stack.push(1);
		assertEquals(1, stack.min());
	}

	@Test
	public void popEmpty() {
		final StackMin<Integer> stack = new StackMin<>();
		assertThrows(EmptyStackException.class, () -> stack.pop());
	}

	@Test
	public void peekEmpty() {
		final StackMin<Integer> stack = new StackMin<>();
		assertThrows(EmptyStackException.class, () -> stack.peek());
	}

	@Test
	public void minEmpty() {
		final StackMin<Integer> stack = new StackMin<>();
		assertThrows(EmptyStackException.class, () -> stack.min());
	}

	@Test
	public void pushPopMinEmpty() {
		final StackMin<Integer> stack = new StackMin<>();
		stack.push(1);
		stack.pop();
		assertThrows(EmptyStackException.class, () -> stack.min());
	}
	
	@Test
	public void pushPushPopLargerMin() {
		final StackMin<Integer> stack = new StackMin<>();
		stack.push(1);
		stack.push(0);
		stack.pop();
		assertEquals(1, stack.min());
	}

	@Test
	public void pushPushPopSmallerMin() {
		final StackMin<Integer> stack = new StackMin<>();
		stack.push(0);
		stack.push(1);
		stack.pop();
		assertEquals(0, stack.min());
	}

}
