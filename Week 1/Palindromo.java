
//exercício 121
import java.util.Scanner;

class Palindromo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // lê o número de linhas a processar
        int n = scanner.nextInt();
        System.out.println(n);
        scanner.nextLine();
        /*
         * num ciclo irei ler linha a linha, se for palíndromo imprime "sim", se não for
         * imprime "não"
         */
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine(); // ler uma linha e guardar em line
            line = removeSigns(line);
            // System.out.println(line);

            // impressão das soluções
            if (check(line)) {
                System.out.println("sim");
            } else {
                System.out.println("nao");
            }

        }
        scanner.close();
    }

    public static boolean check(String a) {
        /* Este método verifica se uma palavra é ou não um palíndromo */
        int ini = 0;

        int fim = a.length() - 1; // controla do fim até ao centro do índice
        // boolean ver = true; // vai verificar se é ou não palíndromo
        int j = 0; // controla o índice
        int stop = a.length() / 2; // se a palavra tiver tamanho par, então vamos comparar tudo até ao centro, pois
                                   // não tem um
        while (j < stop) {
            if (a.charAt(ini++) != a.charAt(fim--)) {
                return false;
            }
            j++;
        }
        return true;
    }

    public static String removeSigns(String a) {
        /*
         * Objetivo: devolver uma string em minúsculas e remover tudo o que não seja
         * letra
         * passo 1: passa tudo a minúsculo
         * passo 2: remove todos os sinais
         */
        a = a.toLowerCase(); //método para converter de maiúscula para minúscula
        int size = a.length();
        String res = new String();
        for (int i = 0; i < size; i++) {
            char c = a.charAt(i);
            if (Character.isLetter(c)) {
                res += c;
            }
        }
        // System.out.println(res);
        return res;
    }
}