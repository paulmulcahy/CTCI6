package ca.pmulcahy.ctci6.chp3;

import java.util.EmptyStackException;

/*
 * How would you design a stack which, in addition to push and pop has a function min which returns the minimum element? Push, pop and min all operate in O(1) time.
 */
public class Q2_StackMin<T extends Comparable<T>> {
	private T[] internalArray;
	private T[] minArray;
	private int stackSize;

	public Q2_StackMin() {
		this(1);
	}
	
	@SuppressWarnings("unchecked")
	public Q2_StackMin(int startingArraySize) {
		if(startingArraySize<0) {
			startingArraySize = 1;
		}
		this.internalArray = (T[])new Comparable[startingArraySize];
		this.minArray = (T[])new Comparable[startingArraySize];
		stackSize = 0;
	}

	@SuppressWarnings("unchecked")
	private void increaseArraySize() {
		T[] largerInternalArray = (T[])new Comparable[internalArray.length*2];
		T[] largerMinArray = (T[])new Comparable[internalArray.length*2];
		for(int i=0; i<internalArray.length; i++) {
				largerInternalArray[i] = internalArray[i];
				largerMinArray[i] = minArray[i];
		}
		internalArray = largerInternalArray;
		minArray = largerMinArray;
	}

	public T peek() {
		if (stackSize == 0) {
			throw new EmptyStackException();
		}
		T item = internalArray[stackSize-1];
		return item;
	}
	
	public T pop() {
		T item = peek();
		stackSize--;
		return item;
	}
	
	public void push(T item) {
		if(stackSize == internalArray.length) {
			increaseArraySize();
		}
		if(stackSize==0 || item.compareTo(minArray[stackSize-1])<0) {
			minArray[stackSize] = item;
		}
		internalArray[stackSize++] = item;
	}
	
	public boolean isEmpty() {
		return stackSize == 0;
	}
	
	public T min() {	
		if (stackSize == 0) {
			throw new EmptyStackException();
		}	
		T item = minArray[stackSize-1];
		return item;
	}
}