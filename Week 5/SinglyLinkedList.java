public class SinglyLinkedList<T> {
    private Node<T> first;
    private int size;

    SinglyLinkedList() {
        first = null;
        size = 0;
    }

    public T get(int pos) {
        if (pos >= size || pos < 0)
            return null;
        int temp = 0;
        Node<T> cur = first;
        while (temp != pos) {
            cur = cur.getNext();
            temp++;
        }
        return cur.getValue();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void addFirst(T value) {
        // Node<T> aux= first.getNext();
        Node<T> newNode = new Node<T>(value, first);
        first = newNode; // muda-se a referência de first
        size++;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<T>(value, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node<T> aux = first;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(newNode);
        }
        size++;
    }

    public T getFirst() {
        if (isEmpty())
            return null;
        return first.getValue();
    }

    public T getLast() {
        if (isEmpty())
            return null;
        Node<T> cur = first;
        while (cur.getNext() != null) {
            cur = cur.getNext();
        }
        return cur.getValue();
    }

    public void removeFirst() {
        if (isEmpty())
            return;
        first = first.getNext();
        size--;
    }

    public void removeLast() {
        if (isEmpty())
            return;
        if (size == 1)
            first = null;
        else {
            Node<T> cur = first;
            while (cur.getNext().getNext() != null)
                cur = cur.getNext();
            cur.setNext(null);
        }
        size--;
    }

    public String toString() {
        String res = "{";
        Node<T> cur = first;
        while (cur != null) {
            res += cur.getValue();
            cur = cur.getNext();
            if (cur != null)
                res += ",";
        }
        res += "}";
        return res;
    }
}
