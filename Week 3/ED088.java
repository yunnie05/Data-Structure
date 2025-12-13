/* -----------------------------------
  Estruturas de Dados 2024/2025
  Jogo da Vida [ED088]  
----------------------------------- */

import java.util.Scanner;

// Classe para representar um jogo
class Game {
    final char DEAD = '.'; // Constante que indica uma celula morta
    final char ALIVE = 'O'; // Constante que indica uma celula viva
    private int rows, cols; // Numero de linhas e colunas
    private char m[][]; // Matriz para representar o estado do jogo

    // Construtor: inicializa as variaveis tendo em conta a dimensao dada
    Game(int r, int c) {
        rows = r;
        cols = c;
        m = new char[r][c];
    }

    // Metodo para ler o estado inicial para a matriz m[][]
    public void read(Scanner in) {
        for (int i = 0; i < rows; i++)
            m[i] = in.next().toCharArray();
    }

    // Metodo para escrever a matriz m[][]
    public void write() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }

    // Deve devolver o numero de celulas vivas que sao vizinhas de (y,x)
    private int countAlive(int y, int x) {
        int count = 0;
        int coord_linha, coord_coluna;
        for (int dy = -1; dy <= 1; dy++) {
            coord_linha = dy + y; // coordenada da linha
            if (!isValid(coord_linha, rows))
                continue;
            for (int dx = -1; dx <= 1; dx++) {
                if ((dx == 0) && (dy == 0))
                    continue;
                coord_coluna = dx + x; // coordenada da coluna
                if (!isValid(coord_coluna, cols))
                    continue;
                if (m[coord_linha][coord_coluna] == ALIVE) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public boolean isValid(int a, int lim) {
        // valida se as coordenadas de uma célula são válidas ou não
        if (((a >= 0) && (a < lim))) {
            return true;
        }
        return false;
    }

    // Deve fazer uma iteracao: cria nova geracao a partir da actual
    public void iterate() {
        char aux[][] = new char[rows][cols];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                int count = countAlive(y, x);
                // System.out.println("Coordenada" + y + x + ":" + count);
                aux[y][x] = setstate(y, x, count);
            }
        }
        m = aux;
    }

    public char setstate(int y, int x, int count) {
        if (m[y][x] == ALIVE) {
            if ((count == 2) || (count == 3))
                return ALIVE;
        } else if (m[y][x] == DEAD) {
            if (count == 3)
                return ALIVE;
        }
        return DEAD;
    }

}

// Classe principal com o main()
public class ED088 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Ler linhas, colunas e numero de iteracoes
        int rows = in.nextInt();
        int cols = in.nextInt();
        int n = in.nextInt();
        // System.out.println(n);

        // Criar objecto para conter o jogo e ler estado inicial
        Game g = new Game(rows, cols);
        g.read(in);
        for (int i = 0; i < n; i++) {
            g.iterate();
        }
        g.write();
    }
}
