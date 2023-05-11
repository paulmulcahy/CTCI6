package ca.pmulcahy.ctci6.chp03.q03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;

class TestSetOfStacks {

  @Test
  void isEmpty() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    assertTrue(stack.isEmpty());
  }

  @Test
  void isNotEmpty0() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    stack.push(1);
    assertFalse(stack.isEmpty());
  }

  @Test
  void pushPop() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    stack.push(1);
    assertEquals(1, stack.pop());
  }

  @Test
  void pushPeek() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    stack.push(1);
    assertEquals(1, stack.peek());
  }

  @Test
  void popEmpty() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    assertThrows(EmptyStackException.class, () -> stack.pop());
  }

  @Test
  void peekEmpty() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    assertThrows(EmptyStackException.class, () -> stack.peek());
  }

  @Test
  void pushPushPop() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    stack.push(1);
    stack.push(2);
    assertEquals(2, stack.pop());
  }

  @Test
  void pushPushPeek() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    stack.push(1);
    stack.push(2);
    assertEquals(2, stack.peek());
  }

  @Test
  void pushPushPopPop() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    stack.push(1);
    stack.push(2);
    stack.pop();
    assertEquals(1, stack.pop());
  }

  @Test
  void pushPushPopPeek() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    stack.push(1);
    stack.push(2);
    stack.pop();
    assertEquals(1, stack.peek());
  }

  @Test
  void pushPushPopAtFirst() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    stack.push(1);
    stack.push(2);
    assertEquals(1, stack.popAt(0));
  }

  @Test
  void pushPushPopAtLast() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    stack.push(1);
    stack.push(2);
    assertEquals(2, stack.popAt(1));
  }

  @Test
  void pushPushPeekAtFirst() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    stack.push(1);
    stack.push(2);
    assertEquals(1, stack.peekAt(0));
  }

  @Test
  void pushPushPeekAtLast() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    stack.push(1);
    stack.push(2);
    assertEquals(2, stack.peekAt(1));
  }

  @Test
  void popAtLow() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    assertThrows(IllegalArgumentException.class, () -> stack.popAt(-1));
  }

  @Test
  public void popAtHigh() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    assertThrows(IllegalArgumentException.class, () -> stack.popAt(1));
  }

  @Test
  void peekAtLow() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    assertThrows(IllegalArgumentException.class, () -> stack.peekAt(-1));
  }

  @Test
  void peekAtHigh() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    assertThrows(IllegalArgumentException.class, () -> stack.peekAt(1));
  }

  @Test
  void popAtEmpty() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    assertThrows(EmptyStackException.class, () -> stack.popAt(0));
  }

  @Test
  void peekAtEmpty() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    assertThrows(EmptyStackException.class, () -> stack.peekAt(0));
  }

  @Test
  void pushPopPopEmpty() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    stack.push(1);
    stack.pop();
    assertThrows(EmptyStackException.class, () -> stack.popAt(0));
  }

  @Test
  void pushPopPeekEmpty() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    stack.push(1);
    stack.pop();
    assertThrows(EmptyStackException.class, () -> stack.peekAt(0));
  }

  @Test
  void pushPushPopPopPopEmpty() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    stack.push(1);
    stack.push(2);
    stack.pop();
    stack.pop();
    assertThrows(EmptyStackException.class, () -> stack.popAt(0));
  }

  @Test
  void pushPushPopPopPeekEmpty() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    stack.push(1);
    stack.push(2);
    stack.pop();
    stack.pop();
    assertThrows(EmptyStackException.class, () -> stack.peekAt(0));
  }

  @Test
  void pushPushPopAtPopAtEmpty() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    stack.push(1);
    stack.push(2);
    stack.popAt(0);
    assertThrows(EmptyStackException.class, () -> stack.popAt(0));
  }

  @Test
  void pushPushPopAtPeekAtEmpty() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    stack.push(1);
    stack.push(2);
    stack.popAt(0);
    assertThrows(EmptyStackException.class, () -> stack.peekAt(0));
  }

  @Test
  void pushPushPopAtPushPopAt() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    stack.push(1);
    stack.push(2);
    stack.popAt(0);
    stack.push(3);
    assertEquals(3, stack.popAt(0));
  }

  @Test
  void pushPushPopAtPushPeekAt() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>();
    stack.push(1);
    stack.push(2);
    stack.popAt(0);
    stack.push(3);
    assertEquals(3, stack.popAt(0));
  }

  @Test
  void increaseStackSize() {
    final SetOfStacks<Integer> stack = new SetOfStacks<>(3);
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
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    assertEquals("0123456789", sb.toString());
  }
}
