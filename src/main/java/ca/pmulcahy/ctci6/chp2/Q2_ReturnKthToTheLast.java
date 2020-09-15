package ca.pmulcahy.ctci6.chp2;

import java.util.HashSet;
import java.util.Set;

/*
 * Implement an algorithm to find the kth to the last element of a singly linked list
 */
public class Q2_ReturnKthToTheLast{
	
	public static <E> E returnKthToTheLast(SinglyLinkedList<E> singlyLinkedList, int k) {
		int count = getSinglyLinkedListSize(singlyLinkedList);
		if(k > count || k < 1) {
			return null;
		}
		
		SinglyLinkedList.Node<E> current = singlyLinkedList.getHead();		
		for(int i=0; i< count-k; i++) {
			current = current.getNext();			
		}
		E kthToTheLast = (E)(current.getData());
		
		return kthToTheLast;
	}
	  
	private static <E> int getSinglyLinkedListSize(SinglyLinkedList<E> singlyLinkedList) {
		int count = 0;
		SinglyLinkedList.Node<E> current = singlyLinkedList.getHead();
		while(current!=null) {
			count++;
			current = current.getNext();
		}
		return count;
	}
}	
