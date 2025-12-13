import java.util.Scanner;
import java.lang.Math;

public class ED200 {
    static int rows; // Numero de linhas
    static int cols; // Numero de colunas
    static char m[][]; // Matriz de celulas
    static boolean visited[][];
    // Tamanho da mancha que inclui posicao (y,x)

    static int maxCell() {
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (m[i][j] == '#' && !visited[i][j]) {
                    max = Math.max(max, t(i, j));
                }
            }
        }
        return max;
    }

    static int t(int y, int x) {
        // System.out.println(m[y][x] + " : ");
        // System.out.println("novo y: " + (y + 1) + " novo x: " + (x + 1));
        if (y < 0 || y >= rows || x < 0 || x >= cols) {
            // System.out.println("cols:" + cols + " rows:" + rows);
            return 0; // Caso base: fora dos limites
        }
        if (visited[y][x]) {

            return 0; // Caso base: celula ja visitada
        }
        if (m[y][x] == '.')
            return 0; // Caso base: celula vazia
        int count = 1; // celula nao vazia
        visited[y][x] = true; // marcar como visitada
        count += t(y - 1, x); // Adicionando celulas nao vizinhas
        count += t(y + 1, x);
        count += t(y, x + 1);
        count += t(y, x - 1);
        // System.out.println("novo y: " + (y + 1) + " novo x: " + (x + 1));
        count += t(y + 1, x + 1); // diagonal primária a descer
        count += t(y + 1, x - 1); // diagonal secundária a descer
        count += t(y - 1, x - 1); // diagonal primária a subir
        count += t(y - 1, x + 1); // diagonal secundária a subir
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int casos = in.nextInt();
        // char m[][];
        for (int i = 0; i < casos; i++) {
            in.nextLine();
            rows = in.nextInt();
            cols = in.nextInt();
            // in.nextLine();
            m = new char[rows][cols];
            visited = new boolean[rows][cols];
            read_matrix(in, rows);
            // write(m, rows, cols);
            System.out.println(maxCell());
            // writebool(visited, rows, cols);
        }
    }

    public static void write(char m[][], int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }

    public static void writebool(boolean visited[][], int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void read_matrix(Scanner in, int rows) {
        for (int i = 0; i < rows; i++) {
            in.nextLine();
            m[i] = in.next().toCharArray();
        }
    }
}
