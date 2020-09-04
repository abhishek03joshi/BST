package binarySearchTree;

import node.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

    BinaryNode root;

    public BinaryNode getRoot() { return root; }

    //Initialize
    BST() { root= null; }

    //Insertion in a node
    BinaryNode insert(BinaryNode currentNode, int value){
        if(currentNode == null){
            //Root node is blank and insert a new node at root
            return createNode(value);
        } else if ( value <= currentNode.getValue()) {
            currentNode.setLeft(insert(currentNode.getLeft(),value));
            return currentNode;
        } else {
            currentNode.setRight(insert(currentNode.getRight(),value));
            return currentNode;
        }
    }

    //Using the above function with with root always. Create a wrapper
    void insert(int value) { root = insert(root, value); }

    //Create new node
    public BinaryNode createNode(int value){
        BinaryNode node = new BinaryNode();
        node.setValue(value);
        return node;
    }

    public BinaryNode deleteNodeBST(BinaryNode root, int value){
        if(root == null){
            //This signifies that the node is not found
            System.out.println("Node is not found");
            return null;
        }

        if ( value < root.getValue()){
            root.setLeft(deleteNodeBST(root.getLeft(), value));

        } else if ( value > root.getValue()) {
            root.setRight(deleteNodeBST(root.getRight(), value));
        } else if ( value == root.getValue() ) {
            // We are in the node to be deleted
            //Check how many children the node has.

            //Node has both left and right children
            if (root.getLeft() != null && root.getRight() != null) {
                BinaryNode temp = root;
                BinaryNode minimumLeftNode = minimumElement(temp.getRight()); // Find minimum element from the right side
                root.setValue(minimumLeftNode.getValue());// Replace the current node value with the value from the minimum node in right subtree.
                /*Delete the minimum node from the right. The setting of the right side will set it to the same right pointer node due to the nature of recursion works.
                So that is a no operation statement.
                */
                root.setRight(deleteNodeBST(root.getRight(), minimumLeftNode.getValue()));

            } else if (root.getLeft() != null) {
                //Set current node reference to the left child node reference, its like linking parent to the left child node directly.
                root = root.getLeft();

            } else if (root.getRight() != null) {
                //Set current node reference to the right child node reference, its like linking parent to the right child node directly.
                root = root.getRight();

            } else {
                root = null;
            }

        }
        return root;
    }

    //Delete Tree entire
    public void deleteTree() {
        root = null;
        System.out.println("Tree deleted successfully...");
    }

    //Logic of get minimum element remains the same
    public static BinaryNode minimumElement(BinaryNode root){
        if(root.getLeft() == null){
            //This means that current element itself is minimum and should be returned
            return root;
        } else {
            //Call the function on the left element
            return minimumElement(root.getLeft());
        }
    }

    //Wrapper function to delete
    public void deleteNodeBST(int value){
        System.out.println("\n\nDeleting the value " + value + " from BST \n");
        deleteNodeBST(root, value);
    }

    //Search Wrapper function with node == root.
    public void searchForNode(int value){
        searchForNode(root, value);
    }

    //Search function
    BinaryNode searchForNode (BinaryNode node, int value) {
        if(node == null) {
            System.out.println("Value: " + value + " is not found in the BST.");
            return null;
        } else if (value < node.getValue()) {
            return searchForNode(node.getLeft(), value);
        } else if (value > node.getValue()) {
            return searchForNode(node.getRight(), value);
        } else {
            // The value matches
            System.out.println("Value: " + value + " is found in the BST!!");
            return node;
        }
    }

    //In Order Traversal
    public void inOrderTraversal(BinaryNode root) {
        if (root == null){
            //System.out.println("Empty BST!");
            return ;
        }
        else {
            inOrderTraversal(root.getLeft());
            System.out.println("Value is: " + root.getValue());
            inOrderTraversal(root.getRight());
        }
    }

    //Pre Order Traversal
    public void preOrderTraversal(BinaryNode root){
        if (root == null){
            //System.out.println("Empty BST");
            return ;
        }
        else {
            System.out.println("Value is: "+ root.getValue());
            preOrderTraversal(root.getLeft());
            preOrderTraversal(root.getRight());
        }
    }

    //Post Order Traversal
    public void postOrderTraversal(BinaryNode root) {
        if (root == null) {
            //System.out.println("Empty BST");
            return;
        } else {
            postOrderTraversal(root.getLeft());
            postOrderTraversal(root.getRight());
            System.out.println("Value is: " + root.getValue());
        }
    }

    //LevelOrderTraversal
    public void levelOrderTraversal() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        if ( root == null) {
            System.out.println("Tree does not exist");
            return;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode presentNode;
            presentNode = queue.remove();
            System.out.println("Value is :" + presentNode.getValue());
            if(presentNode.getLeft() != null) {
                queue.add(presentNode.getLeft());
            }
            if(presentNode.getRight() != null) {
                queue.add(presentNode.getRight());
            }
        }

    }


}
