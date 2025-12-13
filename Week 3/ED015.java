
/* ------------------
   Est. Dados 24/25
   Sopa de letras: nesta versão, apenas são lidas na vertical ou horizontal

   Direções:
    --> (0,1) fixa a linha soma 1 à coluna
    <-- (0,-1) fixa à coluna e vai para trás
    "cima" (1,0) fixa a coluna e soma 1.
    "baixo" (-1,0) fixa a coluna e desce 1

    ---------------------------------------------
    passo 1: coloco as palvras num vetor
    passo 2: dada uma palavra de um vetor, vou coluna a coluna até encontrar a primeira ou última letra da palavra
             - se encontrar a primeira letra, vou verificar quais direções são válidas.
               se por ex., estivermos na 1º coluna não é possível ir para a esquerda.
    passo 3: encontrada a direção em que está a palavra faço uma cópia para um novo puzzle
             *se não encontrar a palavra, continua a procurar até à última coluna
 */
import java.util.Scanner;

class Puzzle {
    int rows, cols;
    char puzzle[][];

    Puzzle(int r, int c) {
        rows = r;
        cols = c;
        puzzle = new char[rows][cols];
    }

    /*
     * 
     * public boolean isValid(int pos, byte dir) {// esta função verifica se o
     * indice é válido
     * if (dir == 0) { // significa que é o indice da linha
     * if (pos > 0 && pos < rows) {
     * return true;
     * }
     * } else {
     * if (pos > 0 && pos < cols) {
     * return true;
     * }
     * }
     * return false;
     * }
     * 
     * public void copyword(Puzzle p, String word, int[] ind, int inclin, int
     * inccol) {
     * int size = word.length();
     * int lin = ind[0];
     * int col = ind[1];
     * for (int i = 0; i < size; i++) {
     * p.puzzle[lin][col] = word.charAt(i);
     * lin += inclin;
     * col += inccol;
     * }
     * }
     */

    public boolean isValid(int l, int c) { // esta função é usada noutra
        boolean checkline = (l >= 0) && (l < rows);
        boolean checkcol = (c >= 0) && (c < cols);
        if (checkline && checkcol) {
            return true;
        }
        return false;
    }

    public void writeWord(int[] dir, Puzzle n, String w, int coord[]) { // funciona bem
        /*
         * dir é um array de tamanho 2 que representa a direção:
         * [0,1]: direita; [0,-1]:esquerda; [1,0]: cima e [-1,0]: baixo
         */
        // char[][] p = n.puzzle;
        int l = coord[0];
        int c = coord[1];
        int incl = dir[0];
        int incc = dir[1];
        int size = w.length();
        for (int i = 0; i < size; i++) {
            // System.out.println("(" + x + "," + y + ")");
            n.puzzle[l][c] = w.charAt(i);
            l += incl;
            c += incc;
        }

    }

    public int[] findWord(String w, int[] coords) { // esta função é usada noutra
        /*
         * esta função retorna a direção em que podemos encontrar a palavra, se não for
         * possível encontrar em nenhuma direção então retorna null
         */
        int[][] dirs = { { 0, 1 }/* direita */,
                { 0, -1 }/* esquerda */,
                { -1, 0 }/* baixo */,
                { 1, 0 } /* cima */ };
        int l = coords[0];
        int c = coords[1];
        int size = w.length();
        for (int i = 0; i < 4; i++) {
            int incl = dirs[i][0];
            int incc = dirs[i][1];
            int maxl = l + incl * (size - 1);
            int maxc = c + incc * (size - 1);
            if (isValid(maxl, maxc)) {
                if (wordThere(w, incl, incc, l, c)) {
                    return dirs[i];
                }
            }
        }
        return null;
    }

    public boolean wordThere(String w, int incl, int incc, int l, int c) { // funciona bem e é de uso noutra função
        // sabendo a direção vê se a palavra lá está
        int size = w.length();
        for (int i = 0; i < size; i++) {
            if (puzzle[l][c] != w.charAt(i))
                return false;
            l += incl;
            c += incc;
        }
        return true;
    }

