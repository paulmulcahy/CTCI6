package ca.pmulcahy.ctci6.chp02.q06;

import ca.pmulcahy.ctci6.chp02.Node;
import ca.pmulcahy.ctci6.chp02.SinglyLinkedList;

/*
 * Implement a function to check if a linked list is a palindrome.
 */
public class Palindrome{
	
	public static <E> boolean isPalindrome(final SinglyLinkedList<E> singlyLinkedList) {	
		final SinglyLinkedList<E> reversedList = singlyLinkedList.getReverse();
		
		Node<E> node1 = singlyLinkedList.getHead();
		Node<E> node2 = reversedList.getHead();
		
		while(node1!=null || node2!=null) {
			if((node1.getData()==null && node2.getData()==null) 
				|| (node1.getData()!=null && node1.getData().equals(node2.getData()))) {
				node1 = node1.getNext();
				node2 = node2.getNext();				
			} else {
				return false;
			}
		}
		return true;
	}

	
}
