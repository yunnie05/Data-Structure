import java.util.Scanner;
import java.lang.Math;

public class ED216 {
    public static void main(String[] args) {
        int maxCont, numMax;
        Scanner in = new Scanner(System.in);
        Matrix m;
        int row, col;
        // leitura de input
        row = in.nextInt();
        col = in.nextInt();
        in.nextLine();
        m = new Matrix(row, col);
        m.read(in);
        m.findMax();

        in.close();
    }
}

class Matrix {
    int rows, cols;
    char m[][];

    Matrix(int r, int c) {
        rows = r;
        cols = c;
        m = new char[rows][cols];
    }

    public void findMax() {
        int[] res = new int[2];
        int count = 0;
        int maxCard = 0;
        // respeitam o tamanho máximo
        int countCard = 0; // auxiliar
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (m[r][c] == '.')
                    continue;
                countCard = Math.max(countC(r, c, 0, 1), countC(r, c, 1, 0));
                // System.out.println("(" + r + "," + c + "): " + countCard);

                /*
                 * if ((r == 3 && c == 0)) {
                 * System.out.println("(" + r + "," + c + "): " + countCard);
                 * System.out.println(countC(r, c, 0, 1));
                 * 
                 * }
                 */
                if (countCard > maxCard) {
                    maxCard = countCard;
                    count = 1;
                } else if (countCard == maxCard) {
                    count += 1;
                }

                // countCard= countCard(r,c,0)
            }
        }
        System.out.println(maxCard + " " + count);

    }

    public int countC(int y, int x, int incy, int incx) {
        int count = 0;
        // boolean prov = false;
        char aux = m[y][x];
        int i, lim;
        if (incy == 0 && incx == 1) {
            i = x;
            lim = cols;
        } else {
            i = y;
            lim = rows;
        }
        for (; i < lim; i++) {
            if (aux == '#')
                count++;
            else
                break;
            y += incy;
            x += incx;
            if (!isValid(y, x)) {
                break;
            }

            aux = m[y][x];
        }
        return count;
    }

    public boolean isValid(int y, int x) {
        if ((y == rows) || (x == cols))
            return false;
        return true;
    }

    public void read(Scanner in) {
        String aux;
        for (int i = 0; i < rows; i++) {
            aux = in.nextLine();
            // System.out.println("linha: " + aux);
            for (int j = 0; j < cols; j++) {
                m[i][j] = aux.charAt(j);
            }
        }
        // System.out.println();
    }

    public void print() {
        String res;
        for (int i = 0; i < rows; i++) {
            res = "";
            for (int j = 0; j < cols; j++) {
                res += m[i][j];
            }
            System.out.println(res);
        }
        // return res;
    }
}
