import java.util.Scanner;

public class ED005 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MyStack<Integer> pilha = new LinkedListStack<Integer>();
        int num = in.nextInt();
        in.nextLine();
        int i = 0;
        for (; i < num; i++) {
            // ler cada linha e retornar o resultado da conta;
            String aux = in.nextLine();
            String k[] = aux.split(" ");
            contas(k, pilha);
            // int a = i;
            // System.out.println(aux);

        }
        // System.out.println(i);
        in.close();
    }

    // System.out.println(pilha);
    public static void contas(String k[], MyStack<Integer> pilha) {
        int size = k.length;
        String a;
        boolean op;
        for (int i = 0; i < size; i++) {
            a = k[i];
            char aux = a.charAt(0);
            if (Character.isDigit(aux)) {
                pilha.push(Integer.parseInt(a));
            } else if (!Character.isDigit(aux)) {
                op = selectOp(a, pilha);
                if (op == false) {
                    // System.out.println(pilha);
                    System.out.println("Expressao Incorrecta");
                    return;
                }
                // a = in.next().charAt(0);
            }
        }
        if (pilha.size() > 1) {
            // int s = pilha.size();
            while (pilha.size() != 0) {
                int temp = pilha.pop();
            }
            System.out.println("Expressao Incorrecta");
            return;
        }
        System.out.println(pilha.pop());
    }

    public static boolean selectOp(String c, MyStack<Integer> s) {
        if (s.size() <= 1)
            return false;
        Integer b = s.pop();
        Integer a = s.pop();
        // System.out.println(a + " " + b);
        // if (((a == null) || (b == null)))
        // return false;
        switch (c) {
            case "+": {
                s.push(a + b);
                break;
            }
            case "*": {
                s.push(a * b);
                break;
            }
            case "/": {
                s.push(a / b);
                break;
            }
            default: // quando é menos
            {
                s.push(a - b);
                break;
            }
        }
        // System.out.println(s);
        return true;
    }

}
