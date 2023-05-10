package ca.pmulcahy.ctci6.chp04.q01;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/*
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 *
 */
public class RouteBetweenNodes_Bidirectional {

  public static <T> boolean isRouteBetweenNodes(
      final NodeWithParents<T> startNode, final NodeWithParents<T> endNode) {
    final Queue<NodeWithParents<T>> nodesToSearchFromStart = new ArrayDeque<>();
    nodesToSearchFromStart.add(startNode);
    final Queue<NodeWithParents<T>> nodesToSearchFromEnd = new ArrayDeque<>();
    nodesToSearchFromEnd.add(endNode);

    final Set<NodeWithParents<T>> nodesConnectedToStart = new HashSet<>();
    nodesConnectedToStart.add(startNode);
    final Set<NodeWithParents<T>> nodesConnectedToEnd = new HashSet<>();
    nodesConnectedToEnd.add(endNode);

    while (!nodesToSearchFromStart.isEmpty() || !nodesToSearchFromEnd.isEmpty()) {

      if (!nodesToSearchFromStart.isEmpty()) {
        final NodeWithParents<T> node = nodesToSearchFromStart.remove();
        final Set<NodeWithParents<T>> childNodes = node.getChildren();

        for (NodeWithParents<T> child : childNodes) {
          if (nodesConnectedToEnd.contains(child)) {
            return true;
          }
          if (nodesConnectedToStart.add(child)) {
            nodesToSearchFromStart.add(child);
          }
        }
      }

      if (!nodesToSearchFromEnd.isEmpty()) {
        final NodeWithParents<T> node = nodesToSearchFromEnd.remove();
        final Set<NodeWithParents<T>> parentNodes = node.getParents();

        for (NodeWithParents<T> parent : parentNodes) {
          if (nodesConnectedToStart.contains(parent)) {
            return true;
          }
          if (nodesConnectedToEnd.add(parent)) {
            nodesToSearchFromEnd.add(parent);
          }
        }
      }
    }
    return false;
  }
}
