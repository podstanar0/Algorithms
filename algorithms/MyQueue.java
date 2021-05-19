package algorithms;

 // TASK: implement queue using two stacks

public class MyQueue
{
    Stack stackNew, stackOld;

    public MyQueue()
    {
        stackNew = new Stack();
        stackOld = new Stack();
    }

    public int size()
    {
        return stackNew.size() + stackOld.size();
    }

    public void add(int item)
    {
        // push onto stackNew, which always holds the newest element on top
        stackNew.push(item);
    }

    // move elements from stackNew into stackOld.
    private void shiftStacks() 
    {
        if (stackOld.isEmpty())
        {
            while (!stackNew.isEmpty()) stackOld.push(stackNew.pop());
        }
    }

    public int peek()
    {
        shiftStacks(); // ensures that stackOld has current elements
        return stackOld.peek(); // retrieve the oldest item
    }

    public int remove()
    {
        shiftStacks(); // ensures that stackOld has current elements
        return stackOld.pop(); // pop the oldest item
    }
}
