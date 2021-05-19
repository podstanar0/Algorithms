package algorithms;

import java.util.HashSet;


public class LinkedList
{
    public class Node 
    {
        public Node next, prev;
        public char character;

        // constructor
        public Node(Node prev, Node next, char charX) 
        {
            this.character = charX;
            this.next = node;
            this.prev = prev;
        }
    }

    public int size;
    public Node head, tail, first, current, removed;
    public char x;

    // constructor
    public LinkedList()
    {
        size = 1;
        x = 'c';
        first = new Node(null, x, null);
        this.head = first;
        this.tail = first;
        this.current = first;
    }
    
    // adds a Node to LinkedList
    public void add(char item)
    {
        Node newTail = new Node(tail, item, null);
        tail.next = newtail;
        tail = newTail;
        size++;
    }

    // removes current Node from LinkedList (TODO: this is stupid, refine logic)
    public void remove (Node node)
    {
        currentNode = node;
        currentNode.next.prev = currentNode.prev;
        currentNode.prev.next = currentNodede.next;
    }

    // prints whole list
    public void printList()
    {
        Node firstChar = head;
        while (firstChar != null)
        {
            System.out.print(firstChar.character + " ");
            firstChar = firstChar.next;
        }
    }

    // ALGO: removes duplicates from an unsorted linked list
    public void removeDupes()
    {
        // iterate through list
        Node firstChar = head;
        HashSet<Character> set = new HashSet <Character>();
        while (firstChar != null)
        {
            // if char is in the Hashset, delete it
            if (set.contains(firstChar.character)) remove(firstChar);
            
            else set.add(firstChar.character);
            
            firstChar = firstChar.next;
        }
    }

    // ALGO: recursively finds the nth to last element in a single linked list
    public int nthToLast(Node head, int n)
    {
        // base case
        if (head == null) return 0;

        int index = nthToLast(head.next, n) + 1;
        if (index == n)
           System.out.println(n + "th to last Node is: " + head.character);

        return index;
    }

    // ALGO: find the middle of a single linked list
    public Character findMiddle()
    {
        // start at the head
        Node n1 = head;
        Node n2 = head;

        while (n1 != null)
        {
            System.out.println(n1.character);
            n1 = n1.next;
            n1 = n1.next;
            n2 = n1.next;
        }

        return n2.character;
    }

    // ALGO: delete the middle of a single LL given the middle Node
    public Boolean delMiddle(Node middle)
    {
        // make sure node exists and points to something
        if (middle == null || middle.next == null)
            return false;

        Node next = middle.next;
        middle.character = next.character;
        middle.next = next.next;
        return true;
    }
}
