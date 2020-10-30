package ca.pmulcahy.ctci6.chp4.q1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRouteBetweenNodes_Bidirectional {

	@Test
	public void sameNodeUnconnected() {
		final NodeWithParents<Integer> node = new NodeWithParents<>(1);
		assertFalse(RouteBetweenNodes_Bidirectional.isRouteBetweenNodes(node, node));
	}

	@Test
	public void selfConnectedNode() {
		final NodeWithParents<Integer> node = new NodeWithParents<>(1);
		node.addChild(node);
		assertTrue(RouteBetweenNodes_Bidirectional.isRouteBetweenNodes(node, node));
	}
	
	@Test
	public void unconnectedNodes() {
		final NodeWithParents<Integer> node1 = new NodeWithParents<>(1);
		final NodeWithParents<Integer> node2 = new NodeWithParents<>(2);
		assertFalse(RouteBetweenNodes_Bidirectional.isRouteBetweenNodes(node1, node2));
	}
	
	@Test
	public void directlyConnectedNodesBidirectional() {
		final NodeWithParents<Integer> node1 = new NodeWithParents<>(1);
		final NodeWithParents<Integer> node2 = new NodeWithParents<>(2);
		node1.addChild(node2);
		node2.addChild(node1);
		assertTrue(RouteBetweenNodes_Bidirectional.isRouteBetweenNodes(node1, node2));
	}
	
	@Test
	public void directlyConnectedNodesUnidirectional() {
		final NodeWithParents<Integer> node1 = new NodeWithParents<>(1);
		final NodeWithParents<Integer> node2 = new NodeWithParents<>(2);
		node1.addChild(node2);
		assertTrue(RouteBetweenNodes_Bidirectional.isRouteBetweenNodes(node1, node2));
	}

	@Test
	public void directlyConnectedNodesUnidirectionalOtherWay() {
		final NodeWithParents<Integer> node1 = new NodeWithParents<>(1);
		final NodeWithParents<Integer> node2 = new NodeWithParents<>(2);
		node2.addChild(node1);
		assertFalse(RouteBetweenNodes_Bidirectional.isRouteBetweenNodes(node1, node2));
	}

	@Test
	public void connectedByOneNodeBidirectional() {
		final NodeWithParents<Integer> node1 = new NodeWithParents<>(1);
		final NodeWithParents<Integer> node2 = new NodeWithParents<>(2);
		final NodeWithParents<Integer> middle = new NodeWithParents<>(3);
		node1.addChild(middle);
		node2.addChild(middle);
		middle.addChild(node1);
		middle.addChild(node2);
		assertTrue(RouteBetweenNodes_Bidirectional.isRouteBetweenNodes(node1, node2));
	}

	@Test
	public void connectedByOneNodeUnidirectional() {
		final NodeWithParents<Integer> node1 = new NodeWithParents<>(1);
		final NodeWithParents<Integer> node2 = new NodeWithParents<>(2);
		final NodeWithParents<Integer> middle = new NodeWithParents<>(3);
		node1.addChild(middle);
		middle.addChild(node2);
		assertTrue(RouteBetweenNodes_Bidirectional.isRouteBetweenNodes(node1, node2));
	}		

	@Test
	public void connectedByOneNodeUnidirectionalOtherWay() {
		final NodeWithParents<Integer> node1 = new NodeWithParents<>(1);
		final NodeWithParents<Integer> node2 = new NodeWithParents<>(2);
		final NodeWithParents<Integer> middle = new NodeWithParents<>(3);
		node2.addChild(middle);
		middle.addChild(node1);
		assertFalse(RouteBetweenNodes_Bidirectional.isRouteBetweenNodes(node1, node2));
	}
	
	@Test
	public void connectedToMiddleNodeOnly() {
		final NodeWithParents<Integer> node1 = new NodeWithParents<>(1);
		final NodeWithParents<Integer> node2 = new NodeWithParents<>(2);
		final NodeWithParents<Integer> middle = new NodeWithParents<>(3);
		node1.addChild(middle);
		node2.addChild(middle);
		assertFalse(RouteBetweenNodes_Bidirectional.isRouteBetweenNodes(node1, node2));
	}

	@Test
	public void moreComplicated() {
		final NodeWithParents<Character> a = new NodeWithParents<>('A');
		final NodeWithParents<Character> b = new NodeWithParents<>('B');
		final NodeWithParents<Character> c = new NodeWithParents<>('C');
		final NodeWithParents<Character> d = new NodeWithParents<>('D');
		final NodeWithParents<Character> e = new NodeWithParents<>('E');
		final NodeWithParents<Character> f = new NodeWithParents<>('F');
		final NodeWithParents<Character> g = new NodeWithParents<>('G');
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
		assertFalse(RouteBetweenNodes_Bidirectional.isRouteBetweenNodes(a, f));
	}
	
	@Test
	public void moreComplicated2() {
		final NodeWithParents<Character> a = new NodeWithParents<>('A');
		final NodeWithParents<Character> b = new NodeWithParents<>('B');
		final NodeWithParents<Character> c = new NodeWithParents<>('C');
		final NodeWithParents<Character> d = new NodeWithParents<>('D');
		final NodeWithParents<Character> e = new NodeWithParents<>('E');
		final NodeWithParents<Character> f = new NodeWithParents<>('F');
		final NodeWithParents<Character> g = new NodeWithParents<>('G');
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
		assertTrue(RouteBetweenNodes_Bidirectional.isRouteBetweenNodes(g, b));
	}
	
}
