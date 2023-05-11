package ca.pmulcahy.ctci6.chp03.q05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;

class TestSortStack {

  @Test
  void isEmpty() {
    final SortStack<Integer> stack = new SortStack<>();
    assertTrue(stack.isEmpty());
  }

  @Test
  void isNotEmpty0() {
    final SortStack<Integer> stack = new SortStack<>();
    stack.push(1);
    assertFalse(stack.isEmpty());
  }

  @Test
  void pushPop() {
    final SortStack<Integer> stack = new SortStack<>();
    stack.push(1);
    assertEquals(1, stack.pop());
  }

  @Test
  void pushPeek() {
    final SortStack<Integer> stack = new SortStack<>();
    stack.push(1);
    assertEquals(1, stack.peek());
  }

  @Test
  void popEmpty() {
    final SortStack<Integer> stack = new SortStack<>();
    assertThrows(EmptyStackException.class, () -> stack.pop());
  }

  @Test
  void peekEmpty() {
    final SortStack<Integer> stack = new SortStack<>();
    assertThrows(EmptyStackException.class, () -> stack.peek());
  }

  @Test
  void pushPushPop() {
    final SortStack<Integer> stack = new SortStack<>();
    stack.push(1);
    stack.push(2);
    assertEquals(2, stack.pop());
  }

  @Test
  void pushPushPeek() {
    final SortStack<Integer> stack = new SortStack<>();
    stack.push(1);
    stack.push(2);
    assertEquals(2, stack.peek());
  }

  @Test
  void pushPushPopPop() {
    final SortStack<Integer> stack = new SortStack<>();
    stack.push(1);
    stack.push(2);
    stack.pop();
    assertEquals(1, stack.pop());
  }

  @Test
  void pushPushPopPeek() {
    final SortStack<Integer> stack = new SortStack<>();
    stack.push(1);
    stack.push(2);
    stack.pop();
    assertEquals(1, stack.peek());
  }

  @Test
  void pushPushSortPop() {
    final SortStack<Integer> stack = new SortStack<>();
    stack.push(2);
    stack.push(1);
    stack.sort();
    assertEquals(1, stack.pop());
  }

  @Test
  void pushPushAlreadySortedPeek() {
    final SortStack<Integer> stack = new SortStack<>();
    stack.push(1);
    stack.push(2);
    stack.sort();
    assertEquals(1, stack.peek());
  }

  @Test
  void many() {
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
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    assertEquals("0123456789", sb.toString());
  }
}
