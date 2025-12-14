/* input (example):
  1 2
  3
  1 1
  1 2
  1 3
  output: 2
*/
/*
 * Exercício da prática 2
 */
import java.util.Scanner;

/* INPUT:
 *  1- O número de ingredientes que o Mário não gosta
 *  2- O número que representa cada ingrediente
 * 3- Nº pizzas do menu
 * 4- N linhas com os ingredientes da pizza
 */
public class ED243 {
    public static void main(String[] args) {
        int count = 0;
        int numIng;
        Scanner in = new Scanner(System.in);
        boolean marioIng[] = new boolean[101]; // esse aqui é o vetor de booleanos, que contém os ingredientes
        int size = in.nextInt(); // esta variavel guarda o tamanho do vetor em que serão colocadas as pizzas que
                                 // o Mário não gosta
        // System.out.println(marioIng[0]);
        for (int i = 0; i < size; i++) {
            int x = in.nextInt();
            // System.out.println(x);
            marioIng[x] = true;
            // System.out.println("marcado: " + (marioIng[x] == true));
        }

        in.nextLine();
        int numPizzas = in.nextInt();
        in.nextLine();
        for (int i = 0; i < numPizzas; i++) {
            numIng = in.nextInt();
            if (marioLikes(numIng, in, marioIng))
                count++;
            if (i < numPizzas - 1)
                in.nextLine();
        }
        System.out.println(count);

        in.close();
    }

    public static boolean marioLikes(int num, Scanner in, boolean v[]) {
        for (int i = 0; i < num; i++) {
            int aux = in.nextInt();
            if (v[aux])
                return false;
        }
        return true;
    }

}
