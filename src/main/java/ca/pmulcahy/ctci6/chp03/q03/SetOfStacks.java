package ca.pmulcahy.ctci6.chp03.q03;

import java.util.EmptyStackException;

/*
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
 * Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is, pop() should return the same values as it would if there were just a single stack).
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 */
public class SetOfStacks<T> {
  private static final String ILLEGAL_STACK_SELECTION =
      "Stack selection must be between 0 and one less than the number of stacks";
  private T[][] internalArray;
  private int[] stackSizeArray;

  public SetOfStacks() {
    this(1);
  }

  public SetOfStacks(final int maxStackSize) {
    this(maxStackSize, 1);
  }

  @SuppressWarnings("unchecked")
  public SetOfStacks(int maxStackSize, int numStartingStacks) {
    if (maxStackSize < 0) {
      maxStackSize = 1;
    }
    if (numStartingStacks < 0) {
      numStartingStacks = 1;
    }
    internalArray = (T[][]) new Object[1][];
    stackSizeArray = new int[numStartingStacks];
    for (int i = 0; i < numStartingStacks; i++) {
      internalArray[i] = (T[]) new Object[maxStackSize];
      stackSizeArray[i] = 0;
    }
  }

  private boolean isSetOfStacksFull() {
    final int numStacks = internalArray.length;
    final int maxStackSize = internalArray[0].length;
    for (int i = 0; i < numStacks; i++) {
      if (stackSizeArray[i] != maxStackSize) {
        return false;
      }
    }
    return true;
  }

  @SuppressWarnings("unchecked")
  private void addStack() {
    final int numStacks = internalArray.length;
    final int newNumStacks = numStacks + 1;
    final int maxStackSize = internalArray[0].length;
    final T[][] oneLargerInternalArray = (T[][]) new Object[newNumStacks][];
    final int[] oneLargerStackSizeArray = new int[newNumStacks];
    for (int i = 0; i < numStacks; i++) {
      oneLargerInternalArray[i] = internalArray[i];
      oneLargerStackSizeArray[i] = stackSizeArray[i];
    }
    oneLargerInternalArray[numStacks] = (T[]) new Object[maxStackSize];

    internalArray = oneLargerInternalArray;
    stackSizeArray = oneLargerStackSizeArray;
  }

  public void push(final T item) {
    if (isSetOfStacksFull()) {
      addStack();
    }
    final int numStacks = internalArray.length;
    final int maxStackSize = internalArray[0].length;
    for (int i = 0; i < numStacks; i++) {
      if (stackSizeArray[i] != maxStackSize) {
        internalArray[i][stackSizeArray[i]] = item;
        stackSizeArray[i]++;
        break;
      }
    }
  }

  public T pop() {
    final int numStacks = internalArray.length;
    T item = null;
    for (int i = numStacks - 1; i >= 0; i--) {
      if (stackSizeArray[i] != 0) {
        item = popAt(i);
        break;
      }
    }
    if (item == null) {
      throw new EmptyStackException();
    }
    return item;
  }

  public T peek() {
    final int numStacks = internalArray.length;
    T item = null;
    for (int i = numStacks - 1; i >= 0; i--) {
      if (stackSizeArray[i] != 0) {
        item = peekAt(i);
        break;
      }
    }
    if (item == null) {
      throw new EmptyStackException();
    }
    return item;
  }

  public T popAt(final int stackNum) {
    final T item = peekAt(stackNum);
    stackSizeArray[stackNum]--;
    return item;
  }

  private void validateStackSelection(final int stackNum) {
    final int numStacks = internalArray.length;
    if (stackNum < 0 || stackNum >= numStacks) {
      throw new IllegalArgumentException(ILLEGAL_STACK_SELECTION);
    }
  }

  public T peekAt(final int stackNum) {
    T item;
    validateStackSelection(stackNum);
    int stackSize = stackSizeArray[stackNum];
    if (stackSize == 0) {
      throw new EmptyStackException();
    }
    item = internalArray[stackNum][stackSize - 1];
    return item;
  }

  public boolean isEmpty() {
    final int numStacks = internalArray.length;
    for (int i = numStacks - 1; i >= 0; i--) {
      if (stackSizeArray[i] != 0) {
        return false;
      }
    }
    return true;
  }
}
