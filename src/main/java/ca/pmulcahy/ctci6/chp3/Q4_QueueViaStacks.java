package ca.pmulcahy.ctci6.chp3;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/*
 * Implement a MyQueue (QueueViaStacks) class which implements a queue using two stacks.
 */
public class Q4_QueueViaStacks<T> {
	private class InternalStack {
		private T[] internalArray;
		private int stackSize;
		
		private InternalStack() {
			this(1);
		}
		
		@SuppressWarnings("unchecked")
		private InternalStack(int initialArraySize){
			if(initialArraySize<=0) {
				initialArraySize=1;
			}
			internalArray = (T[])new Object[initialArraySize];
			stackSize=0;
		}
		
		@SuppressWarnings("unchecked")
		private void increaseArraySize() {
			int largerInternalArraySize = internalArray.length * 2;
			T[] largerInternalArray = (T[])new Object[largerInternalArraySize];
			for(int i=0; i<internalArray.length; i++) {
				largerInternalArray[i] = internalArray[i];
			}
			internalArray = largerInternalArray;
		}
		
		private void push(T item) {
			if(stackSize == internalArray.length) {
				increaseArraySize();
			}
			internalArray[stackSize++] = item;
		}
		
		private T peek() {
			if(stackSize == 0) {
				throw new EmptyStackException();
			}
			T item = internalArray[stackSize-1];
			return item;
		}
		
		private T pop() {
			T item = peek();
			stackSize--;
			return item;
		}
		
		private boolean isEmpty() {
			return stackSize == 0;
		}
		
		private int getStackSize(){
			return stackSize;
		}
	}
	
	private InternalStack mainStack;
	
	public Q4_QueueViaStacks() {
		this(1);
	}
	
	public Q4_QueueViaStacks(int initialStackSize) {
		if(initialStackSize <= 0) {
			initialStackSize = 1;
		}
		mainStack = new InternalStack(initialStackSize);
	}
	
	public void add(T item) {
		InternalStack tempStack = new InternalStack(mainStack.getStackSize());
		while(!mainStack.isEmpty()) {
			tempStack.push(mainStack.pop());			
		}
		mainStack.push(item);
		while(!tempStack.isEmpty()) {
			mainStack.push(tempStack.pop());
		}
	}
	
	public T remove() {
		if(mainStack.isEmpty()) {
			throw new NoSuchElementException();
		}
		T item = (T)mainStack.pop();
		return item;
	}
	
	public T peek() {
		if(mainStack.isEmpty()) {
			throw new NoSuchElementException();
		}
		T item = (T)mainStack.peek();
		return item;
	}
	
	public boolean isEmpty() {
		return mainStack.isEmpty();
	}

}