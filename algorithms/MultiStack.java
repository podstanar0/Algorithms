package algorithms;

// Problem: use one array to implement three stacks

import java.util.Stack;
import java.util.EmptyStackException;


public class MultiStack
{
    private int numOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public multiStack(int stackSize)
    {
        stackCapacity = stackSize;
        values = new int[stackSize * numOfStacks];
        sizes = new int[numOfStacks];
    }
    
    public void push(int item, int value)
    {
        // check that we have space on stack for the next item
        if (isFull(item)) return; // TODO: throw proper exception here

        // increment stack pointer and update top of stack
        sizes[item]++;
        values[indexOfTop(item)] = value;
    }

    public int pop(int item)
    {
        if (isEmpty(item)) throw new EmptyStackException();

        int topIndex = indexOfTop(item);
        int value = values[topIndex];
        values[topIndex]= 0;
        sizes[item]--;
        return value;
    }

    // returns top item
    public int peek(int item)
    {
        return values[indexOfTop(item)];
    }

    public boolean isEmpty(int item)
    {
        return sizes[item] == 0;
    }

    public boolean isFull(int item)
    {
        return sizes[item] == stackCapacity;
    }

    // returns index of the top of the stack
    private int indexOfTop(int item)
    {
        int offset = item * stackCapacity;
        int size = sizes[item];
        return offset + size - 1;
    }
}
