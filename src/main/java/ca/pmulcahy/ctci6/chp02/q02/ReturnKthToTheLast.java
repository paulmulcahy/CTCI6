package ca.pmulcahy.ctci6.chp02.q02;

import ca.pmulcahy.ctci6.chp02.Node;
import ca.pmulcahy.ctci6.chp02.SinglyLinkedList;

/*
 * Implement an algorithm to find the kth to the last element of a singly linked list
 */
public class ReturnKthToTheLast{
	
	public static <E> E returnKthToTheLast(final SinglyLinkedList<E> singlyLinkedList, final int k) {
		final int count = getSinglyLinkedListSize(singlyLinkedList);
		if(k > count || k < 1) {
			return null;
		}
		
		Node<E> currentNode = singlyLinkedList.getHead();		
		for(int i=0; i< count-k; i++) {
			currentNode = currentNode.getNext();			
		}
		final E kthToTheLast = (E)(currentNode.getData());
		
		return kthToTheLast;
	}
	  
	private static <E> int getSinglyLinkedListSize(final SinglyLinkedList<E> singlyLinkedList) {
		int count = 0;
		Node<E> currentNode = singlyLinkedList.getHead();
		while(currentNode!=null) {
			count++;
			currentNode = currentNode.getNext();
		}
		return count;
	}
}	
