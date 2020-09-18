package ca.pmulcahy.ctci6.chp2;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestQ6_Palindrome {
	
	@Test
	public void empty() {
		final SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();			
		
		final boolean actual = Q6_Palindrome.isPalindrome(sList);
		assertTrue(actual,  "The list: " + sList + " is empty and so is a palindrome.");
	}
	
	@Test
	public void singleWhiteSpaceString() {
		final SinglyLinkedList<Character> sList = new SinglyLinkedList<>();
		final Character character = 'H';
		sList.add(character);
				
		final boolean actual = Q6_Palindrome.isPalindrome(sList);
		assertTrue(actual,  "The list: " + sList + " is a single character and so is a palindrome.");
	}
	
	@Test
	public void notPalindrome() {
		final Character[] inputArr = new Character[]{ '1','2' };
		final List<Character> inputList = Arrays.asList(inputArr);
		final SinglyLinkedList<Character> sList = new SinglyLinkedList<>();			
		sList.addAll(inputList);
				
		final boolean actual = Q6_Palindrome.isPalindrome(sList);
		assertFalse(actual,  "The list: " + sList + " is 2 characters and is not a palindrome.");
	}
	
	@Test
	public void complicatedPalindrome() {
		final Character[] inputArr = new Character[]{ 'a',null,'b',null,'a' };
		final List<Character> inputList = Arrays.asList(inputArr);
		final SinglyLinkedList<Character> sList = new SinglyLinkedList<>();			
		sList.addAll(inputList);
				
		final boolean actual = Q6_Palindrome.isPalindrome(sList);
		assertTrue(actual,  "The linked list: " + sList + " is complicated but is a palindrome.");
	}

	@Test
	public void complicatedNonPalindrome() {
		final Character[] inputArr = new Character[]{ 'a',null,'b',null,'a',null,'a' };
		final List<Character> inputList = Arrays.asList(inputArr);
		final SinglyLinkedList<Character> sList = new SinglyLinkedList<>();			
		sList.addAll(inputList);
				
		final boolean actual = Q6_Palindrome.isPalindrome(sList);
		assertFalse(actual,  "The linked list: " + sList + " is complicated and is not a palindrome.");
	}
	
}
