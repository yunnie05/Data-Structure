import java.util.Scanner;

public class ED007 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt(); // num: número de expressões a analisar
        in.nextLine();
        String aux;
        String exp[];
        for (int i = 0; i < num; i++) {
            aux = in.nextLine();
            exp = aux.split("");
            // write(exp);
            check(exp);
        }
        in.close();
    }

    public static void check(String[] vec) {
        MyStack<String> pilha = new LinkedListStack<String>();
        int size = vec.length;
        for (int i = 0; i < size; i++) {
            String simb = vec[i];
            if (simb.equals("(") || simb.equals("[")) {
                pilha.push(simb);
            } else if (simb.equals(")")) {
                if ((pilha.size() == 0) || !(pilha.top().equals("("))) {
                    System.out.println("Erro na posicao " + i);
                    return;
                }
                pilha.pop();
            } else if (simb.equals("]")) {
                if ((pilha.size() == 0) || !(pilha.top().equals("["))) {
                    System.out.println("Erro na posicao " + i);
                    return;
                }
                pilha.pop();
            }
        }
        if (!pilha.isEmpty()) {
            System.out.println("Ficam parenteses por fechar");
            return;
        }
        System.out.println("Expressao bem formada");
    }

    public static void write(String vec[]) {
        System.out.print("{");
        int size = vec.length;
        for (int i = 0; i < size; i++) {
            System.out.print(vec[i]);
            if (i < size - 1)
                System.out.print(",");
        }
        System.out.println("}");
    }
}