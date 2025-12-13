import java.util.Scanner;

public class ED006 {
    // os nomes das crianças irão ficar numa lista
    // dá frase só queremos saber o índice da última palavra, não precisamos
    // armazená-la
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // ircularLinkedList<String> child = new CircularLinkedList<String>();
        int c = in.nextInt();
        // n.nextLine();
        for (int i = 0; i < c; i++) {
            CircularLinkedList<String> child = new CircularLinkedList<String>();
            in.nextLine();
            String aux = in.nextLine();
            int v = aux.split(" ").length - 1; // vamos saber o índice da última palavra
            int num_child = in.nextInt();
            read_names(child, num_child, in); // funciona bem
            playGame(child, v);
            print_result(child);
        }
        in.close();
    }

    public static void read_names(CircularLinkedList<String> ch, int num, Scanner in) {
        String aux;
        for (int i = 0; i < num; i++) {
            aux = in.next();
            ch.addLast(aux);
        }

    }

    public static void playGame(CircularLinkedList<String> c, int v) {
        int ind; // guarda o índice do nome a remover
        // int aux = 0;
        while (c.size() > 1) {
            ind = v % c.size();
            while (ind-- != 0) {
                c.rotate();
                // ind--;
            }
            c.removeFirst();
            // break;
        }
        // System.out.println(c.size( 1);
        // System.out.println(c);
    }

    public static void print_result(CircularLinkedList<String> ch) {
        String a = ch.getFirst();
        if (a.equals("Carlos")) {
            System.out.println("O Carlos nao se livrou");
        } else {
            String pron;
            if (a.charAt(a.length() - 1) == 'a') {
                pron = "da ";
            } else {
                pron = "do ";
            }
            System.out.println("O Carlos livrou-se (coitado " + pron + a + "!)");
        }
    }
}
// return (ind + 1) % size;
