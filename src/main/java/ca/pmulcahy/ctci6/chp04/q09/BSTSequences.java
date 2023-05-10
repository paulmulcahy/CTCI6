package ca.pmulcahy.ctci6.chp04.q09;

import ca.pmulcahy.ctci6.chp04.TreeNode;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * A binary search tree was created by traversing through an array from left to right and inserting each element.
 *  Given a binary search tree with distinct elements, print all possible arrays that could have led to this tree.
 */
public class BSTSequences {
  public static <T extends Comparable<T>> Set<LinkedList<T>> getSequences(final TreeNode<T> root) {
    final var results = new HashSet<LinkedList<T>>();
    if (root == null) {
      // Base Case
      results.add(new LinkedList<>());
    } else {
      final var rootData = new LinkedList<T>();
      rootData.add(root.getData());
      // Divide
      final var left = root.getLeft();
      final var leftSequences = getSequences(left);
      final var right = root.getRight();
      final var rightSequences = getSequences(right);
      // (and Conquer)
      for (final var leftSequence : leftSequences) {
        for (final var rightSequence : rightSequences) {
          weave(rootData, leftSequence, rightSequence, results);
        }
      }
    }

    return results;
  }

  /*
   * Recursively weave the first list into the second list and append it to the results list.
   * The prefix list grows by an element with the depth of the call stack.
   * Ultimately, either the first or second list will be exhausted and the base case will append a result.
   */
  public static <T extends Comparable<T>> void weave(
      final LinkedList<T> prefix,
      final LinkedList<T> leftSequence,
      final LinkedList<T> rightSequence,
      final Set<LinkedList<T>> results) {
    if (leftSequence.isEmpty() || rightSequence.isEmpty()) {
      // Recursion Base Case
      final var weavedSequence = new LinkedList<T>();
      weavedSequence.addAll(prefix);
      weavedSequence.addAll(leftSequence);
      weavedSequence.addAll(rightSequence);
      results.add(weavedSequence);
    } else {
      final var leftData = leftSequence.removeFirst();
      prefix.addLast(leftData);
      weave(prefix, leftSequence, rightSequence, results);
      prefix.removeLast();
      leftSequence.addFirst(leftData);

      final var rightData = rightSequence.removeFirst();
      prefix.addLast(rightData);
      weave(prefix, leftSequence, rightSequence, results);
      prefix.removeLast();
      rightSequence.addFirst(rightData);
    }
  }
}
