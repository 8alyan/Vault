package labreport.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AVL {
    Node root;

    class Node {
        int val;
        int height;
        Node left;
        Node right;

        Node(int a) {
            this.val = a;
        }
    }

    public void add(int a) {
        this.root = insert(a, root);
    }

    public int height(Node root) {
        if (root == null) {
            return -1;
        } else {
            return root.height;
        }
    }

    private Node insert(int a, Node root) {
        if (root == null) {
            return new Node(a);
        }
        if (root.val > a) {
            root.left = insert(a, root.left);
        } else {
            root.right = insert(a, root.right);
        }
        int l = height(root.left);
        int r = height(root.right);
        root.height = Math.max(l, r) + 1;
        return balance(root);
    }

    private Node balance(Node root) {
        if (root == null) {
            return null;
        }
        if (height(root.left) - height(root.right) > 1) {
            if (height(root.left.left) > height(root.left.right)) {
                return Rightrotate(root); // Left-Left case
            } else {
                root.left = Leftrotate(root.left); // Left-Right case
                return Rightrotate(root);
            }
        } else if (height(root.right) - height(root.left) > 1) {
            if (height(root.right.left) > height(root.right.right)) {
                root.right = Rightrotate(root.right); // Right-Left case
                return Leftrotate(root);
            } else {
                return Leftrotate(root); // Right-Right case
            }
        }
        return root;
    }

    private Node Leftrotate(Node parent) {
        Node child = parent.right;
        parent.right = child.left;
        child.left = parent;
        child.height = Math.max(height(child.left), height(child.right)) + 1;
        parent.height = Math.max(height(parent.left), height(parent.right)) + 1;
        return child;
    }

    private Node Rightrotate(Node parent) {
        Node child = parent.left;
        parent.left = child.right;
        child.right = parent;
        child.height = Math.max(height(child.left), height(child.right)) + 1;
        parent.height = Math.max(height(parent.left), height(parent.right)) + 1;
        return child;
    }

    public void delete(int val) {
        root = deleted(val, root);
    }

    private Node deleted(int val, Node root) {
        if (root == null) {
            return null;
        }
        if (val > root.val) {
            root.right = deleted(val, root.right);
        } else if (val < root.val) {
            root.left = deleted(val, root.left);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            Node suc = findMin(root.right);
            root.val = suc.val;
            root.right = deleted(suc.val, root.right);
        }
        int l = height(root.left);
        int r = height(root.right);
        root.height = Math.max(l, r) + 1;
        return balance(root);
    }

    private Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // In-order Traversal for Display
    public void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.val + " ");
            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        AVL tree = new AVL();

        // Insert values into the AVL tree
        System.out.println("Inserting values...");
        tree.add(10);
        tree.add(20);
        tree.add(30);
        tree.add(40);
        tree.add(50);
        tree.add(25);

        // Display the tree (in-order traversal)
        System.out.println("Tree after insertion (in-order):");
        tree.inOrderTraversal(tree.root);
        System.out.println();

        // Delete a few values
        System.out.println("Deleting values 50 and 30...");
        tree.delete(50);
        tree.delete(30);

        // Display the tree after deletion
        System.out.println("Tree after deletion (in-order):");
        tree.inOrderTraversal(tree.root);
        System.out.println();
    }
}

