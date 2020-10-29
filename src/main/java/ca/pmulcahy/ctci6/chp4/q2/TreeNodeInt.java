package ca.pmulcahy.ctci6.chp4.q2;

public class TreeNodeInt {
	private int data;
	private TreeNodeInt left;
	private TreeNodeInt right;
	public TreeNodeInt(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}

	public void setLeft(TreeNodeInt left) {
		this.left = left;
	}
	
	public TreeNodeInt getLeft() {
		return left;
	}
	
	public void setRight(TreeNodeInt right) {
		this.right = right;
	}
	
	public TreeNodeInt getRight() {
		return right;
	}
	
	@Override
	public String toString() {
		return left + " " + data + " " + right;
	}
}