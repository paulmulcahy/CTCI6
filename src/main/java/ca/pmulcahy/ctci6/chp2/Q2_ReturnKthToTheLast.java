package ca.pmulcahy.ctci6.chp2;

/*
 * Implement an algorithm to find the kth to the last element of a singly linked list
 */
public class Q2_ReturnKthToTheLast{
	
	public static <E> E returnKthToTheLast(SinglyLinkedList<E> singlyLinkedList, int k) {
		int count = getSinglyLinkedListSize(singlyLinkedList);
		if(k > count || k < 1) {
			return null;
		}
		
		SinglyLinkedList.Node<E> currentNode = singlyLinkedList.getHead();		
		for(int i=0; i< count-k; i++) {
			currentNode = currentNode.getNext();			
		}
		E kthToTheLast = (E)(currentNode.getData());
		
		return kthToTheLast;
	}
	  
	private static <E> int getSinglyLinkedListSize(SinglyLinkedList<E> singlyLinkedList) {
		int count = 0;
		SinglyLinkedList.Node<E> currentNode = singlyLinkedList.getHead();
		while(currentNode!=null) {
			count++;
			currentNode = currentNode.getNext();
		}
		return count;
	}
}	
