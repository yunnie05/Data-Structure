//import java.lang.Math;

public class ED213 {
    public static String maxSum(BTree<Integer> t) {
        BTNode<Integer> root = t.getRoot();
        return maxSum(root, new Path("", 0)).path;
    }

    public static Path maxSum(BTNode<Integer> node, Path path) {
        if (node == null) {
            int maxEl = path.path.length() - 1;
            path.path = path.path.substring(0, maxEl);
            return path;
        }
        path.soma += node.getValue();
        // System.out.println(path.soma);
        Path esq = maxSum(node.getLeft(), new Path(path.path + "E", path.soma));
        Path dir = maxSum(node.getRight(), new Path(path.path + "D", path.soma));
        /*
         * if (node.getValue() == 12)
         * System.out.println(
         * "Path à esquerda: " + esq.path + " soma: " + esq.soma + "| Path à direita: "
         * + dir.path + " soma:"
         * + dir.soma);
         */
        if (esq.soma > dir.soma) {
            return esq;
        }
        return dir;
    }
}

class Path {
    String path;
    int soma;

    Path(String p, int s) {
        path = p;
        soma = s;
    }
}