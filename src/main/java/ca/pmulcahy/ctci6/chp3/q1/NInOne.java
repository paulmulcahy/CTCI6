package ca.pmulcahy.ctci6.chp3.q1;

import java.util.EmptyStackException;

/*
 * Describe how you could use a single array to implement N stacks
 */
public class NInOne<T> {
	static final private String ILLEGAL_STACK_SELECTION = "Stack selection must be between 0 and one less than the number of stacks";
	static final private String ILLEGAL_NUM_STACKS = "Number of stacks must be greater than zero";
	
	private T[] internalArray;
	private int stackMaxSize;
	private int numStacks;
	private int[] stackSize;
	
	public NInOne(final int numStacks) {
		this(numStacks, numStacks);
	}
	
	@SuppressWarnings("unchecked")
	public NInOne(final int numStacks, int startingArraySize) {
		if(numStacks<1) {
			throw new IllegalArgumentException(ILLEGAL_NUM_STACKS);
		}
		this.numStacks = numStacks;
		if(startingArraySize<numStacks) {
			startingArraySize = numStacks;
		}
		this.stackMaxSize = startingArraySize/numStacks;
		this.internalArray = (T[])new Object[stackMaxSize*numStacks];
		stackSize = new int[numStacks];
		for(int i=0; i<stackSize.length; i++) {
			stackSize[i] = 0;
		}
	}

	@SuppressWarnings("unchecked")
	private void increaseArraySize() {
		final int largerStackMaxSize = stackMaxSize * 2;
		final T[] largerInternalArray = (T[])new Object[largerStackMaxSize*numStacks];
		for(int i=0; i<numStacks; i++) {
			for(int j=0; j<stackSize[i]; j++) {
				largerInternalArray[i*largerStackMaxSize+j] = internalArray[i*stackMaxSize+j];
			}
		}
		stackMaxSize = largerStackMaxSize;
		internalArray = largerInternalArray;
	}
	
	public void push(final int stackNum, final T t) {
		validateStackSelection(stackNum);
		if(stackSize[stackNum] == stackMaxSize) {
			increaseArraySize();
		}
		internalArray[stackMaxSize*stackNum+stackSize[stackNum]] = t;
		stackSize[stackNum]++;
	}
	
	public T peek(final int stackNum) {
		validateStackSelection(stackNum);
		if(stackSize[stackNum] == 0) {
			throw new EmptyStackException();
		}
		final T item = internalArray[stackMaxSize*stackNum+stackSize[stackNum] - 1];
		return item;
	}
	
	public T pop(final int stackNum) {
		final T item = peek(stackNum);
		stackSize[stackNum]--;
		return item;
	}
	
	public boolean isEmpty(final int stackNum) {
		validateStackSelection(stackNum);
		return stackSize[stackNum] == 0;
	}
	
	private void validateStackSelection(final int stackNum) {
		if(stackNum < 0 || stackNum >= numStacks) {
			throw new IllegalArgumentException(ILLEGAL_STACK_SELECTION);			
		}		
	}
}