package ca.pmulcahy.ctci6.chp02.q02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ca.pmulcahy.ctci6.chp02.SinglyLinkedList;
import org.junit.jupiter.api.Test;

class TestReturnKthToTheLast {

  @Test
  void empty() {
    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();

    final Integer actual = ReturnKthToTheLast.returnKthToTheLast(sList, 0);
    assertEquals(
        null,
        actual,
        "The list: " + sList + " is empty and k equals 0- both conditions should return null.");
  }

  @Test
  void kIsZero() {
    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.add(1);
    final Integer actual = ReturnKthToTheLast.returnKthToTheLast(sList, 0);
    assertEquals(null, actual, "K equals 0 and anything zero or below should return null.");
  }

  @Test
  void kIsBelowZero() {
    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.add(1);
    final Integer actual = ReturnKthToTheLast.returnKthToTheLast(sList, -1);
    assertEquals(null, actual, "K equals -1 and anything zero or below should return null.");
  }

  @Test
  void singleValue() {
    final Integer singleInt = 1;

    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.add(singleInt);

    final Integer actual = ReturnKthToTheLast.returnKthToTheLast(sList, 1);
    assertEquals(
        singleInt,
        actual,
        "The list: "
            + sList
            + " contains 1 element (1) and the 1st to the last element should return the same"
            + " element.");
  }

  @Test
  void singleNullValue() {
    final Integer singleInt = null;

    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.add(singleInt);

    final Integer actual = ReturnKthToTheLast.returnKthToTheLast(sList, 1);
    assertEquals(
        singleInt,
        actual,
        "The list: "
            + sList
            + " contains 1 element (1) and the 1st to the last element should return the same"
            + " element.");
  }

  @Test
  void twoValuesReturnFirst() {
    final Integer firstInt = 1;
    final Integer secondInt = 2;

    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.add(firstInt);
    sList.add(secondInt);

    final Integer actual = ReturnKthToTheLast.returnKthToTheLast(sList, 2);
    assertEquals(
        firstInt,
        actual,
        "The list: "
            + sList
            + " contains 2 elements and the 2nd to the last element should return the first"
            + " element.");
  }

  @Test
  void twoValuesReturnLast() {
    final Integer firstInt = 1;
    final Integer secondInt = 2;

    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.add(firstInt);
    sList.add(secondInt);

    final Integer actual = ReturnKthToTheLast.returnKthToTheLast(sList, 1);
    assertEquals(
        secondInt,
        actual,
        "The list: "
            + sList
            + " contains 2 elements and the 1st to the last element should return the second"
            + " element.");
  }

  @Test
  void kTooLarge() {
    final Integer firstInt = 1;
    final Integer secondInt = 2;

    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.add(firstInt);
    sList.add(secondInt);

    final Integer actual = ReturnKthToTheLast.returnKthToTheLast(sList, 3);
    assertEquals(
        null,
        actual,
        "The list: "
            + sList
            + " contains less elements than the requested k and should return null.");
  }

  @Test
  void threeValuesReturnFirst() {
    final Integer firstInt = 1;
    final Integer secondInt = null;
    final Integer thirdInt = 3;

    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.add(firstInt);
    sList.add(secondInt);
    sList.add(thirdInt);

    final Integer actual = ReturnKthToTheLast.returnKthToTheLast(sList, 3);
    assertEquals(
        firstInt,
        actual,
        "The list: "
            + sList
            + " contains 3 elements and the 3rd to the last element should return the first"
            + " element.");
  }

  @Test
  void threeValuesReturnMiddle() {
    final Integer firstInt = 1;
    final Integer secondInt = null;
    final Integer thirdInt = 3;

    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.add(firstInt);
    sList.add(secondInt);
    sList.add(thirdInt);

    final Integer actual = ReturnKthToTheLast.returnKthToTheLast(sList, 2);
    assertEquals(
        secondInt,
        actual,
        "The list: "
            + sList
            + " contains 3 elements and the 2nd to the last element should return the second"
            + " element.");
  }

  @Test
  void threeValuesReturnLast() {
    final Integer firstInt = 1;
    final Integer secondInt = null;
    final Integer thirdInt = 3;

    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.add(firstInt);
    sList.add(secondInt);
    sList.add(thirdInt);

    final Integer actual = ReturnKthToTheLast.returnKthToTheLast(sList, 1);
    assertEquals(
        thirdInt,
        actual,
        "The list: "
            + sList
            + " contains 3 elements and the 1st to the last element should return the third"
            + " element.");
  }
}
