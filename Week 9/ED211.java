public class ED211 {
    public static int countEven(BTree<Integer> t) {
        //int count = 0;
        BTNode<Integer> root = t.getRoot();
        return countEven(root);
    }

    public static int countEven(BTNode<Integer> node) {
        if (node == null)
            return 0;
        int count = 0;
        if ((node.getValue() % 2) == 0)
            count++;
        return count + countEven(node.getLeft()) + countEven(node.getRight());
    }
}