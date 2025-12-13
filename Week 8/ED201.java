import java.util.Scanner;
import java.lang.Math;

public class ED201 {
    static int trip;
    static int time = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        trip = in.nextInt();
        int num = in.nextInt();
        int playlist[] = new int[num];
        for (int i = 0; i < num; i++) {
            in.nextLine();
            playlist[i] = in.nextInt();
        }
        sets(playlist);
        System.out.println(time);

        // System.out.println(trip);
    }

    // Escrever todos os subconjuntos do array v[]
    static void sets(int v[]) {
        // array de booleanos para representar o conjunto
        boolean used[] = new boolean[v.length];
        goSets(0, v, used); // chamar funcao recursiva
    }

    // Gera todos os subconjuntos a partir da posicao 'cur'
    static void goSets(int cur, int v[], boolean used[]) {
        if (cur == v.length) { // Caso base: terminamos o conjunto
            int curtime = sum(used, v);
            if (curtime <= trip) {
                time = Math.max(time, curtime);
                /*if (curtime == 1298) {
                    System.out.print("Set:");
                    for (int i = 0; i < v.length; i++)
                        if (used[i])
                            System.out.print(" " + v[i]);
                    // time = Math.max(time, curtime);
                    System.out.println("      " + sum(used, v));
                }*/
            }

        } else { // Se nao terminamos, continuar a gerar
            used[cur] = true; // Subconjuntos que incluem o elemento actual
            goSets(cur + 1, v, used);// Chamada recursiva
            used[cur] = false; // Subconjuntos que nao incluem o el. actual
            goSets(cur + 1, v, used);// Chamada recursiva
        }
    }

    public static int sum(boolean used[], int v[]) {
        int sum = 0;
        int size = used.length;
        for (int i = 0; i < size; i++) {
            if (used[i])
                sum += v[i];
        }
        return sum;
    }

    // -----------------------------------------------------------

}