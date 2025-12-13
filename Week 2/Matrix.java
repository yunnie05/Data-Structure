import java.util.Scanner;
//import java.util.Arrays;

class Matrix {
    int data[][]; // os elementos da matriz em si
    int rows; // numero de linhas
    int cols; // numero de colunas

    // construtor padrao de matriz
    Matrix(int r, int c) {
        data = new int[r][c];
        rows = r;
        cols = c;
    }

    // Ler os rows x cols elementos da matriz
    public void read(Scanner in) {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                data[i][j] = in.nextInt();
    }

    // Representacao em String da matriz
    public String toString() {
        String ans = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                ans += data[i][j] + " ";
            ans += "\n";
        }
        return ans;
    }

    public static Matrix identity(int n) {
        // quando coloca o índice da linha igual ao índice da coluna será 1
        // else será 0
        Matrix ident = new Matrix(n, n);
        for (int idrow = 0; idrow < ident.rows; idrow++) {
            for (int idcol = 0; idcol < ident.cols; idcol++) {
                if (idrow == idcol) {
                    ident.data[idrow][idcol] = 1;
                }
            }
        }
        return ident;
    }

    public Matrix transpose() {
        Matrix transp = new Matrix(cols, rows);
        for (int i = 0; i < transp.rows; i++) {
            for (int j = 0; j < transp.cols; j++) {
                transp.data[i][j] = data[j][i];
            }
        }
        return transp;
    }

    public Matrix sum(Matrix m) {
        Matrix soma = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                soma.data[i][j] = m.data[i][j] + data[i][j];
            }
        }
        return soma;
    }

    public Matrix multiply(Matrix m) {
        Matrix mult = new Matrix(rows, m.cols);
        // nt[] a = getcol(m, 0);
        for (int i = 0; i < mult.rows; i++) {
            int[] linha = data[i];
            for (int j = 0; j < mult.cols; j++) {
                int[] coluna = getcol(m, j);
                mult.data[i][j] = multvetor(linha, coluna);
            }
        }
        return mult;
    }

    public int multvetor(int[] linha, int[] coluna) {
        int size = linha.length;
        int res = 0;
        for (int i = 0; i < size; i++) {
            res += linha[i] * coluna[i];
        }
        return res;
    }

    public int[] getcol(Matrix m, int col) {
        // este método retorna um vetor que contém todos os elemntos de uma dada coluna
        // da matriz
        /*
         * col: índice da coluna
         */
        int num_rows = m.rows; // número de linhas
        int[] aux = new int[num_rows];
        for (int i = 0; i < num_rows; i++) {
            aux[i] = m.data[i][col];
        }
        return aux;
    }
}