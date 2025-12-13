import java.util.Scanner;
import java.lang.Math;

public class ED198 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.nextLine();
        int vec[] = new int[num];
        for (int i = 0; i < num; i++) {
            vec[i] = in.nextInt();
        }
        System.out.println(contig(vec));
        in.close();
    }

    public static int contig(int vec[]) {
        int size = vec.length;
        int curbest = vec[0];
        // int soma = vec[0];
        // int a = 0;
        int res = curbest;
        for (int i = 1; i < size; i++) {
            if (curbest < 0) {
                curbest = Math.max(curbest, vec[i]);
            } else {
                curbest += vec[i];
                res = Math.max(curbest, res);
            }
            res = Math.max(curbest, res);
            // System.out.println("soma atual: " + curbest + " best so far: " + res);
            // int s = 0;
            // a++;
        }
        return res;
    }

    /*
     * _________First version: Complexity O(n^3)________________
     * public static int contig(int vec[]) {
     * int size = vec.length;
     * int soma = vec[0];
     * // int a = 0;
     * for (int i = 0; i < size; i++) {
     * for (int j = i; j < size; j++) {
     * int sum = 0;
     * for (int k = i; k <= j; k++) {
     * sum += vec[k];
     * }
     * soma = Math.max(soma, sum);
     * }
     * //a++;
     * }
     * return soma;
     * }
     * 
     * _________Second version: Complexity O(n^2)________________
     * public static int contig(int vec[]) {
     * int size = vec.length;
     * int soma = vec[0];
     * // int a = 0;
     * for (int i = 0; i < size; i++) {
     * int s = 0;
     * for (int j = i; j < size; j++) {
     * s += vec[j];
     * soma = Math.max(soma, s);
     * }
     * // a++;
     * }
     * return soma;
     * }
     */

}
