package labreport.ads;

import java.util.ArrayList;

class BTreeNode {
    int[] keys;             // Array of keys
    int t;                  // Minimum degree
    BTreeNode[] children;   // Array of child pointers
    int n;                  // Current number of keys
    boolean isLeaf;         // True if leaf node

    public BTreeNode(int t, boolean isLeaf) {
        this.t = t;
        this.isLeaf = isLeaf;
        keys = new int[2 * t - 1];
        children = new BTreeNode[2 * t];
        n = 0;
    }

    public void traverse() {
        for (int i = 0; i < n; i++) {
            if (!isLeaf) children[i].traverse();
            System.out.print(keys[i] + " ");
        }
        if (!isLeaf) children[n].traverse();
    }

    public BTreeNode search(int key) {
        int i = 0;
        while (i < n && key > keys[i]) i++;
        if (i < n && keys[i] == key) return this;
        if (isLeaf) return null;
        return children[i].search(key);
    }

    void insertNonFull(int key) {
        int i = n - 1;

        if (isLeaf) {
            while (i >= 0 && keys[i] > key) {
                keys[i + 1] = keys[i];
                i--;
            }
            keys[i + 1] = key;
            n++;
        } else {
            while (i >= 0 && keys[i] > key) i--;

            if (children[i + 1].n == 2 * t - 1) {
                splitChild(i + 1, children[i + 1]);
                if (keys[i + 1] < key) i++;
            }
            children[i + 1].insertNonFull(key);
        }
    }

    void splitChild(int i, BTreeNode y) {
        BTreeNode z = new BTreeNode(y.t, y.isLeaf);
        z.n = t - 1;

        for (int j = 0; j < t - 1; j++) z.keys[j] = y.keys[j + t];
        if (!y.isLeaf) for (int j = 0; j < t; j++) z.children[j] = y.children[j + t];

        y.n = t - 1;

        for (int j = n; j >= i + 1; j--) children[j + 1] = children[j];
        children[i + 1] = z;

        for (int j = n - 1; j >= i; j--) keys[j + 1] = keys[j];
        keys[i] = y.keys[t - 1];
        n++;
    }

    int findKey(int key) {
        int idx = 0;
        while (idx < n && keys[idx] < key) idx++;
        return idx;
    }

    void remove(int key) {
        int idx = findKey(key);

        if (idx < n && keys[idx] == key) {
            if (isLeaf) removeFromLeaf(idx);
            else removeFromNonLeaf(idx);
        } else {
            if (isLeaf) {
                System.out.println("Key " + key + " does not exist in the tree.");
                return;
            }
            boolean flag = idx == n;
            if (children[idx].n < t) fill(idx);
            if (flag && idx > n) children[idx - 1].remove(key);
            else children[idx].remove(key);
        }
    }

    void removeFromLeaf(int idx) {
        for (int i = idx + 1; i < n; i++) keys[i - 1] = keys[i];
        n--;
    }

    void removeFromNonLeaf(int idx) {
        int key = keys[idx];

        if (children[idx].n >= t) {
            int pred = getPred(idx);
            keys[idx] = pred;
            children[idx].remove(pred);
        } else if (children[idx + 1].n >= t) {
            int succ = getSucc(idx);
            keys[idx] = succ;
            children[idx + 1].remove(succ);
        } else {
            merge(idx);
            children[idx].remove(key);
        }
    }

    int getPred(int idx) {
        BTreeNode cur = children[idx];
        while (!cur.isLeaf) cur = cur.children[cur.n];
        return cur.keys[cur.n - 1];
    }

    int getSucc(int idx) {
        BTreeNode cur = children[idx + 1];
        while (!cur.isLeaf) cur = cur.children[0];
        return cur.keys[0];
    }

    void fill(int idx) {
        if (idx != 0 && children[idx - 1].n >= t) borrowFromPrev(idx);
        else if (idx != n && children[idx + 1].n >= t) borrowFromNext(idx);
        else {
            if (idx != n) merge(idx);
            else merge(idx - 1);
        }
    }

    void borrowFromPrev(int idx) {
        BTreeNode child = children[idx];
        BTreeNode sibling = children[idx - 1];

        for (int i = child.n - 1; i >= 0; i--) child.keys[i + 1] = child.keys[i];
        if (!child.isLeaf) for (int i = child.n; i >= 0; i--) child.children[i + 1] = child.children[i];

        child.keys[0] = keys[idx - 1];
        if (!child.isLeaf) child.children[0] = sibling.children[sibling.n];
        keys[idx - 1] = sibling.keys[sibling.n - 1];
        child.n++;
        sibling.n--;
    }

    void borrowFromNext(int idx) {
        BTreeNode child = children[idx];
        BTreeNode sibling = children[idx + 1];

        child.keys[child.n] = keys[idx];
        if (!child.isLeaf) child.children[child.n + 1] = sibling.children[0];

        keys[idx] = sibling.keys[0];
        for (int i = 1; i < sibling.n; i++) sibling.keys[i - 1] = sibling.keys[i];
        if (!sibling.isLeaf) for (int i = 1; i <= sibling.n; i++) sibling.children[i - 1] = sibling.children[i];

        child.n++;
        sibling.n--;
    }

    void merge(int idx) {
        BTreeNode child = children[idx];
        BTreeNode sibling = children[idx + 1];

        child.keys[t - 1] = keys[idx];
        for (int i = 0; i < sibling.n; i++) child.keys[i + t] = sibling.keys[i];
        if (!child.isLeaf) for (int i = 0; i <= sibling.n; i++) child.children[i + t] = sibling.children[i];

        for (int i = idx + 1; i < n; i++) keys[i - 1] = keys[i];
        for (int i = idx + 2; i <= n; i++) children[i - 1] = children[i];

        child.n += sibling.n + 1;
        n--;
    }
}

class BTree {
    BTreeNode root;
    int t;

    public BTree(int t) {
        this.t = t;
        root = null;
    }

    public void traverse() {
        if (root != null) root.traverse();
    }

    public BTreeNode search(int key) {
        return root == null ? null : root.search(key);
    }

    public void insert(int key) {
        if (root == null) {
            root = new BTreeNode(t, true);
            root.keys[0] = key;
            root.n = 1;
        } else {
            if (root.n == 2 * t - 1) {
                BTreeNode s = new BTreeNode(t, false);
                s.children[0] = root;
                s.splitChild(0, root);
                int i = s.keys[0] < key ? 1 : 0;
                s.children[i].insertNonFull(key);
                root = s;
            } else {
                root.insertNonFull(key);
            }
        }
    }

    public void remove(int key) {
        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }
        root.remove(key);
        if (root.n == 0) {
            root = root.isLeaf ? null : root.children[0];
        }
    }
}

public class BTreeDemo {
    public static void main(String[] args) {
        BTree tree = new BTree(3);

        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(6);
        tree.insert(12);
        tree.insert(30);
        tree.insert(7);
        tree.insert(17);

        System.out.println("Traversal of the constructed tree:");
        tree.traverse();
        System.out.println();
    }
}
