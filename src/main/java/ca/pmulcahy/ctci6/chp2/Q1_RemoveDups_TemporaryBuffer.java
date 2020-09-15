package ca.pmulcahy.ctci6.chp2;

import java.util.HashSet;
import java.util.Set;

/*
 * Write code to remove duplicates form an unsorted linked list
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class Q1_RemoveDups_TemporaryBuffer{
	
	public static <E> SinglyLinkedList<E> removeDuplicates(SinglyLinkedList<E> singlyLinkedList) {
		Set<E> itemsNoDuplicates = new HashSet<>();
		SinglyLinkedList<E> temporaryBuffer = new SinglyLinkedList<>();

		SinglyLinkedList.Node<E> current = singlyLinkedList.getHead();		
		while(current!=null) {
			if(itemsNoDuplicates.add(current.getData())) {
				temporaryBuffer.add(current.getData());
			}
			current = current.getNext();
		}
		return temporaryBuffer;
	}
	  
	
}	
