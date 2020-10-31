package ca.pmulcahy.ctci6.chp4;

public class TreeNode<T extends Comparable<T>> {
	T data;
	TreeNode<T> left;
	TreeNode<T> right;

	public TreeNode(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}
	
	public TreeNode<T> getLeft() {
		return left;
	}
	
	public void setRight(TreeNode<T> right) {
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