public class ED212 {

    static int[] sums;

    public static int[] sumLevels(BTree<Integer> t) {
        sums = new int[t.depth() + 1];
        // System.out.println(sums.length);
        sumLevels(0, t.getRoot());
        return sums;
    }

    public static void sumLevels(int n, BTNode<Integer> node) {
        if (node == null)
            return;
        sums[n] += node.getValue();
        
        sumLevels(n + 1, node.getLeft());
        sumLevels(n + 1, node.getRight());
    }

}