public class BooleanArrayIntSet implements IntSet {
    private int size = 0;
    private boolean elem[];
    private int maxSize;

    BooleanArrayIntSet(int n) {
        maxSize = n;
        elem = new boolean[n + 1];
    }

    public boolean contains(int x) {
        if (x > maxSize || size == 0)
            return false;
        if (elem[x])
            return true;
        return false;
    }

    public boolean add(int x) {
        if (x > maxSize)
            throw new RuntimeException("Maximum size of set reached");
        if (!contains(x)) {
            elem[x] = true;
            size++;
            return true;
        }
        return false;
    }

    public boolean remove(int x) {
        // if (x > maxSize)
        // throw new RuntimeException("Maximum size of set reached");
        if (contains(x)) {
            elem[x] = false;
            size--;
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void clear() {
        boolean novo[] = new boolean[maxSize + 1];
        elem = novo;
        size = 0;
    }

    public boolean equals(IntSet s) {
        if (size != s.size())
            return false;
        if (size == 0)
            return true;
        for (int i = 1; i <= maxSize; i++) {
            if (elem[i]) {
                if (!s.contains(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public IntSet intersection(IntSet s) {
        IntSet res = new BooleanArrayIntSet(maxSize + 1);
        for (int i = 0; i <= maxSize; i++) {
            if (elem[i]) {
                if (s.contains(i)) {
                    res.add(i);
                }
            }
        }
        return res;
    }

    public String toString() {
        int aux = size;
        String res = "{";
        if (size == 0)
            return "{}";
        for (int i = 1; i <= maxSize; i++) {
            if (size == 0)
                break;
            if (elem[i]) {
                res += i;
                aux--;
                if (aux > 0)
                    res += ", ";
                // System.out.println(i);
            }
        }
        res += "}";
        return res;
    }
}