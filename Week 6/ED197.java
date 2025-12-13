public class ED197 {
    public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b) {
        MyQueue<Integer> novo = new LinkedListQueue<Integer>();
        while (a.size() > 0 || b.size() > 0) {
            if (a.size() == 0) {
                while (b.size() > 0) {
                    novo.enqueue(b.dequeue());
                }
                break;
            } else if (b.size() == 0) {
                while (a.size() > 0) {
                    novo.enqueue(a.dequeue());
                }
                break;
            } else {
                int x = a.dequeue();
                int y = b.dequeue();
                // System.out.println("x: " + x + " y: " + y + "novo: " + novo);
                if (x > y) {
                    novo.enqueue(y);
                    if (b.size() == 0) {
                        novo.enqueue(x);
                        continue;
                    }
                    y = b.first();
                    add(x, y, b, novo);
                } else if (y > x) {
                    novo.enqueue(x);
                    if (a.size() == 0) {
                        novo.enqueue(y);
                        continue;
                    }
                    x = a.first();
                    add(y, x, a, novo);
                } else {
                    novo.enqueue(x);
                    novo.enqueue(y);
                }
            }
        }
        return novo;
    }

    public static void add(int fix, int el, MyQueue<Integer> cur, MyQueue<Integer> novo) {
        while (el < fix) {
            novo.enqueue(cur.dequeue());
            el = cur.first();
        }
        novo.enqueue(fix);
    }

}