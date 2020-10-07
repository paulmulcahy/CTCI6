package ca.pmulcahy.ctci6.chp2;

/*
 * Given two (sinly) linked lists, determine if the two lists intersect. Return the intersection node. Not that the intersection is defined based on reference, not value. That is, if the kth node of the first linked list is the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.
 */
public class Q7_Intersection{
	
	public static <E> SinglyLinkedList.Node<E> getIntersection(SinglyLinkedList<E> s1, SinglyLinkedList<E> s2) {	
		SinglyLinkedList.Node<E> node1 = s1.getHead();
		while(node1!=null) {
			SinglyLinkedList.Node<E> node2 = s2.getHead();
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
