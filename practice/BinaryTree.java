package algorithms;

import java.util.Scanner;


public class BinaryTree
{
    public class Node
    {
        private Node left, right;
        private int data;

        // main constructor
        public Node(Node left, int data, Node right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }
        // constructor for leafs
        public Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
        
        public Node getLeft()
        {
            return left;
        }

        public Node getRight()
        {
            return right;
        }

        public int getData()
        {
            return data;
        }

        public void setLeft(Node left)
        {
            this.left = left;
        }

        public void setRight(Node right)
        {
            this.right = right;
        }
        
        public void setData(int data)
        {
            this.data = data;
        }
    }

    public Node root;

    public BinaryTree()
    {
        root = null;
    }
    
    public boolean isEmpty()
    {
        return root == null;
    }

    // adds new Node
    public void addNode(int data)
    {
        Node newNode = new Node(data);
    }

    // adds new Node to the left branch
    public void addLeft(Node root, int data)
    {
        Node newNode = new Node(data);
        root.setLeft(newNode);
    }

    // adds new Node to the right branch
    public void addRight (Node root, int data)
    {
        Node newNode = new Node(data);
        root.setRight(newNode);
    }

    // inserts data
    public void insert(int data)
    {
        root = insert(root, data);
    }

    // inserts data recursively
    public Node insert(Node node, int data)
    {
        if (node == null) // base case
            node = new Node(data);
        else
        {
            if (node.getRight() == null)
                node.right = insert(node.right, data);
            else
                node.left = insert(node.left, data);
        }
        return node;
    }

    // counts number of nodes
    public int countNodes()
    {
        return countNodes(root);
    }
    
    // counts number of nodes recursively
    private int countNodes(Node node)
    {
        if (node == null)
            return 0;
            
        int n = 1;
        n += countNodes(node.getLeft());
        n += countNodes(node.getRight());
        return n;
    }
    
    // searches tree for an element
    public boolean search(int item)
    {
        return search(root, item);
    }
    
    // searches tree for an element recursively
    private boolean search(Node node, int item)
    {
        if (node.getData() == item)
            return true;
        if (node.getLeft() != null)
            if (search(node.getLeft(), item))
                return true;
        if (node.getRight() != null)
            if (search(node.getRight(), item))
                return true;
        return false;
    }

    // inorder traversal of tree
    public void inorder()
    {
        inorder(root);
    }
    
    // inorder traversal recursively
    private void inorder(Node node)
    {
        if (node != null)
        {
            inorder(node.getLeft());
            System.out.print(node.getData() + " ");
            inorder(node.getRight());
        }
    }
    
    // preorder traversal of tree
    public void preorder()
    {
        preorder(root);
    }

    // preorder traversal recursively
    private void preorder(Node node)
    {
        if (node != null)
        {
            System.out.print(node.getData() + " ");
            preorder(node.getLeft());
            preorder(node.getRight());
        }
    }
    // postorder traversal of tree
    public void postorder()
    {
        postorder(root);
    }

    // postorder traversal recursively
    private void postorder(Node node)
    {
        if (node != null)
        {
            postorder(node.getLeft());
            postorder(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    /*
    // 1. inserts the middle element of the array into the tree
    // 2. inserts the left subarray elements into the left subtree
    // 3. inserts the right subarray elements into the right subtree
    // 4. Recurse
    */
    public Node createMinimalBST(int[] arr)
    {
        return createMinimalBST(arr, 0, arr.length - 1);
    }

    public Node createMinimalBST(int arr[] , int start, int end)
    {
        if (end < start)
        {
            return null;
        }
        
        int middle = (start + end) / 2;
        Node node = new Node(arr[middle]);
        node.left = createMinimalBST(arr, start, middle - 1);
        node.right = createMinimalBST(arr, middle + 1, end);

        return node;
    }
}
