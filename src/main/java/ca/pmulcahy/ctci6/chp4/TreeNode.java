package ca.pmulcahy.ctci6.chp4;

public class TreeNode<T extends Comparable<T>> {
	private T data;
	private TreeNode<T> left;
	private TreeNode<T> right;

	public TreeNode(final T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}

	public void setLeft(final TreeNode<T> left) {
		this.left = left;
	}
	
	public TreeNode<T> getLeft() {
		return left;
	}
	
	public void setRight(final TreeNode<T> right) {
		this.right = right;
	}
	
	public TreeNode<T> getRight() {
		return right;
	}
	
	@Override
	public String toString() {
		return left + " " + data + " " + right;
	}
}