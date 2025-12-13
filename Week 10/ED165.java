import java.util.Scanner;

public class ED165 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.nextLine();
        int[] vec = new int[num];
        for (int i = 0; i < num; i++) {
            vec[i] = in.nextInt();
        }
        in.nextLine();
        BSTree<Integer> t = new BSTree<>();
        for (int i = 0; i < num; i++) {
            fillSums(vec, t, i, i);
        }
        // t.printInOrder();
        num = in.nextInt();
        in.nextLine();
        for (int i = 0; i < num; i++) {
            int temp = in.nextInt();
            System.out.print(temp + ": ");
            if (t.contains(temp))
                System.out.println("sim");
            else
                System.out.println("nao");
        }
        in.close();
    }

    public static void fillSums(int[] vec, BSTree<Integer> t, int f, int s) {
        if (s == vec.length)
            return;
        // System.out.println(vec[f] + "+" + vec[s] + "= " + (vec[f] + vec[s]));
        t.insert(vec[f] + vec[s]);
        fillSums(vec, t, f, s + 1);
    }

}