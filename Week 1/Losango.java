//exercício 120
import java.util.Scanner;

public class Losango {
    public static void main(String[] args) {
        // inicializa uma instância do objeto Scanner
        Scanner scanner = new Scanner(System.in);
        // lê um int e armazena em n
        int n = scanner.nextInt();
        int count = 2;
        int cards = 1;

        for (int i = 0; i < n; i++) {
            int points = (n - cards) / 2;
            System.out.print(".".repeat(points));
            System.out.print("#".repeat(cards));
            System.out.println(".".repeat(points));
            if (cards == n) {
                count = -count;
            }
            cards = cards + count;
        }
        scanner.close();

    }
}
