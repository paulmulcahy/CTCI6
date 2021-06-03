package ca.pmulcahy.ctci6.chp4.q6;

public class TreeNodeParentLinked<T extends Comparable<T>> {
	private T data;
	private TreeNodeParentLinked<T> left;
	private TreeNodeParentLinked<T> right;
	private TreeNodeParentLinked<T> parent;

	public TreeNodeParentLinked(final T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}

	public void setLeft(final TreeNodeParentLinked<T> left) {
		this.left = left;
		left.parent = this;
	}
	
	public TreeNodeParentLinked<T> getLeft() {
		return left;
	}
	
	public void setRight(final TreeNodeParentLinked<T> right) {
		this.right = right;
		right.parent = this;
	}
	
	public TreeNodeParentLinked<T> getRight() {
		return right;
	}
	
	public TreeNodeParentLinked<T> getParent() {
		return parent;
	}
	
	@Override
	public String toString() {
		return left + " " + data + " " + right;
	}
}