package tree;

public class TreeTest {
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

    public static int height(Node root){  
        if(root==null){
            return 0; 
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Level order traversal

    public static void main(String[] args) {
        Node root = null;

}   

}