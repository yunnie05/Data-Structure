import java.util.*;

public class ED215 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        MinHeap<Client> offers = new MinHeap<>(num, new PComp());
        for (int i = 0; i < num; i++) {
            // in.nextLine();
            if (in.next().equals("OFERTA")) {
                // String name = in.next();
                // int p = in.nextInt();
                offers.insert(new Client(in.next(), in.nextInt()));
            } else {
                Client aux = offers.removeMin();
                System.out.println(aux.price + " " + aux.name);
            }
        }
        // System.out.println();
        in.close();
    }
}

class Client {
    String name;
    int price;

    Client(String n, int p) {
        name = n;
        price = p;
    }
}

class PComp implements Comparator<Client> {
    public int compare(Client a, Client b) {
        return b.price - a.price;
    }
}