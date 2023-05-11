package ca.pmulcahy.ctci6.chp02.q08;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import ca.pmulcahy.ctci6.chp02.Node;
import ca.pmulcahy.ctci6.chp02.SinglyLinkedList;
import org.junit.jupiter.api.Test;

class TestLoopDetection {

  @Test
  void empty() {
    final SinglyLinkedList<Character> sList = new SinglyLinkedList<>();

    final Node<Character> actual = LoopDetection.detectLoop(sList);
    assertNull(
        actual, "The list is empty and a null value should be returned instead of " + actual + ".");
  }

  @Test
  void noLoop() {
    final SinglyLinkedList<Character> sList = new SinglyLinkedList<>();
    sList.add('A');
    sList.add('B');
    sList.add('C');
    sList.add('D');
    sList.add('E');

    final Node<Character> actual = LoopDetection.detectLoop(sList);
    assertNull(
        actual, "The list has no and a null value should be returned instead of " + actual + ".");
  }

  @Test
  void duplicateAtBeginning() {
    final Node<Character> duplicate = new Node<>('A');
    final SinglyLinkedList<Character> sList = new SinglyLinkedList<>();
    sList.addNode(duplicate);
    sList.add('B');
    sList.add('C');
    sList.addNode(duplicate);

    final Node<Character> actual = LoopDetection.detectLoop(sList);
    assertEquals(
        duplicate,
        actual,
        "The list has a loop at "
            + duplicate
            + " and that value should be returned instead of "
            + actual
            + ".");
  }

  @Test
  void immediateDuplicate() {
    final Node<Character> duplicate = new Node<>('C');
    final SinglyLinkedList<Character> sList = new SinglyLinkedList<>();
    sList.add('A');
    sList.add('B');
    sList.addNode(duplicate);
    sList.addNode(duplicate);

    final Node<Character> actual = LoopDetection.detectLoop(sList);
    assertEquals(
        duplicate,
        actual,
        "The list has a loop at "
            + duplicate
            + " and that value should be returned instead of "
            + actual
            + ".");
  }

  @Test
  void bookExample() {
    final Node<Character> duplicate = new Node<>('C');
    final SinglyLinkedList<Character> sList = new SinglyLinkedList<>();
    sList.add('A');
    sList.add('B');
    sList.addNode(duplicate);
    sList.add('D');
    sList.add('E');
    sList.addNode(duplicate);

    final Node<Character> actual = LoopDetection.detectLoop(sList);
    assertEquals(
        duplicate,
        actual,
        "The list has a loop at "
            + duplicate
            + " and that value should be returned instead of "
            + actual
            + ".");
  }
}
