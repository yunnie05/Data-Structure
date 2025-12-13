import java.util.*;

public class Primos {

    public static void main(String[] args) {
        /* este programa vai contar os primos entre 2 inteiros */
        int size = 10000001;
        byte[] num = new byte[size];
        crivo(num);
        // System.out.println(Arrays.toString(num));
        Scanner stdin = new Scanner(System.in);
        int a = stdin.nextInt();
        int b = stdin.nextInt();
        int count = count_prime(num, a, b);
        System.out.println(count);
        stdin.close();
    }

    public static void crivo(byte[] num) {
        // int point= 2;
        for (int i = 2; i < num.length; i++) {
            if (num[i] == 0)
                marcmult(num, i);
        }
    }

    public static void marcmult(byte[] num, int n) {
        long start = 1L * n * n;
        if (start >= num.length)
            return;
        int i = (int) start;
        while (i < num.length) {
            num[i] = 1;
            i += n;
        }
    }

    public static int count_prime(byte[] num, int a, int b) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (num[i] == 0)
                count += 1;
        }
        return count;
    }
}