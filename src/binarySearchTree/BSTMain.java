package binarySearchTree;

public class BSTMain {
    public static void main(String[] args) {

        BST tree = new BST();

        //Inserting nodes in tree
        System.out.println("Inserting nodes in tree");
        tree.insert(100);
        tree.insert(120);
        tree.insert(10);
        tree.insert(90);
        tree.insert(80);
        tree.insert(40);


        //Search for value in tree
        System.out.println("Searching for value in BST");
        tree.searchForNode(90);

        //Searching for value that does not exist
        tree.searchForNode(990);

        //Traversal of tree

        System.out.println("\n\n Pre order Traversal of BST");
        tree.preOrderTraversal(tree.getRoot());
        System.out.println("\n\n Post order Traversal of BST");
        tree.postOrderTraversal(tree.getRoot());
        System.out.println("\n\n Level order Traversal of BST");
        tree.levelOrderTraversal();
        System.out.println("\n\n In order Traversal of BST");
        tree.inOrderTraversal(tree.getRoot());


        //Deleting node from a tree
        tree.deleteNodeBST(880); // Deleting value that does not exist
        System.out.println("\n\n In order Traversal of BST after deletion of 880");
        tree.levelOrderTraversal();

        tree.deleteNodeBST(40); //Node has 0 children
        System.out.println("\n\n In order Traversal of BST after deletion of 880");
        tree.levelOrderTraversal();

        tree.deleteNodeBST(80); //Node has ! child
        System.out.println("\n\n In order Traversal of BST after deletion of 880");
        tree.levelOrderTraversal();

        tree.deleteNodeBST(100); // Node has 2 children
        System.out.println("\n\n In order Traversal of BST after deletion of 880");
        tree.levelOrderTraversal();
    }
}
