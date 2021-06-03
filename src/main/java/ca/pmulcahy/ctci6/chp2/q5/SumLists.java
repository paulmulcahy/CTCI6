package ca.pmulcahy.ctci6.chp2.q5;

import ca.pmulcahy.ctci6.chp2.Node;
import ca.pmulcahy.ctci6.chp2.SinglyLinkedList;

/*
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295
 * Output: 2 -> 1 -> 9. That is, 912.
 * FOLLOW UP
 * Supposed the digits are stored in forward order. Repeat the above problem.
 * EXAMPLE
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295
 * Output: 2 -> 1 -> 9. That is, 912.
 */
public class SumLists{
	
	public static SinglyLinkedList<Integer> sumReverse(final SinglyLinkedList<Integer> s1, final SinglyLinkedList<Integer> s2) {	
		final SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>();
		Node<Integer> node1 = s1.getHead();
		Node<Integer> node2 = s2.getHead();
		int carry=0;
		
		while(node1!=null || node2!=null || carry!=0) {
			final int num1, num2;
			if(node1!=null) {
				num1 = node1.getData();
				node1 = node1.getNext();
			} else {
				num1 = 0;
			}
			
			if(node2!=null) {
				num2 = node2.getData();
				node2 = node2.getNext();
			} else {
				num2 = 0;
			}
			
			final int sum = (num1 + num2 + carry)%10;
			singlyLinkedList.add(sum);
			carry = (num1 + num2 + carry)/10;		
		}

		return singlyLinkedList;
	}

	public static <E extends Number> SinglyLinkedList<Integer> sumForward(final SinglyLinkedList<E> s1, final SinglyLinkedList<E> s2) {	
		final SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>();
		final SinglyLinkedList<E> s1Reversed = s1.getReverse();
		final SinglyLinkedList<E> s2Reversed = s2.getReverse();
		Node<E> node1 = s1Reversed.getHead();
		Node<E> node2 = s2Reversed.getHead();
		int carry=0;
		
		while(node1!=null || node2!=null || carry!=0) {
			final int intFromNode1, intFromNode2;
			
			if(node1!=null) {
				intFromNode1 = (Integer)node1.getData();
				node1 = node1.getNext();
			} else {
				intFromNode1 = 0;
			}
			
			if(node2!=null) {
				intFromNode2 = (Integer)node2.getData();
				node2 = node2.getNext();
			} else {
				intFromNode2 = 0;
			}
			
			final int sum = (intFromNode1 + intFromNode2 + carry)%10;
			singlyLinkedList.add(sum);
			carry = (intFromNode1 + intFromNode2 + carry)/10;		
		}

		return singlyLinkedList;
	}	
}
