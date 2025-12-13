// -----------------------------------------------------------
// Estruturas de Dados 2025/2026 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2526/
// -----------------------------------------------------------
// Arvore binaria "normal"
// -----------------------------------------------------------

public class BTree<T> {
    private BTNode<T> root; // raiz da arvore

    // Construtor
    BTree() {
        root = null;
    }

    // Getter e Setter para a raiz
    public BTNode<T> getRoot() {
        return root;
    }

    public void setRoot(BTNode<T> r) {
        root = r;
    }

    //
    public T path(String s) {
        return path(s, root, 0);
    }

    public T path(String s, BTNode<T> node, int indx) {
        // int size = s.length();
        // char val = s.charAt(indx);
        BTNode<T> aux;
        if (indx == s.length() || s.charAt(indx) == 'R')
            return node.getValue();
        // char val = s.charAt(indx);
        if (s.charAt(indx) == 'E') {
            aux = node.getLeft();
        } else {
            aux = node.getRight();
        }
        return path(s, aux, indx + 1);
    }

    // determinar se uma árvore é estritamente binária
    public boolean strict() {
        return strict(root);
    }

    public boolean strict(BTNode<T> node) {
        if (node == null)
            return true;
        if (!((node.getLeft() == null && node.getRight() == null)
                || (node.getLeft() != null && node.getRight() != null)))
            return false;
        return strict(node.getLeft()) && strict(node.getRight());
    }

    // conta o número de folhas
    public int numberLeafs() {
        return numberLeafs(root);
    }

    public int numberLeafs(BTNode<T> no) {
        if (no == null)
            return 0;
        if (no.getLeft() == null && no.getRight() == null) { // caso base: quando surge um nó sem filhos
            return 1;
        }
        return numberLeafs(no.getLeft()) + numberLeafs(no.getRight());
    }

    // Verificar se arvore esta vazia
    public boolean isEmpty() {
        return root == null;
    }

    // Numero de nos da arvore
    public int numberNodes() {
        return numberNodes(root);
    }

    private int numberNodes(BTNode<T> n) {
        if (n == null)
            return 0;
        return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
    }

    // --------------------------------------------------------

    // Altura da arvore
    public int depth() {
        return depth(root);
    }

    private int depth(BTNode<T> n) {
        if (n == null)
            return -1;
        return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
    }

    // --------------------------------------------------------

    // O elemento value esta contido na arvore?
    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(BTNode<T> n, T value) {
        if (n == null)
            return false;
        if (n.getValue().equals(value))
            return true;
        return contains(n.getLeft(), value) || contains(n.getRight(), value);
    }

    // --------------------------------------------------------

    // Imprimir arvore em PreOrder
    public void printPreOrder() {
        System.out.print("PreOrder:");
        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder(BTNode<T> n) {
        if (n == null)
            return;
        System.out.print(" " + n.getValue());
        printPreOrder(n.getLeft());
        printPreOrder(n.getRight());
    }

    // --------------------------------------------------------

    // Imprimir arvore em InOrder
    public void printInOrder() {
        System.out.print("InOrder:");
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(BTNode<T> n) {
        if (n == null)
            return;
        printInOrder(n.getLeft());
        System.out.print(" " + n.getValue());
        printInOrder(n.getRight());
    }

    // --------------------------------------------------------

    // Imprimir arvore em PostOrder
    public void printPostOrder() {
        System.out.print("PostOrder:");
        printPostOrder(root);
        System.out.println();
    }

    private void printPostOrder(BTNode<T> n) {
        if (n == null)
            return;
        printPostOrder(n.getLeft());
        printPostOrder(n.getRight());
        System.out.print(" " + n.getValue());
    }

    // --------------------------------------------------------

    // Imprimir arvore numa visita em largura (usando TAD Fila)
    public void printBFS() {
        System.out.print("BFS:");

        MyQueue<BTNode<T>> q = new LinkedListQueue<BTNode<T>>();
        q.enqueue(root);
        while (!q.isEmpty()) {
            BTNode<T> cur = q.dequeue();
            if (cur != null) {
                System.out.print(" " + cur.getValue());
                q.enqueue(cur.getLeft());
                q.enqueue(cur.getRight());
            }
        }
        System.out.println();
    }

    // --------------------------------------------------------

    // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
    public void printDFS() {
        System.out.print("DFS:");

        MyStack<BTNode<T>> q = new LinkedListStack<BTNode<T>>();
        q.push(root);
        while (!q.isEmpty()) {
            BTNode<T> cur = q.pop();
            if (cur != null) {
                System.out.print(" " + cur.getValue());
                q.push(cur.getLeft());
                q.push(cur.getRight());
            }
        }
        System.out.println();
    }

}
