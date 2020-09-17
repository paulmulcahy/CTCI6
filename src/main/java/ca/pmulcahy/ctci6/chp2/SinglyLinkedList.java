package ca.pmulcahy.ctci6.chp2;

import java.util.Collection;

public class SinglyLinkedList<E> {
	
    static class Node<E>{    
        private E data;    
        private Node<E> next;    
            
        Node(E data) {    
            this.data = data;    
            this.next = null;    
        }
		
		E getData() {
			return data;
		}
		
		void setData(E data) {
			this.data = data;
		}
		
		Node<E> getNext() {
			return next;
		}
		
		void setNext(Node<E> next) {
			this.next = next;
		}
		
		@Override
		public boolean equals(Object o) {
			if (o == this) { 
				return true; 
			} 
	  
			if (!(o instanceof Node)) { 
				return false; 
			} 
			Node<?> node = (Node<?>)o;
			if(node.getData() == null) {
				if(this.getData() == null) {
					return true;
				}
				return false;
			}
			if(node.getData().equals(this.getData())) {
				return true;
			}
			return false;
		}
	}
  
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
    
    public boolean addAll(Collection<E> data) {
    	for(E e: data) {
    		add(e);
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
			sb.append("," + current.data);
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
			
			if(!tNode.equals(oNode)) {
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

}