package ca.pmulcahy.ctci6.chp2;

import java.util.Optional;

/*
 * ca.pmulcahy.ctci6.chp2.SinglyLinkedList Node
 * Typically this would be an inner class within ca.pmulcahy.ctci6.chp2.SinglyLinkedList, but inner classes do not have public access which is required to be viewable by classes in other packages.
 *
 */

public class Node<E>{    
	private Optional<E> data;    
	private Node<E> next;    
		
	public Node(E data) {    
		this.data = Optional.ofNullable(data);    
		this.next = null;    
	}
	
	public E getData() {
		return data.orElse(null);
	}
	
	public Optional<E> getOptionalData() {
		return data;
	}
	
	public void setData(E data) {
		this.data = Optional.ofNullable(data);
	}
	
	public Node<E> getNext() {
		return next;
	}
	
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		if(data.isPresent()) {
			return data.get().toString();
		} 
		return "null";
	}
}