    public int[][] findIndex(String w) {
        int[][] res = new int[2][2];
        // esta função retorna as coordenadas onde começa a palavra que procuramos no
        // puzzle e a direção
        // se a palavra não estiver no puzzle significa que não há indice logo retorna
        // null
        char in = w.charAt(0);
        // char fin = w.charAt(w.length() - 1);
        int[] coords = new int[2]; // vetor com as coordenadas onde a palavra começa
        int dir[] = new int[2]; // vetor com a direção em que se encontra a palavra
        for (int c = 0; c < cols; c++) {
            for (int l = 0; l < rows; l++) {
                if (puzzle[l][c] == in) {
                    coords[0] = l;
                    coords[1] = c;
                    dir = findWord(w, coords);
                    if (dir != null) {
                        res[0] = coords;
                        res[1] = dir;
                        return res;
                    }
                    // precisamos de uma função que procure em cada direção se a palavra existe, se
                    // sim, retorna a direção em que existe
                    // caso contrário retorna null
                }
            }
        }
        return null; // retorna null se a palavra não estiver no puzzle
    }

    public void fillnewp(Puzzle n) { // funciona bem
        int lin = n.rows;
        int col = n.cols;
        for (int y = 0; y < lin; y++) {
            for (int x = 0; x < col; x++) {
                n.puzzle[y][x] = '.';
            }
        }
    }

    public void game(String[] words) {
        // esta função vai verificar se cada palavra está ou não no puzzle, se a palavra
        // estiver no puzzle deve ser acrescentada a n
        // a função que vai verificar se uma palavra foi encontrada ou não, retorna true
        // se naquela direção (cima, baixo direita ou esquerda) houver a palavra
        Puzzle n = new Puzzle(rows, cols);
        int size = words.length;
        fillnewp(n);
        for (int i = 0; i < size; i++) {
            String w = words[i];
            // System.out.println(w);
            int[][] res = findIndex(w);
            if (res != null) {
                // System.out.println(w);
                int[] coords = res[0];
                int[] dir = res[1];
                writeWord(dir, n, w, coords);
            }

        }
        puzzle = n.puzzle; // coloca o puzzle para apontar para um novo em que só aparecem as palavras
                           // marcadas
    }

    public void read(Scanner in) {
        for (int l = 0; l < rows; l++) {
            puzzle[l] = in.nextLine().toCharArray();
        }
    }

    public void write() {
        for (int l = 0; l < rows; l++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(puzzle[l][c]);
            }
            System.out.println();
        }
    }
}

public class ED015 {
    /*
     * inputs: linhas, colunas
     * o puzzle(matrix linhas*colunas) 1<=lins,cols<=100
     * num: nº de palavras a encontrar 1<=num<=50
     * palavras
     * a leitura de inputs termina com 0 0, ou seja,
     * se linhas==0 || colunas==0 não lê mais
     * 
     */
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int lin, col;
        String[] words;
        // Puzzle p;
        lin = stdin.nextInt(); // lê o número de linhas que terá o puzzle
        col = stdin.nextInt(); // lê o número de colunas que terá o puzzle
        int count = 1;
        do {
            stdin.nextLine();
            Puzzle p = readGame(stdin, lin, col); // funciona bem
            // System.out.println(p.rows + " " +p.cols);
            words = readWords(stdin); // funciona bem
            System.out.println("Input " + "#" + count);
            p.game(words);
            p.write();
            // System.out.println("#" + count);
            // falta a função que modifica o puzzle.
            // p.write();
            lin = stdin.nextInt();
            col = stdin.nextInt();
            ++count;
            // stdin.nextLine();
            // passa para a linha seguinte para que possamos começar a ler o puzzle
        } while (!((lin == 0) || (col == 0)));
        stdin.close();
    }

    public static String[] readWords(Scanner in) {
        int n_words = in.nextInt();
        String[] aux = new String[n_words];
        // aux = new String[n_words]; // vetor de String com todas as palavras
        in.nextLine();
        for (int i = 0; i < n_words; i++) {
            aux[i] = in.nextLine(); // ler as palavras
        }
        return aux;
    }

    public static Puzzle readGame(Scanner in, int lin, int col) {
        // System.out.println(lin + " " + col);
        Puzzle p = new Puzzle(lin, col);
        p.read(in);
        // p.write();
        return p;
    }
    /*
     * outputs: "Input #n" n representado o número de input
     * sopa de letras
     */
}