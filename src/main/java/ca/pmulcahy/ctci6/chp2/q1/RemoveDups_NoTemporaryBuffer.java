package ca.pmulcahy.ctci6.chp2.q1;

import ca.pmulcahy.ctci6.chp2.Node;
import ca.pmulcahy.ctci6.chp2.SinglyLinkedList;

/*
 * Write code to remove duplicates form an unsorted linked list
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDups_NoTemporaryBuffer{
	
	public static <E> SinglyLinkedList<E> removeDuplicates(final SinglyLinkedList<E> singlyLinkedList) {
		Node<E> nodeToCompare = singlyLinkedList.getHead();
		while(nodeToCompare!=null) {
			Node<E> previousNode = nodeToCompare;			
			Node<E> currentNode = nodeToCompare.getNext();
			while(currentNode!=null) {
				if(currentNode.getOptionalData().equals(nodeToCompare.getOptionalData())) {
					previousNode.setNext(currentNode.getNext());
				} else {
					previousNode = currentNode;
				}
				currentNode = currentNode.getNext();
			}
			nodeToCompare = nodeToCompare.getNext();
		}
		return singlyLinkedList;
	}
	  
	
}	
