package ca.pmulcahy.ctci6.chp03.q01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;

class TestNInOne {

  @Test
  void isEmptyStackLow() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    assertThrows(IllegalArgumentException.class, () -> tripleStack.isEmpty(-1));
  }

  @Test
  void isEmpty0() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    assertTrue(tripleStack.isEmpty(0));
  }

  @Test
  void isEmpty1() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    assertTrue(tripleStack.isEmpty(1));
  }

  @Test
  void isEmpty2() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    assertTrue(tripleStack.isEmpty(2));
  }

  @Test
  void isEmptyStackHigh() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    assertThrows(IllegalArgumentException.class, () -> tripleStack.isEmpty(3));
  }

  @Test
  void isEmptyQuadruple() {
    final NInOne<Integer> quadrupleStack = new NInOne<>(4);
    assertTrue(quadrupleStack.isEmpty(3));
  }

  @Test
  void isNotEmptyStackLow() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    tripleStack.push(0, 1);
    assertThrows(IllegalArgumentException.class, () -> tripleStack.isEmpty(-1));
  }

  @Test
  void isNotEmpty0() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    tripleStack.push(0, 1);
    assertFalse(tripleStack.isEmpty(0));
  }

  @Test
  void isNotEmpty1() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    tripleStack.push(1, 2);
    assertFalse(tripleStack.isEmpty(1));
  }

  @Test
  void isNotEmpty2() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    tripleStack.push(2, 3);
    assertFalse(tripleStack.isEmpty(2));
  }

  @Test
  void isNotEmptyStackHigh() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    tripleStack.push(2, 1);
    assertThrows(IllegalArgumentException.class, () -> tripleStack.isEmpty(3));
  }

  @Test
  void isNotEmptyQuadruple() {
    final NInOne<Integer> quadrupleStack = new NInOne<>(4);
    quadrupleStack.push(3, 4);
    assertFalse(quadrupleStack.isEmpty(3));
  }

  @Test
  void pushLow() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    assertThrows(IllegalArgumentException.class, () -> tripleStack.push(-1, 1));
  }

  @Test
  void popLow() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    tripleStack.push(0, 1);
    assertThrows(IllegalArgumentException.class, () -> tripleStack.pop(-1));
  }

  @Test
  void pushHigh() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    assertThrows(IllegalArgumentException.class, () -> tripleStack.push(3, 1));
  }

  @Test
  void popHigh() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    tripleStack.push(2, 3);
    assertThrows(IllegalArgumentException.class, () -> tripleStack.pop(3));
  }

  @Test
  void pushPop0() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    tripleStack.push(0, 1);
    assertEquals(1, tripleStack.pop(0));
  }

  @Test
  void pushPop1() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    tripleStack.push(1, 2);
    assertEquals(2, tripleStack.pop(1));
  }

  @Test
  void pushPop2() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    tripleStack.push(2, 3);
    assertEquals(3, tripleStack.pop(2));
  }

  @Test
  void pushPopQuadruple() {
    final NInOne<Integer> quadrupleStack = new NInOne<>(4);
    quadrupleStack.push(3, 4);
    assertEquals(4, quadrupleStack.pop(3));
  }

  @Test
  void peekLow() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    tripleStack.push(0, 1);
    assertThrows(IllegalArgumentException.class, () -> tripleStack.peek(-1));
  }

  @Test
  void peekHigh() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    tripleStack.push(2, 3);
    assertThrows(IllegalArgumentException.class, () -> tripleStack.peek(3));
  }

  @Test
  void pushPeek0() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    tripleStack.push(0, 1);
    assertEquals(1, tripleStack.peek(0));
  }

  @Test
  void pushPeek1() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    tripleStack.push(1, 2);
    assertEquals(2, tripleStack.peek(1));
  }

  @Test
  void pushPeek2() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    tripleStack.push(2, 3);
    assertEquals(3, tripleStack.peek(2));
  }

  @Test
  void pushPeekQuadruple() {
    final NInOne<Integer> quadrupleStack = new NInOne<>(4);
    quadrupleStack.push(3, 4);
    assertEquals(4, quadrupleStack.peek(3));
  }

  @Test
  void pushPushPop0() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    tripleStack.push(0, 0);
    tripleStack.push(0, 1);
    assertEquals(1, tripleStack.pop(0));
  }

  @Test
  void pushPushPop1() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    tripleStack.push(1, 0);
    tripleStack.push(1, 2);
    assertEquals(2, tripleStack.pop(1));
  }

  @Test
  void pushPushPop2() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    tripleStack.push(2, 0);
    tripleStack.push(2, 3);
    assertEquals(3, tripleStack.pop(2));
  }

  @Test
  void pushPushPopQuadruple() {
    final NInOne<Integer> quadrupleStack = new NInOne<>(4);
    quadrupleStack.push(3, 0);
    quadrupleStack.push(3, 4);
    assertEquals(4, quadrupleStack.pop(3));
  }

  @Test
  void popEmptyLow() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    assertThrows(IllegalArgumentException.class, () -> tripleStack.pop(-1));
  }

  @Test
  void popEmptyHigh() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    assertThrows(IllegalArgumentException.class, () -> tripleStack.pop(3));
  }

  @Test
  void popEmpty0() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    assertThrows(EmptyStackException.class, () -> tripleStack.pop(0));
  }

  @Test
  void popEmpty1() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    assertThrows(EmptyStackException.class, () -> tripleStack.pop(1));
  }

  @Test
  void popEmpty2() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    assertThrows(EmptyStackException.class, () -> tripleStack.pop(2));
  }

  @Test
  void popEmptyQuadruple() {
    final NInOne<Integer> quadrupleStack = new NInOne<>(4);
    assertThrows(EmptyStackException.class, () -> quadrupleStack.pop(3));
  }

  @Test
  void peekEmptyLow() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    assertThrows(IllegalArgumentException.class, () -> tripleStack.peek(-1));
  }

  @Test
  void peekEmptyHigh() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    assertThrows(IllegalArgumentException.class, () -> tripleStack.peek(3));
  }

  @Test
  void peekEmpty0() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    assertThrows(EmptyStackException.class, () -> tripleStack.peek(0));
  }

  @Test
  void peekEmpty1() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    assertThrows(EmptyStackException.class, () -> tripleStack.peek(1));
  }

  @Test
  void peekEmpty2() {
    final NInOne<Integer> tripleStack = new NInOne<>(3);
    assertThrows(EmptyStackException.class, () -> tripleStack.peek(2));
  }

  @Test
  void peekEmptyQuadruple() {
    final NInOne<Integer> quadrupleStack = new NInOne<>(4);
    assertThrows(EmptyStackException.class, () -> quadrupleStack.peek(3));
  }

  @Test
  void increaseStackSize() {
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
    while (!tripleStack.isEmpty(0)) {
      sb.append(tripleStack.pop(0));
    }
    assertEquals("0123456789", sb.toString());
  }
}
