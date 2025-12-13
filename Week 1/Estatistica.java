
//calcular a média e amplitude
import java.util.*;

class Estatistica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            // System.out.println(a[i]);
        }
        scanner.nextLine();
        // System.out.println(Arrays.toString(a));
        float media = calculoMedia(a, n);
        System.out.printf("%.2f\n", media);
        System.out.println(amplitude(a, n));
        scanner.close();
    }

    public static float calculoMedia(int[] x, int n) {
        int soma = 0;
        for (int i = 0; i < n; i++) {
            soma += x[i];
        }
        return (float) soma / (float) n;
    }

    public static int amplitude(int[] x, int n) {
        int min = x[0];
        int max = x[0];
        for (int i = 0; i < n; i++) {
            if (x[i] < min) {
                min = x[i];
            }
            if (x[i] > max) {
                max = x[i];
            }
        }
        // System.out.println(max);
        // System.out.println(min);
        return max - min;
    }
}
