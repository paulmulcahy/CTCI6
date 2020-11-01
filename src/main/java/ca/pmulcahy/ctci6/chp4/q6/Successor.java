package ca.pmulcahy.ctci6.chp4.q6;

/*
 * Write an algorithm to find the "next" node (ie in-order successor) of a given node in a binary search tree. You may assume that each node has a link to its parent.
 */
public class Successor {
	public static <T extends Comparable<T>> TreeNodeParentLinked<T> getSuccessor(TreeNodeParentLinked<T> treeNode) {		
		if(treeNode!=null) {
			if (treeNode.getRight()!= null) {
				treeNode = treeNode.getRight();
				while(treeNode.getLeft()!=null) {
					treeNode = treeNode.getLeft();
				}
				return treeNode;
			} else if(treeNode.getParent()!= null) {
				TreeNodeParentLinked<T> parentNode = treeNode.getParent();
				while(parentNode!=null && !treeNode.equals(parentNode.getLeft())) {
					treeNode = parentNode;
					parentNode = parentNode.getParent();
				}
				return parentNode;
			}
		}
		return null;
	}
}
