import java.util.Scanner;

public class ED164 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        BSTree<String> t = new BSTree<>();
        for (int i = 0; i < num; i++) {
            in.nextLine();
            String aux = in.next();
            t.insert(aux);
        }
        System.out.println(t.numberNodes());
    }
}