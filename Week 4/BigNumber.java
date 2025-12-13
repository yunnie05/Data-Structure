import java.lang.Math;

class BigNumber {

    int[] num;
    int size;

    BigNumber(String n) {
        size = n.length();
        num = new int[size];
        int p = size - 1;
        for (int i = 0; i < size; i++, p--) {
            char k = n.charAt(p);
            num[i] = toInt(k);
        }
    }

    public int toInt(char k) {
        switch (k) {
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                return 0;
        }
    }

    public boolean equals(BigNumber n) {
        if (size != n.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (num[i] != n.num[i])
                return false;
        }
        return true;
    }

    public String toString() {
        String res = "";
        for (int i = num.length - 1; i >= 0; i--) {
            res += num[i];
        }
        return res;
    }

    // operações
    public BigNumber add(BigNumber n) {
        BigNumber res; // variável de retorno
        int tam = Math.max(size, n.size); // o tamanho que o número resultante da soma vai assumir
        String aux = "";
        int stop = Math.min(size, n.size); // a paragem do ciclo que faz a soma
        int[] ref; // apontador para o maior número
        if (size > n.size) {
            ref = num;
            // System.out.println("Este é maior " + size);
        } else {
            ref = n.num;
            // System.out.println("Este é maior " + n.size);
        }
        int i = 0;
        int rem = 0;
        for (; i < stop; i++) {
            int v = num[i] + n.num[i] + rem;
            // System.out.print(num[i] + "," + n.num[i] + ": " + v + " ");
            aux = (v % 10) + aux;
            // System.out.print("soma: " + (v % 10) + " ");
            rem = v / 10;
            // System.out.println("next: " + rem);
        }
        // System.out.println("i: " + i + " tamanho da soma: " + tam);
        if (i < tam) {
            aux = fill(aux, i, ref, rem);
        } else if (rem != 0) {
            aux = rem + aux;
        }
        res = new BigNumber(aux);
        return res;
    }

    public String fill(String aux, int ind, int[] vec, int rem) {
        for (int i = ind; i < vec.length; i++) {
            int v = vec[i] + rem;
            aux = (v % 10) + aux;
            rem = v / 10;
        }
        if (rem != 0)
            aux = rem + aux;
        return aux;
    }

    public BigNumber multiply(BigNumber n) {
        // BigNumber aux= new BigNumber("0");
        BigNumber res = new BigNumber("0");
        // String r = "";
        BigNumber aux;
        for (int i = 0; i < n.size; i++) {
            int k = n.num[i];
            String s = mult(k, num, i);
            aux = new BigNumber(s);
            // System.out.println(aux);
            res = res.add(aux);
        }
        // USystem.out.println(res);
        return res;
    }

    public String mult(int k, int[] num, int ind) {
        String res = "";
        while (ind-- > 0) {
            res += "0";
        }
        int rem = 0;
        for (int i = 0; i < num.length; i++) {
            int v = num[i] * k + rem;
            res = (v % 10) + res;
            rem = v / 10;
        }
        if (rem != 0)
            res = rem + res;
        return res;
    }

}