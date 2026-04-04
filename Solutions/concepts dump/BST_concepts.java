import java.util.ArrayList;

public class BST_concepts {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val){  // Insert a new value into the BST
        if(root == null){
            return new Node(val);
        }
        if(root.data<val){
            root.right = insert(root.right,val);
        }else{
            root.left = insert(root.left,val);
        }
        return root;
    }

    public static boolean search(Node root, int key){  // Search for a value in the BST
        if(root==null){
            return false;
        }
        if(root.data>key){
            return search(root.left,key);
        }
        else if(root.data==key){
            return true;
        }
        else{
            return search(root.right,key);
        }
    }

    private static Node inorderSuccessor(Node root) {
        Node current = root;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }

    public static Node delete(Node root, int key){  // Delete a value from the BST
        if(root==null){
            return null;
        }
        if(root.data>key){
            root.left = delete(root.left,key);
        }
        else if(root.data<key){
            root.right=delete(root.right,key);
        }else{
            // Node to be deleted found
            if(root.left==null && root.right==null){
                return null;
            }
            else if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }else{
                // Node with two children
                Node successor = inorderSuccessor(root.right);
                root.data = successor.data;
                root.right = delete(root.right, successor.data);
                return root;
            }
        }
        return root;

    }

    public static void printInRange(Node root, int k1, int k2){ // Print values in a given range
        if(root == null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            printInRange(root.left,k1,k2);
            System.out.print(root.data + " ");
            printInRange(root.right,k1,k2);
        }else if(root.data<k1){
            printInRange(root.right,k1,k2);
        }else{
            printInRange(root.left,k1,k2);
        }
    }

    public static void printToLeaf(Node root,ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);

        if(root.left==null && root.right==null){ // leaf node
            System.out.println(path);
        }
        else{ // non leaf node
            printToLeaf(root.left,path);
            printToLeaf(root.right,path);
        }
        path.remove(path.size() - 1);
    }

    public static void inorder(Node root){ // Inorder traversal of the BST
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args){
        int[] values = {5, 3, 7, 2, 4, 6, 8};
        Node root = null;
        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }
        inorder(root);  // print the BST in sorted order
        System.out.println();

        if(search(root,9)){ // Searching for a value that is not in the BST
            System.out.println("Found");
        }else{
            System.out.println("Not Found");
        }
        
        System.out.println("After Deletion:");
        root = delete(root, 3); // Deleting a node with two children
        inorder(root);  // print the BST in sorted order after deletion
        System.out.println();

        System.out.println("Values in range [4, 7]:");
        printInRange(root, 4, 7); // Print values in the range [4, 7]
        System.out.println();   

        System.out.println("Paths from root to leaf:");
        printToLeaf(root, new ArrayList<>()); // Print all paths from root to leaf
    }

}