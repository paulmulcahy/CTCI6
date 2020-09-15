package ca.pmulcahy.ctci6.chp2;

import java.util.HashSet;
import java.util.Set;

/*
 * Write code to remove duplicates form an unsorted linked list
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class Q1_RemoveDups_NoTemporaryBuffer{
	
	public static <E> SinglyLinkedList<E> removeDuplicates(SinglyLinkedList<E> singlyLinkedList) {
		SinglyLinkedList.Node<E> i = singlyLinkedList.getHead();
		while(i!=null) {
			SinglyLinkedList.Node<E> jPrev = i;			
			SinglyLinkedList.Node<E> j = i.getNext();
			while(j!=null) {
				if(j.getData().equals(i.getData())) {
					jPrev.setNext(j.getNext());
				} else {
					jPrev = j;
				}
				j = j.getNext();
			}
			i = i.getNext();
		}
		return singlyLinkedList;
	}
	  
	
}	
