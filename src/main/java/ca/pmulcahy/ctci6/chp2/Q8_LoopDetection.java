package ca.pmulcahy.ctci6.chp2;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C (the same C as earlier)
 * Output: C
 */
public class Q8_LoopDetection{
	
	public static <E> SinglyLinkedList.Node<E> detectLoop(SinglyLinkedList<E> singlyLinkedList) {
		Set<SinglyLinkedList.Node<E>> usedNodes = new HashSet<>();
		for(SinglyLinkedList.Node<E> currentNode = singlyLinkedList.getHead();
			currentNode!=null;
			currentNode = currentNode.getNext()) {
			final boolean originalNode = usedNodes.add(currentNode);
			if(!originalNode) {
				return currentNode;
			}
		}
		return null;
	}
}	
