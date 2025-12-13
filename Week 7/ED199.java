import java.util.Scanner;
import java.lang.Math;

public class ED199 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numArc = in.nextInt();
        boolean[] arcs = new boolean[numArc];
        int pos = in.nextInt() - 1;
        int numInst = in.nextInt();
        // in.nextLine();
        String ar = in.next();
        fill(arcs, ar, numArc);
        int count = 0;
        int pesq = pos, pdir = pos;
        for (int i = 0; i < numInst; i++) {
            // in.nextLine();
            String dir = in.next();
            int num = in.nextInt();
            if (dir.equals("E")) {
                pesq = Math.min(pesq, pos - num);
                pos -= num;
            } else {
                pdir = Math.max(pdir, pos + num);
                pos += num;
            }
        }
        pos = pesq;
        while (pos <= pdir) {
            if (arcs[pos])
                count++;
            pos++;
        }
        // System.out.println("pe: " + pesq + " pdir: " + pdir);
        // System.out.println(dir + " : " + pos);
        System.out.println(count);
    }

    public static void fill(boolean[] vec, String n, int num) {
        for (int i = 0; i < num; i++) {
            char aux = n.charAt(i);
            if (aux == 'T') {
                vec[i] = true;
                continue;
            }
            vec[i] = false;
        }
    }
}