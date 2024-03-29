package ca.pmulcahy.ctci6.chp02.q01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ca.pmulcahy.ctci6.chp02.SinglyLinkedList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class TestRemoveDups_NoTemporaryBuffer {

  @Test
  void empty() {
    final Integer[] inputArr = new Integer[] {};
    final List<Integer> inputList = Arrays.asList(inputArr);

    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.addAll(inputList);

    final SinglyLinkedList<Integer> actual = RemoveDups_NoTemporaryBuffer.removeDuplicates(sList);
    assertEquals(
        sList, actual, "The list: " + inputList + " is empty and should not have changed.");
  }

  @Test
  void noDuplicates() {
    final Integer[] inputArr = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    final List<Integer> inputList = Arrays.asList(inputArr);

    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.addAll(inputList);

    final SinglyLinkedList<Integer> actual = RemoveDups_NoTemporaryBuffer.removeDuplicates(sList);
    assertEquals(
        sList,
        actual,
        "The list: " + inputList + " has all unique values and should not be changed.");
  }

  @Test
  void noDuplicatesWithNull() {
    final Integer[] inputArr = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, null};
    final List<Integer> inputList = Arrays.asList(inputArr);

    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.addAll(inputList);

    final SinglyLinkedList<Integer> actual = RemoveDups_NoTemporaryBuffer.removeDuplicates(sList);
    assertEquals(
        sList,
        actual,
        "The list: " + inputList + " has all unique values and should not be changed.");
  }

  @Test
  void duplicatesOfSingle() {
    final Integer[] inputArr = new Integer[] {1, 1, 1, 1, 1};
    final List<Integer> inputList = Arrays.asList(inputArr);

    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.addAll(inputList);

    final SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
    expected.add(1);

    final SinglyLinkedList<Integer> actual = RemoveDups_NoTemporaryBuffer.removeDuplicates(sList);
    assertEquals(
        expected,
        actual,
        "The list: " + inputList + " is all duplicates and should be changed to one value.");
  }

  @Test
  void duplicatesOfSingleNull() {
    final Integer[] inputArr = new Integer[] {null, null, null, null, null};
    final List<Integer> inputList = Arrays.asList(inputArr);

    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.addAll(inputList);

    final SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
    expected.add(null);

    final SinglyLinkedList<Integer> actual = RemoveDups_NoTemporaryBuffer.removeDuplicates(sList);
    assertEquals(
        expected,
        actual,
        "The list: " + inputList + " is all duplicates and should be changed to one value.");
  }

  @Test
  void duplicates() {
    final Integer[] inputArr = new Integer[] {1, 1, 2, 2, 2, 3, 3};
    final List<Integer> inputList = Arrays.asList(inputArr);

    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.addAll(inputList);

    final SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
    expected.add(1);
    expected.add(2);
    expected.add(3);

    final SinglyLinkedList<Integer> actual = RemoveDups_NoTemporaryBuffer.removeDuplicates(sList);
    assertEquals(
        expected,
        actual,
        "The list: " + inputList + " has duplicates and should be changed to remove them.");
  }

  @Test
  void duplicatesWithNulls() {
    final Integer[] inputArr = new Integer[] {1, 1, 2, 2, 2, 3, 3, null, null};
    final List<Integer> inputList = Arrays.asList(inputArr);

    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    for (Integer i : inputList) {
      sList.add(i);
    }

    final SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
    expected.add(1);
    expected.add(2);
    expected.add(3);
    expected.add(null);

    final SinglyLinkedList<Integer> actual = RemoveDups_NoTemporaryBuffer.removeDuplicates(sList);
    assertEquals(
        expected,
        actual,
        "The list: " + inputList + " has duplicates and should be changed to remove them.");
  }
}
