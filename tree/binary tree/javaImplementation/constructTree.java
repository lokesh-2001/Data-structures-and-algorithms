package javaImplementation;
// construct tree from given inorder and preorder traversals
// Maintain two data structures: Stack (to store the path we visited while 
// traversing PreOrder array) and Set (to maintain the node in which the next right subtree is expected).

import java.util.HashSet;

// 1. Do below until you reach the leftmost node. 
// Keep creating the nodes from the PreOrder traversal 
// If the stack’s topmost element is not in the set, link the created node to the
//  left child of the stack’s topmost element (if any), without popping the element. 
// Else link the created node to the right child of the stack’s topmost element.
//  Remove the stack’s topmost element from the set and the stack. 
// Push the node to a stack.
// 2. Keep popping the nodes from the stack until either the 
// stack is empty, or the topmost element of the stack compares to 
// the current element of InOrder traversal. Once the loop is over, 
// push the last node back into the stack and into the set.
import java.util.*;
public class constructTree {
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }
    static HashSet<Node> set = new HashSet<>();
    static Stack<Node> st = new Stack<Node>();

    static Node build(int[] preorder, int[]inorder){
        Node root = null;
        for(int pre = 0,in=0;pre<preorder.length;){
            Node node = null;
            do{
                node = new Node(preorder[pre]);
                if(root==null)
                    root=node;
                if(!st.empty()){
                    if(set.contains(st.peek())){
                        set.remove(st.peek());
                        st.pop().right = node;
                    }
                    else{
                        st.peek().left = node;
                    }
                }
                st.push(node);
            }while(preorder[pre++]!=inorder[in] && pre< preorder.length);
            node = null;
            while(!st.empty() && in<inorder.length
            && st.peek().data == inorder[in]){
                node = st.pop();
                in++;
            }
            if(node!=null){
                set.add(node);
                st.push(node);
            }
        }
        return root;
    }
    static void inorder(Node node){
        if(node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
    public static void main(String[] args) {
        int in[] = new int[] { 9, 8, 4, 2, 10, 5, 10, 1, 6, 3, 13, 12, 7 };
        int pre[] = new int[] { 1, 2, 4, 8, 9, 5, 10, 10, 3, 6, 7, 12, 13 };
        Node root = build(pre, in);
        inorder(root);
    }
}
