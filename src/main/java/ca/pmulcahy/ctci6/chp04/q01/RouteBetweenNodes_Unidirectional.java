package ca.pmulcahy.ctci6.chp04.q01;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/*
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
public class RouteBetweenNodes_Unidirectional {

  public static <T> boolean isRouteBetweenNodes(Node<T> startNode, Node<T> endNode) {
    final Queue<Node<T>> nodesToSearch = new ArrayDeque<>();
    nodesToSearch.add(startNode);

    final Set<Node<T>> connectedNodes = new HashSet<>();
    connectedNodes.add(startNode);

    while (!nodesToSearch.isEmpty()) {
      final Node<T> node = nodesToSearch.remove();
      final Set<Node<T>> childNodes = node.getChildren();

      for (Node<T> child : childNodes) {
        if (child.equals(endNode)) {
          return true;
        }
        if (connectedNodes.add(child)) {
          nodesToSearch.add(child);
        }
      }
    }
    return false;
  }
}
