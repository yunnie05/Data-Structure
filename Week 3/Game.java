import java.util.Scanner;

class Game {
    private static int n;
    private static char m[][];

    Game(int size) {
        n = size;
        m = new char[n][n];
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        Game g = new Game(n);
        stdin.nextLine();
        g.read(stdin);
        g.check();
        stdin.close();
    }

    public static void read(Scanner stdin) {
        for (int i = 0; i < n; i++) { // selecionamos uma linha de game
            String aux = stdin.nextLine();
            for (int j = 0; j < n; j++) {
                m[i][j] = aux.charAt(j);
            }
        }
    }

    public static void check() {
        for (int i = 0; i < n; i++) {
            verify(i, 0, 0, 1);
            verify(0, i, 1, 0);
        }
        verify(0, 0, 1, 1);
        verify(0, n - 1, 1, -1);
        if (!(finished()))
            System.out.println("Jogo incompleto");
        else
            System.out.println("Empate");
    }

    public static void verify(int x, int y, int incx, int incy) {
        if (m[x][y] == '.')
            return;
        for (int i = 0, xx = x, yy = y; i < n; i++, xx += incx, yy += incy) {
            if (m[xx][yy] != m[x][y])
                return;
        }
        win(m[x][y]);
    }

    public static boolean finished() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i][j] == '.')
                    return false;
            }
        }
        return true;
    }

    public static void win(char simb) {
        System.out.println("Ganhou o " + simb);
        System.exit(0);
    }

}
