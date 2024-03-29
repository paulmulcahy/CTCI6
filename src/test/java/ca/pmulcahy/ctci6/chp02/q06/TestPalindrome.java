package ca.pmulcahy.ctci6.chp02.q06;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ca.pmulcahy.ctci6.chp02.SinglyLinkedList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class TestPalindrome {

  @Test
  void empty() {
    final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();

    final boolean actual = Palindrome.isPalindrome(sList);
    assertTrue(actual, "The list: " + sList + " is empty and so is a palindrome.");
  }

  @Test
  void singleWhiteSpaceString() {
    final SinglyLinkedList<Character> sList = new SinglyLinkedList<>();
    final Character character = 'H';
    sList.add(character);

    final boolean actual = Palindrome.isPalindrome(sList);
    assertTrue(actual, "The list: " + sList + " is a single character and so is a palindrome.");
  }

  @Test
  void notPalindrome() {
    final Character[] inputArr = new Character[] {'1', '2'};
    final List<Character> inputList = Arrays.asList(inputArr);
    final SinglyLinkedList<Character> sList = new SinglyLinkedList<>();
    sList.addAll(inputList);

    final boolean actual = Palindrome.isPalindrome(sList);
    assertFalse(actual, "The list: " + sList + " is 2 characters and is not a palindrome.");
  }

  @Test
  void complicatedPalindrome() {
    final Character[] inputArr = new Character[] {'a', null, 'b', null, 'a'};
    final List<Character> inputList = Arrays.asList(inputArr);
    final SinglyLinkedList<Character> sList = new SinglyLinkedList<>();
    sList.addAll(inputList);

    final boolean actual = Palindrome.isPalindrome(sList);
    assertTrue(actual, "The linked list: " + sList + " is complicated but is a palindrome.");
  }

  @Test
  void complicatedNonPalindrome() {
    final Character[] inputArr = new Character[] {'a', null, 'b', null, 'a', null, 'a'};
    final List<Character> inputList = Arrays.asList(inputArr);
    final SinglyLinkedList<Character> sList = new SinglyLinkedList<>();
    sList.addAll(inputList);

    final boolean actual = Palindrome.isPalindrome(sList);
    assertFalse(actual, "The linked list: " + sList + " is complicated and is not a palindrome.");
  }
}
