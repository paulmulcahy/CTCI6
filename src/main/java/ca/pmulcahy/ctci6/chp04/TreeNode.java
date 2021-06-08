package ca.pmulcahy.ctci6.chp04;

import java.util.List;

public class TreeNode<T extends Comparable<T>> {
	private T data;
	private TreeNode<T> left;
	private TreeNode<T> right;

	public TreeNode(final T data) {
		this.data = data;
	}
	
	public TreeNode(final List<T> dataList) {
		if(dataList != null && !dataList.isEmpty()) {	
			this.data = dataList.get(0);
			for(int i=1; i<dataList.size(); i++) {
				insertInOrder(dataList.get(i));
			}
		}
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
	
	private void insertInOrder(final T data) {
		if(data.compareTo(this.data)<=0) {
			if(left == null) {
				setLeft(new TreeNode<T>(data));
			} else {
				left.insertInOrder(data);
			}
		} else {
			if(right == null) {
				setRight(new TreeNode<T>(data));
			} else {
				right.insertInOrder(data);
			}
		}
	}
	
	@Override
	public String toString() {
		return left + " " + data + " " + right;
	}
}