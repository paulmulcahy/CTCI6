package ca.pmulcahy.ctci6.chp2;

/*
 * Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.
 * If x is contained within the list, the values of x only need to be after the elements less than x. The partition element x can appear anywhere
 * in the "right partition"; it does not need to appear between the left and right partitions.
 * EXAMPLE
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 (partition = 5)
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
public class Q4_Partition{
	
	public static <E extends Comparable<E>> SinglyLinkedList<E> partition(SinglyLinkedList<E> singlyLinkedList, E e) {	
		SinglyLinkedList.Node<E> previousNode = singlyLinkedList.getHead();
		if(previousNode != null && e!= null) {
			SinglyLinkedList.Node<E> currentNode = previousNode.getNext();		
			while(currentNode != null) {
				if(currentNode.getData()==null || currentNode.getData().compareTo(e)<0) {
					if(currentNode == singlyLinkedList.getTail()) {
						previousNode.setNext(null);
						singlyLinkedList.setTail(previousNode);
					} else {
						previousNode.setNext(currentNode.getNext());
					}
					singlyLinkedList.addToStart(currentNode.getData());
				} else {
					previousNode = previousNode.getNext();
				}
				currentNode = currentNode.getNext();
			}
		}
		return singlyLinkedList;
	}
	
}
