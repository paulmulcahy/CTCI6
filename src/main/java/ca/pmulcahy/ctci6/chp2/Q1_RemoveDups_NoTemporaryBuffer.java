package ca.pmulcahy.ctci6.chp2;

/*
 * Write code to remove duplicates form an unsorted linked list
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class Q1_RemoveDups_NoTemporaryBuffer{
	
	public static <E> SinglyLinkedList<E> removeDuplicates(SinglyLinkedList<E> singlyLinkedList) {
		SinglyLinkedList.Node<E> nodeToCompare = singlyLinkedList.getHead();
		while(nodeToCompare!=null) {
			SinglyLinkedList.Node<E> previousNode = nodeToCompare;			
			SinglyLinkedList.Node<E> currentNode = nodeToCompare.getNext();
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
