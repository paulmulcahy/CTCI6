package ca.pmulcahy.ctci6.chp2.q7;

import ca.pmulcahy.ctci6.chp2.Node;
import ca.pmulcahy.ctci6.chp2.SinglyLinkedList;

/*
 * Given two (sinly) linked lists, determine if the two lists intersect. Return the intersection node. Not that the intersection is defined based on reference, not value. That is, if the kth node of the first linked list is the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.
 */
public class Intersection{
	
	public static <E> Node<E> getIntersection(final SinglyLinkedList<E> s1, final SinglyLinkedList<E> s2) {	
		Node<E> node1 = s1.getHead();
		while(node1!=null) {
			Node<E> node2 = s2.getHead();
			while(node2!=null) {
				if(node1==node2) {
					return node1;
				}
				node2 = node2.getNext();
			}

			node1 = node1.getNext();
		}
		return null;
	}

	
}
