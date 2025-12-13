// -----------------------------------------------------------
// Estruturas de Dados 2025/2026 (CC1007) - DCC/FCUP
// ED300 - code provide to be completed
// Note: it uses a specific tree of integers
// -----------------------------------------------------------

import java.util.*;

// define a tree node
class BTNode<T> {
    private T value; // node value
    private BTNode<T> left; // left child
    private BTNode<T> right; // right child

    // Constructor
    BTNode(T v, BTNode<T> l, BTNode<T> r) {
        value = v;
        left = l;
        right = r;
    }

    // Getters and Setters
    public T getValue() {
        return value;
    }

    public BTNode<T> getLeft() {
        return left;
    }

    public BTNode<T> getRight() {
        return right;
    }

    public void setValue(T v) {
        value = v;
    }

    public void setLeft(BTNode<T> l) {
        left = l;
    }

    public void setRight(BTNode<T> r) {
        right = r;
    }
}

// define a binary tree of integers

class BTree {
    private BTNode<Integer> root; // tree root

    // Constructor
    BTree() {
        root = null;
    }

    // verifies if tree is empty
    public boolean isEmpty() {
        return root == null;
    }

    // reads a tree in PreOrder
    // input must be as described in the examples input
    public void readTreePreOrder(Scanner in) {
        root = readIntNode(in);
    }

    // helper method
    private BTNode<Integer> readIntNode(Scanner in) {
        String s = in.next();
        if (s.equals("N"))
            return null;
        Integer value = Integer.parseInt(s);
        BTNode<Integer> left = readIntNode(in);
        BTNode<Integer> right = readIntNode(in);
        return new BTNode<Integer>(value, left, right);
    }

    // required methods to answer to ED300 problem
    public int countNodesWithGrandParentMultipleOfK(int k) {
        return countNodesWithGrandParentMultipleOfK(root, null, null, k);
    }

    public int countNodesWithGrandParentMultipleOfK(BTNode<Integer> cur, BTNode<Integer> par, BTNode<Integer> gpar,
            int k) {
        if (cur == null)
            return 0;
        int count = 0;
        if (gpar != null && ((Integer) gpar.getValue() % k == 0)) {
            count += 1;
        }
        count += countNodesWithGrandParentMultipleOfK(cur.getLeft(), cur, par, k);
        count += countNodesWithGrandParentMultipleOfK(cur.getRight(), cur, par, k);
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nc = in.nextInt(); // num. of cases

        for (int i = 0; i < nc; i++) {
            BTree t = new BTree(); // binary tree of integers
            t.readTreePreOrder(in);
            int k = in.nextInt();
            System.out.println("Case " + (i + 1) + ":");
            // print num of nodes whose grand-parent node is multiple of k
            // call the method you implemented in BTree
            System.out.println(
                    "Num Nodes with Grand Parente multiple of " + k + "= " + t.countNodesWithGrandParentMultipleOfK(k));
        }
    }

}

// class that gives name to the file to be compiled
// advise to test locally your solutions before submitting
class ED300 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nc = in.nextInt(); // num. of cases

        for (int i = 0; i < nc; i++) {
            BTree t = new BTree(); // binary tree of integers
            t.readTreePreOrder(in);
            int k = in.nextInt();
            System.out.println("Case " + (i + 1) + ":");
            // print num of nodes whose grand-parent node is multiple of k
            // call the method you implemented in BTree
            System.out.println(
                    "Num Nodes with Grand Parente multiple of " + k + "= " + t.countNodesWithGrandParentMultipleOfK(k));
        }
    }
}
