package ca.pmulcahy.ctci6.chp04.q01;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestRouteBetweenNodes_Unidirectional {

  @Test
  public void sameNodeUnconnected() {
    final Node<Integer> node = new Node<>(1);
    assertFalse(RouteBetweenNodes_Unidirectional.isRouteBetweenNodes(node, node));
  }

  @Test
  public void selfConnectedNode() {
    final Node<Integer> node = new Node<>(1);
    node.addChild(node);
    assertTrue(RouteBetweenNodes_Unidirectional.isRouteBetweenNodes(node, node));
  }

  @Test
  public void unconnectedNodes() {
    final Node<Integer> node1 = new Node<>(1);
    final Node<Integer> node2 = new Node<>(2);
    assertFalse(RouteBetweenNodes_Unidirectional.isRouteBetweenNodes(node1, node2));
  }

  @Test
  public void directlyConnectedNodesBidirectional() {
    final Node<Integer> node1 = new Node<>(1);
    final Node<Integer> node2 = new Node<>(2);
    node1.addChild(node2);
    node2.addChild(node1);
    assertTrue(RouteBetweenNodes_Unidirectional.isRouteBetweenNodes(node1, node2));
  }

  @Test
  public void directlyConnectedNodesUnidirectional() {
    final Node<Integer> node1 = new Node<>(1);
    final Node<Integer> node2 = new Node<>(2);
    node1.addChild(node2);
    assertTrue(RouteBetweenNodes_Unidirectional.isRouteBetweenNodes(node1, node2));
  }

  @Test
  public void directlyConnectedNodesUnidirectionalOtherWay() {
    final Node<Integer> node1 = new Node<>(1);
    final Node<Integer> node2 = new Node<>(2);
    node2.addChild(node1);
    assertFalse(RouteBetweenNodes_Unidirectional.isRouteBetweenNodes(node1, node2));
  }

  @Test
  public void connectedByOneNodeBidirectional() {
    final Node<Integer> node1 = new Node<>(1);
    final Node<Integer> node2 = new Node<>(2);
    final Node<Integer> middle = new Node<>(3);
    node1.addChild(middle);
    node2.addChild(middle);
    middle.addChild(node1);
    middle.addChild(node2);
    assertTrue(RouteBetweenNodes_Unidirectional.isRouteBetweenNodes(node1, node2));
  }

  @Test
  public void connectedByOneNodeUnidirectional() {
    final Node<Integer> node1 = new Node<>(1);
    final Node<Integer> node2 = new Node<>(2);
    final Node<Integer> middle = new Node<>(3);
    node1.addChild(middle);
    middle.addChild(node2);
    assertTrue(RouteBetweenNodes_Unidirectional.isRouteBetweenNodes(node1, node2));
  }

  @Test
  public void connectedByOneNodeUnidirectionalOtherWay() {
    final Node<Integer> node1 = new Node<>(1);
    final Node<Integer> node2 = new Node<>(2);
    final Node<Integer> middle = new Node<>(3);
    node2.addChild(middle);
    middle.addChild(node1);
    assertFalse(RouteBetweenNodes_Unidirectional.isRouteBetweenNodes(node1, node2));
  }

  @Test
  public void connectedToMiddleNodeOnly() {
    final Node<Integer> node1 = new Node<>(1);
    final Node<Integer> node2 = new Node<>(2);
    final Node<Integer> middle = new Node<>(3);
    node1.addChild(middle);
    node2.addChild(middle);
    assertFalse(RouteBetweenNodes_Unidirectional.isRouteBetweenNodes(node1, node2));
  }

  @Test
  public void moreComplicated() {
    final Node<Character> a = new Node<>('A');
    final Node<Character> b = new Node<>('B');
    final Node<Character> c = new Node<>('C');
    final Node<Character> d = new Node<>('D');
    final Node<Character> e = new Node<>('E');
    final Node<Character> f = new Node<>('F');
    final Node<Character> g = new Node<>('G');
    a.addChild(b);
    a.addChild(d);
    a.addChild(e);
    b.addChild(c);
    b.addChild(d);
    d.addChild(a);
    d.addChild(c);
    d.addChild(e);
    f.addChild(g);
    g.addChild(d);
    assertFalse(RouteBetweenNodes_Unidirectional.isRouteBetweenNodes(a, f));
  }

  @Test
  public void moreComplicated2() {
    final Node<Character> a = new Node<>('A');
    final Node<Character> b = new Node<>('B');
    final Node<Character> c = new Node<>('C');
    final Node<Character> d = new Node<>('D');
    final Node<Character> e = new Node<>('E');
    final Node<Character> f = new Node<>('F');
    final Node<Character> g = new Node<>('G');
    a.addChild(b);
    a.addChild(d);
    a.addChild(e);
    b.addChild(c);
    b.addChild(d);
    d.addChild(a);
    d.addChild(c);
    d.addChild(e);
    f.addChild(g);
    g.addChild(d);
    assertTrue(RouteBetweenNodes_Unidirectional.isRouteBetweenNodes(g, b));
  }
}
