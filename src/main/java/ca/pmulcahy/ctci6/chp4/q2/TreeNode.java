package ca.pmulcahy.ctci6.chp4.q2;

public class TreeNode<T> {
	T data;
	TreeNode<T> left;
	TreeNode<T> right;

	public TreeNode(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}
	
	public TreeNode getLeft() {
		return left;
	}
	
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public TreeNode getRight() {
		return right;
	}
	
	@Override
	public String toString() {
		return left + " " + data + " " + right;
	}
}