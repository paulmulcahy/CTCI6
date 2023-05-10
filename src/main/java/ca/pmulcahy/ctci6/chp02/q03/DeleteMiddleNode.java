package ca.pmulcahy.ctci6.chp02.q03;

import ca.pmulcahy.ctci6.chp02.Node;
import ca.pmulcahy.ctci6.chp02.SinglyLinkedList;

/*
 * Implement an algorithm to delete a node in the middle (ie any node but the first and last node, not necessarily the middle)
 * of a singly linked list, given only access to that node.
 */
public class DeleteMiddleNode {

  public static <E> SinglyLinkedList<E> deleteNode(
      final SinglyLinkedList<E> singlyLinkedList, final E e) {
    Node<E> previousNode = singlyLinkedList.getHead();
    if (previousNode != null) {
      Node<E> currentNode = previousNode.getNext();
      while (currentNode != null && currentNode != singlyLinkedList.getTail()) {
        if ((e == null && currentNode.getData() == null)
            || (e != null && e.equals(currentNode.getData()))) {
          previousNode.setNext(currentNode.getNext());
          break;
        } else {
          previousNode = currentNode;
          currentNode = currentNode.getNext();
        }
      }
    }
    return singlyLinkedList;
  }
}
