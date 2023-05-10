package ca.pmulcahy.ctci6.chp02.q05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ca.pmulcahy.ctci6.chp02.SinglyLinkedList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestSumLists {

  @Test
  public void emptyReverse() {
    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();

    final SinglyLinkedList<Integer> actual = SumLists.sumReverse(sList, sList);
    assertEquals(
        sList,
        actual,
        "The summed lists: "
            + sList
            + " and "
            + sList
            + " are empty and so the empty list should be returned.");
  }

  @Test
  public void emptyForward() {
    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();

    final SinglyLinkedList<Integer> actual = SumLists.sumForward(sList, sList);
    assertEquals(
        sList,
        actual,
        "The summed lists: "
            + sList
            + " and "
            + sList
            + " are empty and so the empty list should be returned.");
  }

  @Test
  public void lengthOneReverse() {
    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.add(1);

    final SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
    expected.add(2);

    final SinglyLinkedList<Integer> actual = SumLists.sumReverse(sList, sList);
    assertEquals(
        expected,
        actual,
        "The lists: "
            + sList
            + " and "
            + sList
            + " have only 1 element each so the result should be "
            + expected);
  }

  @Test
  public void lengthOneForward() {
    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
    sList.add(1);

    final SinglyLinkedList<Integer> expected = new SinglyLinkedList<>();
    expected.add(2);

    final SinglyLinkedList<Integer> actual = SumLists.sumReverse(sList, sList);
    assertEquals(
        expected,
        actual,
        "The lists: "
            + sList
            + " and "
            + sList
            + " have only 1 element each so the result should be "
            + expected);
  }

  @Test
  public void bookReverse() {
    final Integer[] inputArr1 = new Integer[] {7, 1, 6};
    final List<Integer> inputList1 = Arrays.asList(inputArr1);
    final SinglyLinkedList<Integer> sList1 = new SinglyLinkedList<>();
    sList1.addAll(inputList1);

    final Integer[] inputArr2 = new Integer[] {5, 9, 2};
    final List<Integer> inputList2 = Arrays.asList(inputArr2);
    final SinglyLinkedList<Integer> sList2 = new SinglyLinkedList<>();
    sList2.addAll(inputList2);

    final Integer[] expectedArr = new Integer[] {2, 1, 9};
    final List<Integer> expectedList = Arrays.asList(expectedArr);
    final SinglyLinkedList<Integer> expectedLinkedList = new SinglyLinkedList<>();
    expectedLinkedList.addAll(expectedList);

    final SinglyLinkedList<Integer> actual = SumLists.sumReverse(sList1, sList2);
    assertEquals(
        expectedLinkedList,
        actual,
        "The lists: "
            + sList1
            + " and "
            + sList2
            + " are detailed in the book and the result should be "
            + expectedLinkedList);
  }

  @Test
  public void bookForward() {
    final Integer[] inputArr1 = new Integer[] {6, 1, 7};
    final List<Integer> inputList1 = Arrays.asList(inputArr1);
    final SinglyLinkedList<Integer> sList1 = new SinglyLinkedList<>();
    sList1.addAll(inputList1);

    final Integer[] inputArr2 = new Integer[] {2, 9, 5};
    final List<Integer> inputList2 = Arrays.asList(inputArr2);
    final SinglyLinkedList<Integer> sList2 = new SinglyLinkedList<>();
    sList2.addAll(inputList2);

    final Integer[] expectedArr = new Integer[] {2, 1, 9};
    final List<Integer> expectedList = Arrays.asList(expectedArr);
    final SinglyLinkedList<Integer> expectedLinkedList = new SinglyLinkedList<>();
    expectedLinkedList.addAll(expectedList);

    final SinglyLinkedList<Integer> actual = SumLists.sumForward(sList1, sList2);
    assertEquals(
        expectedLinkedList,
        actual,
        "The lists: "
            + sList1
            + " and "
            + sList2
            + " are detailed in the book and the result should be "
            + expectedLinkedList);
  }
}
