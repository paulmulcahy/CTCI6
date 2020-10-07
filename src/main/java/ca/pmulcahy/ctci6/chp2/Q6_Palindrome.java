package ca.pmulcahy.ctci6.chp2;

/*
 * Implement a function to check if a linked list is a palindrome.
 */
public class Q6_Palindrome{
	
	public static <E> boolean isPalindrome(SinglyLinkedList<E> singlyLinkedList) {	
		SinglyLinkedList<E> reversedList = singlyLinkedList.getReverse();
		
		SinglyLinkedList.Node<E> node1 = singlyLinkedList.getHead();
		SinglyLinkedList.Node<E> node2 = reversedList.getHead();
		
		while(node1!=null || node2!=null) {
			if((node1.getData()==null && node2.getData()==null) 
				|| (node1.getData()!=null && node1.getData().equals(node2.getData()))) {
				node1 = node1.getNext();
				node2 = node2.getNext();				
			} else {
				return false;
			}
		}
		return true;
	}

	
}