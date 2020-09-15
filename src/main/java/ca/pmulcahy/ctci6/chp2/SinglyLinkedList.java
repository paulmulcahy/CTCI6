package ca.pmulcahy.ctci6.chp2;

public class SinglyLinkedList<E> {
	
    static class Node<E>{    
        private E data;    
        private Node next;    
            
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
		
		Node getNext() {
			return next;
		}
		
		void setNext(Node next) {
			this.next = next;
		}
	}
  
    private Node head = null;
    private Node tail = null;
	
	public Node getHead() {
		return head;
	}
	
	public void setHead(Node head) {
		this.head = head;
	}
	
	public Node getTail() {
		return tail;
	}
	
	public void setTail(Node tail) {
		this.tail = tail;
	}	
	
    public void add(E data) { 
	    Node node = new Node(data); 

		if(head == null) {    
            head = node;    
            tail = node;    
        } else {
			tail.setNext(node);
			tail = node;
		}
    }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node current = head;
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
		SinglyLinkedList singlyLinkedList = (SinglyLinkedList)o;
		
		Node tHead = this.getHead();
		Node oHead = singlyLinkedList.getHead();

		while(tHead!=null && oHead!=null) {
			
			if(!tHead.getData().equals(oHead.getData())) {
				return false;
			}
			
			tHead = tHead.getNext();
			oHead = oHead.getNext();
		}

		if(tHead==null && oHead==null) {
			return true;
		}
		return false;
	}

}