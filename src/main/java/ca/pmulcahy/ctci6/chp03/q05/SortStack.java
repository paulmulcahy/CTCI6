package ca.pmulcahy.ctci6.chp03.q05;

import java.util.EmptyStackException;
/*
 * Write a program to sort a stack such that the smallest items are on the top. You can use an additional temporary stack, but you may not copy the elements into any other data structure (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.
 */
public class SortStack<T extends Comparable<T>> {

	private T[] internalArray;
	private int stackSize;
	
	public SortStack() {
		this(1);
	}
	
	@SuppressWarnings("unchecked")
	public SortStack(int initialArraySize){
		if(initialArraySize<=0) {
			initialArraySize=1;
		}
		internalArray = (T[])new Comparable[initialArraySize];
		stackSize=0;
	}
	
	@SuppressWarnings("unchecked")
	private void increaseArraySize() {
		final int largerInternalArraySize = internalArray.length * 2;
		final T[] largerInternalArray = (T[])new Comparable[largerInternalArraySize];
		for(int i=0; i<internalArray.length; i++) {
			largerInternalArray[i] = internalArray[i];
		}
		internalArray = largerInternalArray;
	}
	
	public void push(final T item) {
		if(stackSize == internalArray.length) {
			increaseArraySize();
		}
		internalArray[stackSize++] = item;
	}
	
	public T peek() {
		if(stackSize == 0) {
			throw new EmptyStackException();
		}
		final T item = internalArray[stackSize-1];
		return item;
	}
	
	public T pop() {
		final T item = peek();
		stackSize--;
		return item;
	}
	
	public boolean isEmpty() {
		return stackSize == 0;
	}
	
	public void sort() {
		final SortStack<T> reverseStack = new SortStack<>(this.stackSize);
		while(!this.isEmpty()) {
			final T temp = this.pop();
			while(!reverseStack.isEmpty() && reverseStack.peek().compareTo(temp)<0) {
				this.push((T)reverseStack.pop());	
			}
			reverseStack.push(temp);
		}
		this.internalArray = reverseStack.internalArray;
		this.stackSize = reverseStack.stackSize;
	}

}