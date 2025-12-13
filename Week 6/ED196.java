public class ED196 {
    public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b) {
        // System.out.println("tamanho inicial: " + q.size());
        while (q.size() > 0) {
            String nome = q.dequeue();
            String op = q.dequeue();
            if (op.equals("A"))
                a.enqueue(nome);
            else if (op.equals("B"))
                b.enqueue(nome);
            else {
                if (a.size() == b.size())
                    continue;
                MyQueue<String> temp = smaller(a, b);
                temp.enqueue(nome);
            }

            // System.out.println(nome);
            // System.out.println(op);
            // System.out.println(q.size());
            // System.out.println();
        }
        //System.out.println(a);
        //System.out.println(b);
        //System.out.println(q);
    }

    public static MyQueue<String> smaller(MyQueue<String> a, MyQueue<String> b) {
        if (a.size() < b.size())
            return a;
        return b;
    }
}