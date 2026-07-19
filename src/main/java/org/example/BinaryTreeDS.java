package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeDS {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree{
        static int idx = -1;

        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    // InOrder
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    // PostOrder
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    // PreOrder
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // level order
    public static  void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node>q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else {
                    q.add(null);
                }
            }else {
                System.out.print(curr.data+" ");
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
    }
    // Count of nodes
    public static int countOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftNode = countOfNodes(root.left);
        int rightNode = countOfNodes(root.right);
        return leftNode+rightNode+1;
    }
    // Sum of nodes
    public static int sumOfNode(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = sumOfNode(root.left);
        int rightSum = sumOfNode(root.right);
        return leftSum+rightSum+root.data;
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
       /*
        System.out.println(root.data);
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        levelOrder(root);
        System.out.println();
        System.out.println(countOfNodes(root));
        System.out.println(sumOfNode(root));

        */
    }
}
