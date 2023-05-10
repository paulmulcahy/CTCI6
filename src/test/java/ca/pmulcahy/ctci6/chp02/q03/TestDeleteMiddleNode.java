package ca.pmulcahy.ctci6.chp02.q03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ca.pmulcahy.ctci6.chp02.SinglyLinkedList;
import org.junit.jupiter.api.Test;

public class TestDeleteMiddleNode {

  @Test
  public void empty() {
    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();

    final SinglyLinkedList<Integer> actual = DeleteMiddleNode.deleteNode(sList, 0);
    assertEquals(
        sList,
        actual,
        "The list: " + sList + " is empty and so the empty list should be returned.");
  }

  @Test
  public void lengthOne() {
    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.add(1);

    final SinglyLinkedList<Integer> actual = DeleteMiddleNode.deleteNode(sList, 1);
    assertEquals(
        sList,
        actual,
        "The list: " + sList + " has only 1 element and so the original list should be returned.");
  }

  @Test
  public void lengthTwoDeleteHead() {
    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.add(1);
    sList.add(2);

    final SinglyLinkedList<Integer> actual = DeleteMiddleNode.deleteNode(sList, 1);
    assertEquals(
        sList,
        actual,
        "The list: "
            + sList
            + " has only 2 elements (head and tail) and so the original list should be returned.");
  }

  @Test
  public void lengthTwoDeleteTail() {
    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.add(1);
    sList.add(2);

    final SinglyLinkedList<Integer> actual = DeleteMiddleNode.deleteNode(sList, 2);
    assertEquals(
        sList,
        actual,
        "The list: "
            + sList
            + " has only 2 elements (head and tail) and so the original list should be returned.");
  }

  @Test
  public void threeDuplicateElements() {
    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.add(1);
    sList.add(1);
    sList.add(1);

    final SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
    expected.add(1);
    expected.add(1);

    final SinglyLinkedList<Integer> actual = DeleteMiddleNode.deleteNode(sList, 1);
    assertEquals(
        expected,
        actual,
        "The list: "
            + sList
            + " has 3 duplicates elements and should be shortened to 2 duplicate elements.");
  }

  @Test
  public void fourElementsRemoveSecond() {
    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.add(1);
    sList.add(2);
    sList.add(null);
    sList.add(3);

    final SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
    expected.add(1);
    expected.add(null);
    expected.add(3);

    final SinglyLinkedList<Integer> actual = DeleteMiddleNode.deleteNode(sList, 2);
    assertEquals(
        expected,
        actual,
        "The list: " + sList + " has 4 elements and should be shortened to 3 elements.");
  }

  @Test
  public void fourElementsRemoveNullThird() {
    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.add(1);
    sList.add(2);
    sList.add(null);
    sList.add(3);

    final SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
    expected.add(1);
    expected.add(2);
    expected.add(3);

    final SinglyLinkedList<Integer> actual = DeleteMiddleNode.deleteNode(sList, null);
    assertEquals(
        expected,
        actual,
        "The list: " + sList + " has 4 elements and should be shortened to 3 elements.");
  }

  @Test
  public void fourElementsRemoveNonNullThird() {
    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.add(1);
    sList.add(2);
    sList.add(3);
    sList.add(null);

    final SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
    expected.add(1);
    expected.add(2);
    expected.add(null);

    final SinglyLinkedList<Integer> actual = DeleteMiddleNode.deleteNode(sList, 3);
    assertEquals(
        expected,
        actual,
        "The list: " + sList + " has 4 elements and should be shortened to 3 elements.");
  }
}
