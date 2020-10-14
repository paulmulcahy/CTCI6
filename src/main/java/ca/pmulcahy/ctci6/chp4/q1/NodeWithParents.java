package ca.pmulcahy.ctci6.chp4.q1;

import java.util.HashSet;
import java.util.Set;

public class NodeWithParents<T> {
	private T data;
	private Set<NodeWithParents> children;
	private Set<NodeWithParents> parents;
	public NodeWithParents(T data) {
		this.data = data;
		this.children = new HashSet<NodeWithParents>();
		this.parents = new HashSet<NodeWithParents>();
	}
	
	public T getData() {
		return data;
	}
	
	public Set<NodeWithParents> getChildren() {
		return children;
	}
	
	public Set<NodeWithParents> getParents() {
		return parents;
	}
	
	public void addChild(NodeWithParents child) {
		children.add(child);
		child.parents.add(this);
	}
}