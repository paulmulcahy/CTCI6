package ca.pmulcahy.ctci6.chp04.q01;

import java.util.HashSet;
import java.util.Set;

public class Node<T> {
  private T data;
  private Set<Node<T>> children;

  public Node(final T data) {
    this.data = data;
    this.children = new HashSet<Node<T>>();
  }

  public T getData() {
    return data;
  }

  public Set<Node<T>> getChildren() {
    return children;
  }

  public boolean addChild(final Node<T> child) {
    return children.add(child);
  }
}
