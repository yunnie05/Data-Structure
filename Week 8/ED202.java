import java.util.Scanner;
import java.lang.Math;

public class ED202 {
    static float dist = 10000000;
    static float m[][];

    static void write(int[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        m = new float[num][num];
        in.nextLine();
        int v[] = new int[num - 1];
        // System.out.println(in.nextLine());
        read_matrix(in, num, v);
        // write(v);
        permutations(v);

        System.out.println(round((double) dist, 2));
        // int perm[] = { 2, 3, 4, 5, 1, 0 };
        // int test[] = { 1, 2, 3, 4, 5, 6 };
        // System.out.println(sum(perm,test));
        // System.out.println(v[2]);
        // System.out.println(m[0][1]);
    }

    public static double round(double value, int n) {
        double factor = Math.pow(10, n);
        return Math.round(value * factor) / factor;
    }

    // Escrever todos as permutacoes do array v[]
    static void permutations(int v[]) {
        boolean used[] = new boolean[v.length]; // $i$ esta na permutacao?
        int perm[] = new int[v.length]; // permutacao actual
        goPerm(0, v, used, perm); // chamar funcao recursiva
    }

    static float sum(int perm[], int v[]) {
        float res = 0;
        int i = 0;
        for (int j = 0; j < perm.length; j++) {
            int pos = v[perm[j]];
            // System.out.print(pos + " ");
            res += m[i][pos];
            i = pos;
        }
        // System.out.println();
        res += m[i][0];
        return res;

    }

    // Gera todos os subconjuntos a partir da posicao 'cur'
    static void goPerm(int cur, int v[], boolean used[], int perm[]) {
        if (cur == v.length) { // Caso base: terminamos a permutacao
            float curD = sum(perm, v);
            dist = Math.min(dist, curD);
            // System.out.println(curD);
            // for (int i = 0; i < v.length; i++) // Escrever a permutacao
            // System.out.print(v[perm[i]] + " ");
            // System.out.println();
        } else { // Se nao terminamos, continuar a gerar
            for (int i = 0; i < v.length; i++) // Tentar todos os elementos
                if (!used[i]) {
                    used[i] = true;
                    perm[cur] = i;
                    goPerm(cur + 1, v, used, perm);
                    used[i] = false;
                }
        }
    }

    public static void read_matrix(Scanner in, int num, int v[]) {
        for (int i = 0; i < num; i++) {
            in.nextLine();
            if (i < num - 1)
                v[i] = i + 1;
            for (int j = 0; j < num; j++) {
                // System.out.print(in.nextFloat());
                m[i][j] = in.nextFloat();
                // System.out.print(m[i][j]);
                // if (j < num)
                // System.out.print(" ");
            }
            // System.out.println();
        }
    }
}