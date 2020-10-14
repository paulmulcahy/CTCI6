package ca.pmulcahy.ctci6.chp2;

import java.util.Collection;
import java.util.Optional;

public class SinglyLinkedList<E> {
  
    private Node<E> head = null;
    private Node<E> tail = null;
	
	public Node<E> getHead() {
		return head;
	}
	
	public void setHead(Node<E> head) {
		this.head = head;
	}
	
	public Node<E> getTail() {
		return tail;
	}
	
	public void setTail(Node<E> tail) {
		this.tail = tail;
	}	
	
    public boolean add(E data) { 
	    Node<E> node = new Node<>(data); 

		if(head == null) {    
            head = node;    
            tail = node;    
        } else {
			tail.setNext(node);
			tail = node;
		}
		return true;
    }
	
	public boolean addToStart(E data) { 
	    Node<E> node = new Node<>(data); 

		if(head == null) {
			tail = node;
		} else {
			node.setNext(head);
		}
		head = node;
		
		return true;
    }
    
    public boolean addAll(Collection<? extends E> data) {
    	for(E e: data) {
    		add(e);
    	}
    	return true;
    }

    public boolean addNode(Node<E> node) { 
		if(head == null) {    
            head = node;    
            tail = node;    
        } else {
			tail.setNext(node);
			tail = node;
		}
		return true;
    }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<E> current = head;
		sb.append("[");
		if(current!=null) {
			sb.append(current.getData());
			current = current.getNext();
		}
		while(current!=null) {
			sb.append("," + current.getData());
			current = current.getNext();
		}
		
		sb.append("]");
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o) {
        if (o == this) { 
            return true; 
        } 
  
        if (!(o instanceof SinglyLinkedList)) { 
            return false; 
        } 
		SinglyLinkedList<?> singlyLinkedList = (SinglyLinkedList<?>)o;
		
		Node<?> tNode = this.getHead();
		Node<?> oNode = singlyLinkedList.getHead();

		while(tNode!=null && oNode!=null) {
			
			if(!tNode.getOptionalData().equals(oNode.getOptionalData())) {
				return false;
			}
			
			tNode = tNode.getNext();
			oNode = oNode.getNext();
		}

		if(tNode==null && oNode==null) {
			return true;
		}
		return false;
	}
	
	public SinglyLinkedList<E> getReverse() {
		SinglyLinkedList<E> reversed = new SinglyLinkedList<E>();
		Node<E> current = this.getHead();
		while(current!=null) {
			reversed.addToStart(current.getData());
			current = current.getNext();
		}
		
		return reversed;
		
	}

}