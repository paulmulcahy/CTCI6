package ca.pmulcahy.ctci6.chp3;

import java.util.EmptyStackException;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestQ3_SetOfStacks {
	
	@Test
	public void isEmpty() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		assertTrue(stack.isEmpty());
	}

	@Test
	public void isNotEmpty0() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		stack.push(1);
		assertFalse(stack.isEmpty());
	}

	@Test
	public void pushPop() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		stack.push(1);
		assertEquals(1, stack.pop());
	}

	@Test
	public void pushPeek() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		stack.push(1);
		assertEquals(1, stack.peek());
	}

	@Test
	public void popEmpty() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		assertThrows(EmptyStackException.class, () -> stack.pop());
	}

	@Test
	public void peekEmpty() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		assertThrows(EmptyStackException.class, () -> stack.peek());
	}

	@Test
	public void pushPushPop() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		stack.push(1);
		stack.push(2);
		assertEquals(2, stack.pop());
	}

	@Test
	public void pushPushPeek() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		stack.push(1);
		stack.push(2);
		assertEquals(2, stack.peek());
	}

	@Test
	public void pushPushPopPop() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		stack.push(1);
		stack.push(2);
		stack.pop();
		assertEquals(1, stack.pop());
	}

	@Test
	public void pushPushPopPeek() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		stack.push(1);
		stack.push(2);
		stack.pop();
		assertEquals(1, stack.peek());
	}
	
	@Test
	public void pushPushPopAtFirst() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		stack.push(1);
		stack.push(2);
		assertEquals(1, stack.popAt(0));
	}

	@Test
	public void pushPushPopAtLast() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		stack.push(1);
		stack.push(2);
		assertEquals(2, stack.popAt(1));
	}

	@Test
	public void pushPushPeekAtFirst() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		stack.push(1);
		stack.push(2);
		assertEquals(1, stack.peekAt(0));
	}

	@Test
	public void pushPushPeekAtLast() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		stack.push(1);
		stack.push(2);
		assertEquals(2, stack.peekAt(1));
	}
	
	@Test
	public void popAtLow() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		assertThrows(IllegalArgumentException.class, () -> stack.popAt(-1));
	}
	
	@Test
	public void popAtHigh() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		assertThrows(IllegalArgumentException.class, () -> stack.popAt(1));
	}
	
	@Test
	public void peekAtLow() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		assertThrows(IllegalArgumentException.class, () -> stack.peekAt(-1));
	}
	
	@Test
	public void peekAtHigh() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		assertThrows(IllegalArgumentException.class, () -> stack.peekAt(1));
	}
	
	@Test
	public void popAtEmpty() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		assertThrows(EmptyStackException.class, () -> stack.popAt(0));
	}	

	@Test
	public void peekAtEmpty() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		assertThrows(EmptyStackException.class, () -> stack.peekAt(0));
	}
	
	@Test
	public void pushPopPopEmpty() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		stack.push(1);
		stack.pop();
		assertThrows(EmptyStackException.class, () -> stack.popAt(0));
	}	

	@Test
	public void pushPopPeekEmpty() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		stack.push(1);
		stack.pop();
		assertThrows(EmptyStackException.class, () -> stack.peekAt(0));
	}
	
	@Test
	public void pushPushPopPopPopEmpty() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		stack.push(1);
		stack.push(2);
		stack.pop();
		stack.pop();
		assertThrows(EmptyStackException.class, () -> stack.popAt(0));
	}	

	@Test
	public void pushPushPopPopPeekEmpty() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		stack.push(1);
		stack.push(2);
		stack.pop();
		stack.pop();
		assertThrows(EmptyStackException.class, () -> stack.peekAt(0));
	}
	
	@Test
	public void pushPushPopAtPopAtEmpty() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		stack.push(1);
		stack.push(2);
		stack.popAt(0);
		assertThrows(EmptyStackException.class, () -> stack.popAt(0));
	}

	@Test
	public void pushPushPopAtPeekAtEmpty() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		stack.push(1);
		stack.push(2);
		stack.popAt(0);
		assertThrows(EmptyStackException.class, () -> stack.peekAt(0));
	}
	
	@Test
	public void pushPushPopAtPushPopAt() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		stack.push(1);
		stack.push(2);
		stack.popAt(0);
		stack.push(3);
		assertEquals(3, stack.popAt(0));
	}

	@Test
	public void pushPushPopAtPushPeekAt() {
		final Q3_SetOfStacks<Integer> stack = new Q3_SetOfStacks<>();
		stack.push(1);
		stack.push(2);
		stack.popAt(0);
		stack.push(3);
		assertEquals(3, stack.popAt(0));
	}

}
