package ca.pmulcahy.ctci6.chp3.q1;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestNInOne {

	@Test
	public void isEmptyStackLow() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		assertThrows(IllegalArgumentException.class, () -> tripleStack.isEmpty(-1));
	}
	
	@Test
	public void isEmpty0() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		assertTrue(tripleStack.isEmpty(0));
	}

	@Test
	public void isEmpty1() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		assertTrue(tripleStack.isEmpty(1));
	}

	@Test
	public void isEmpty2() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		assertTrue(tripleStack.isEmpty(2));
	}
	
	@Test
	public void isEmptyStackHigh() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		assertThrows(IllegalArgumentException.class, () -> tripleStack.isEmpty(3));
	}
	
	@Test
	public void isEmptyQuadruple() {
		final NInOne<Integer> quadrupleStack = new NInOne<>(4);
		assertTrue(quadrupleStack.isEmpty(3));
	}


	@Test
	public void isNotEmptyStackLow() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		tripleStack.push(0, 1);
		assertThrows(IllegalArgumentException.class, () -> tripleStack.isEmpty(-1));
	}

	@Test
	public void isNotEmpty0() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		tripleStack.push(0,1);
		assertFalse(tripleStack.isEmpty(0));
	}
	
	@Test
	public void isNotEmpty1() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		tripleStack.push(1,2);
		assertFalse(tripleStack.isEmpty(1));
	}

	@Test
	public void isNotEmpty2() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		tripleStack.push(2, 3);
		assertFalse(tripleStack.isEmpty(2));
	}

	@Test
	public void isNotEmptyStackHigh() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		tripleStack.push(2, 1);
		assertThrows(IllegalArgumentException.class, () -> tripleStack.isEmpty(3));
	}

	@Test
	public void isNotEmptyQuadruple() {
		final NInOne<Integer> quadrupleStack = new NInOne<>(4);
		quadrupleStack.push(3,4);
		assertFalse(quadrupleStack.isEmpty(3));
	}

	@Test	
	public void pushLow() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		assertThrows(IllegalArgumentException.class, () -> tripleStack.push(-1, 1));
	}	

	@Test
	public void popLow() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		tripleStack.push(0, 1);
		assertThrows(IllegalArgumentException.class, () -> tripleStack.pop(-1));
	}

	@Test
	public void pushHigh() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		assertThrows(IllegalArgumentException.class, () -> tripleStack.push(3, 1));
	}	

	@Test
	public void popHigh() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		tripleStack.push(2, 3);
		assertThrows(IllegalArgumentException.class, () -> tripleStack.pop(3));
	}

	@Test
	public void pushPop0() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		tripleStack.push(0, 1);
		assertEquals(1, tripleStack.pop(0));
	}

	@Test
	public void pushPop1() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		tripleStack.push(1, 2);
		assertEquals(2, tripleStack.pop(1));
	}
	
	@Test	
	public void pushPop2() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		tripleStack.push(2, 3);
		assertEquals(3, tripleStack.pop(2));
	}	

	@Test
	public void pushPopQuadruple() {
		final NInOne<Integer> quadrupleStack = new NInOne<>(4);
		quadrupleStack.push(3, 4);
		assertEquals(4, quadrupleStack.pop(3));
	}

	@Test
	public void peekLow() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		tripleStack.push(0, 1);
		assertThrows(IllegalArgumentException.class, () -> tripleStack.peek(-1));
	}

	@Test
	public void peekHigh() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		tripleStack.push(2, 3);
		assertThrows(IllegalArgumentException.class, () -> tripleStack.peek(3));
	}

	@Test
	public void pushPeek0() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		tripleStack.push(0, 1);
		assertEquals(1, tripleStack.peek(0));
	}

	@Test
	public void pushPeek1() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		tripleStack.push(1, 2);
		assertEquals(2, tripleStack.peek(1));
	}
	
	@Test	
	public void pushPeek2() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		tripleStack.push(2, 3);
		assertEquals(3, tripleStack.peek(2));
	}	

	@Test
	public void pushPeekQuadruple() {
		final NInOne<Integer> quadrupleStack = new NInOne<>(4);
		quadrupleStack.push(3, 4);
		assertEquals(4, quadrupleStack.peek(3));
	}	
		
	@Test
	public void pushPushPop0() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		tripleStack.push(0, 0);
		tripleStack.push(0, 1);
		assertEquals(1, tripleStack.pop(0));
	}

	@Test
	public void pushPushPop1() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		tripleStack.push(1, 0);
		tripleStack.push(1, 2);
		assertEquals(2, tripleStack.pop(1));
	}
	
	@Test	
	public void pushPushPop2() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		tripleStack.push(2, 0);
		tripleStack.push(2, 3);
		assertEquals(3, tripleStack.pop(2));
	}	

	@Test
	public void pushPushPopQuadruple() {
		final NInOne<Integer> quadrupleStack = new NInOne<>(4);
		quadrupleStack.push(3, 0);
		quadrupleStack.push(3, 4);
		assertEquals(4, quadrupleStack.pop(3));
	}
	
	@Test
	public void popEmptyLow() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		assertThrows(IllegalArgumentException.class, () -> tripleStack.pop(-1));
	}

	@Test
	public void popEmptyHigh() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		assertThrows(IllegalArgumentException.class, () -> tripleStack.pop(3));
	}
	
	@Test
	public void popEmpty0() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		assertThrows(EmptyStackException.class, () -> tripleStack.pop(0));
	}

	@Test
	public void popEmpty1() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		assertThrows(EmptyStackException.class, () -> tripleStack.pop(1));
	}
	
	@Test
	public void popEmpty2() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		assertThrows(EmptyStackException.class, () -> tripleStack.pop(2));
	}
	
	@Test
	public void popEmptyQuadruple() {
		final NInOne<Integer> quadrupleStack = new NInOne<>(4);
		assertThrows(EmptyStackException.class, () -> quadrupleStack.pop(3));
	}
		
	@Test
	public void peekEmptyLow() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		assertThrows(IllegalArgumentException.class, () -> tripleStack.peek(-1));
	}

	@Test
	public void peekEmptyHigh() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		assertThrows(IllegalArgumentException.class, () -> tripleStack.peek(3));
	}
	
	@Test
	public void peekEmpty0() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		assertThrows(EmptyStackException.class, () -> tripleStack.peek(0));
	}

	@Test
	public void peekEmpty1() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		assertThrows(EmptyStackException.class, () -> tripleStack.peek(1));
	}
	
	@Test
	public void peekEmpty2() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		assertThrows(EmptyStackException.class, () -> tripleStack.peek(2));
	}
	
	@Test
	public void peekEmptyQuadruple() {
		final NInOne<Integer> quadrupleStack = new NInOne<>(4);
		assertThrows(EmptyStackException.class, () -> quadrupleStack.peek(3));
	}
	
	@Test
	public void increaseStackSize() {
		final NInOne<Integer> tripleStack = new NInOne<>(3);
		tripleStack.push(0, 9);
		tripleStack.push(0, 8);
		tripleStack.push(0, 7);
		tripleStack.push(0, 6);
		tripleStack.push(0, 5);
		tripleStack.push(0, 4);
		tripleStack.push(0, 3);
		tripleStack.push(0, 2);
		tripleStack.push(0, 1);
		tripleStack.push(0, 0);
		
		StringBuilder sb = new StringBuilder();
		while(!tripleStack.isEmpty(0)) {
			sb.append(tripleStack.pop(0));		
		}
		assertEquals("0123456789", sb.toString());
	}
	
}
