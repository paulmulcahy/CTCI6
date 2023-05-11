package ca.pmulcahy.ctci6.chp03.q04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class TestQueueViaStacks {

  @Test
  void isEmpty() {
    final QueueViaStacks<Integer> queue = new QueueViaStacks<>();
    assertTrue(queue.isEmpty());
  }

  @Test
  void isNotEmpty0() {
    final QueueViaStacks<Integer> queue = new QueueViaStacks<>();
    queue.add(1);
    assertFalse(queue.isEmpty());
  }

  @Test
  void addRemove() {
    final QueueViaStacks<Integer> queue = new QueueViaStacks<>();
    queue.add(1);
    assertEquals(1, queue.remove());
  }

  @Test
  void addPeek() {
    final QueueViaStacks<Integer> queue = new QueueViaStacks<>();
    queue.add(1);
    assertEquals(1, queue.peek());
  }

  @Test
  void removeEmpty() {
    final QueueViaStacks<Integer> queue = new QueueViaStacks<>();
    assertThrows(NoSuchElementException.class, () -> queue.remove());
  }

  @Test
  void peekEmpty() {
    final QueueViaStacks<Integer> queue = new QueueViaStacks<>();
    assertThrows(NoSuchElementException.class, () -> queue.peek());
  }

  @Test
  void addaddRemove() {
    final QueueViaStacks<Integer> queue = new QueueViaStacks<>();
    queue.add(1);
    queue.add(2);
    assertEquals(1, queue.remove());
  }

  @Test
  void addaddPeek() {
    final QueueViaStacks<Integer> queue = new QueueViaStacks<>();
    queue.add(1);
    queue.add(2);
    assertEquals(1, queue.peek());
  }

  @Test
  void addaddRemoveRemove() {
    final QueueViaStacks<Integer> queue = new QueueViaStacks<>();
    queue.add(1);
    queue.add(2);
    queue.remove();
    assertEquals(2, queue.remove());
  }

  @Test
  void addaddRemovePeek() {
    final QueueViaStacks<Integer> queue = new QueueViaStacks<>();
    queue.add(1);
    queue.add(2);
    queue.remove();
    assertEquals(2, queue.peek());
  }

  @Test
  void increaseStackSize() {
    final QueueViaStacks<Integer> queue = new QueueViaStacks<>(3);
    queue.add(0);
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);
    queue.add(5);
    queue.add(6);
    queue.add(7);
    queue.add(8);
    queue.add(9);

    final StringBuilder sb = new StringBuilder();
    while (!queue.isEmpty()) {
      sb.append(queue.remove());
    }
    assertEquals("0123456789", sb.toString());
  }
}
