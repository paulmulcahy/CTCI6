package ca.pmulcahy.ctci6.chp3;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestQ2_StackMin {
	
	@Test
	public void isEmpty() {
		final Q2_StackMin<Integer> stack = new Q2_StackMin<>();
		assertTrue(stack.isEmpty());
	}

	@Test
	public void isNotEmpty0() {
		final Q2_StackMin<Integer> stack = new Q2_StackMin<>();
		stack.push(1);
		assertFalse(stack.isEmpty());
	}

	@Test
	public void pushPop() {
		final Q2_StackMin<Integer> stack = new Q2_StackMin<>();
		stack.push(1);
		assertEquals(1, stack.pop());
	}

	@Test
	public void pushPeek() {
		final Q2_StackMin<Integer> stack = new Q2_StackMin<>();
		stack.push(1);
		assertEquals(1, stack.peek());
	}

	@Test
	public void pushMin() {
		final Q2_StackMin<Integer> stack = new Q2_StackMin<>();
		stack.push(1);
		assertEquals(1, stack.min());
	}

	@Test
	public void popEmpty() {
		final Q2_StackMin<Integer> stack = new Q2_StackMin<>();
		assertThrows(EmptyStackException.class, () -> stack.pop());
	}

	@Test
	public void peekEmpty() {
		final Q2_StackMin<Integer> stack = new Q2_StackMin<>();
		assertThrows(EmptyStackException.class, () -> stack.peek());
	}

	@Test
	public void minEmpty() {
		final Q2_StackMin<Integer> stack = new Q2_StackMin<>();
		assertThrows(EmptyStackException.class, () -> stack.min());
	}

	@Test
	public void pushPopMinEmpty() {
		final Q2_StackMin<Integer> stack = new Q2_StackMin<>();
		stack.push(1);
		stack.pop();
		assertThrows(EmptyStackException.class, () -> stack.min());
	}
	
	@Test
	public void pushPushPopLargerMin() {
		final Q2_StackMin<Integer> stack = new Q2_StackMin<>();
		stack.push(1);
		stack.push(0);
		stack.pop();
		assertEquals(1, stack.min());
	}

	@Test
	public void pushPushPopSmallerMin() {
		final Q2_StackMin<Integer> stack = new Q2_StackMin<>();
		stack.push(0);
		stack.push(1);
		stack.pop();
		assertEquals(0, stack.min());
	}

}
