package labreport.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class binarysearchtree {
    class node {
        node left;
        node right;
        int val;
        public node(int val) {
            this.val = val;
        }
    }
    node root;
    public void insert(int val) {
        root = inserter(root, val);
    }
    private node inserter(node root, int val) {
        if (root == null) {
            return new node(val);
        }
        if (root.val > val) {
            root.left = inserter(root.left, val);
        } else {
            root.right = inserter(root.right, val);
        }
        return root;
    }
    public node search(int val) {
        return searcher(val, root);
    }
    private node searcher(int val, node root) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searcher(val, root.left);
        } else {
            return searcher(val, root.right);
        }
    }
    public void delete(int val) {
        root = deleter(val, root);
    }
    private node deleter(int val, node root) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            // Case 1: No child or one child
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // Case 2: Two children
            node temp = next(root.right);
            root.val = temp.val;
            root.right = deleter(temp.val, root.right);
        } else if (root.val > val) {
            root.left = deleter(val, root.left);
        } else {
            root.right = deleter(val, root.right);
        }
        return root;
    }
    private node next(node root) {
        node temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }
    public void inOrderTraversal(node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.val + " ");
            inOrderTraversal(root.right);
        }
    }
    public static void main(String[] args) {
        binarysearchtree t = new binarysearchtree();
        System.out.println("Inserting elements...");
        t.insert(4);
        t.insert(3);
        t.insert(6);
        t.insert(7);
        t.insert(5);
        System.out.println("Tree after insertion (in-order):");
        t.inOrderTraversal(t.root);
        System.out.println();
        System.out.println("Searching for element 5:");
        System.out.println(t.search(5) != null ? "Found" : "Not Found");
        System.out.println("Searching for element 10:");
        System.out.println(t.search(10) != null ? "Found" : "Not Found");
        System.out.println("Deleting element 6...");
        t.delete(6);
        System.out.println("Tree after deletion of 6 (in-order):");
        t.inOrderTraversal(t.root);
        System.out.println();
        System.out.println("Deleting element 4...");
        t.delete(4);
        System.out.println("Tree after deletion of 4 (in-order):");
        t.inOrderTraversal(t.root);
        System.out.println();
    }
}

