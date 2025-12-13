import java.util.Scanner;
import java.lang.Math;

public class ED029 {
    /*-Sabendo inicialmente a hora prevista, em minutos, queremos saber o atraso
      -procura-se o avião que está a mais tempo à espera
      -se houver empate entre o tempo que um avião leva a aterrar e outro que vai decolar, 
       prioriza-se o que vai aterrar, logo a seguir decola o outro
      -tempo de decolagem ou aterragem: 1 min por processo*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num_cas = in.nextInt();
        // System.out.println(num_cas);
        in.nextLine();
        for (int i = 0; i < num_cas; i++) {
            int num_lev = in.nextInt();
            int num_ater = in.nextInt();
            // ler os aviões que aterram e decolam
            MyQueue<Plane> levanta = new LinkedListQueue<Plane>();
            MyQueue<Plane> aterra = new LinkedListQueue<Plane>();
            read_planes(levanta, in, num_lev);
            read_planes(aterra, in, num_ater);
            manage_planes(levanta, aterra);
            System.out.println(num_lev + " " + num_ater);
            write(levanta);
            write(aterra);
            // System.out.println(num_cas + ": :" + num_lev + ": :" + num_ater);
        }
        in.close();
    }

    public static void manage_planes(MyQueue<Plane> levanta, MyQueue<Plane> aterra) {
        int t = 1;
        int countlev = 0, countat = 0;
        int timeat = 0;
        int timelev = 0;
        int levsize = levanta.size();
        int atsize = aterra.size();
        int num_lev = levsize; // número de aviões que levanta voo, fixo
        int num_at = atsize;
        // int stop = Math.max(levsize, atsize);
        // System.out.print("valores de levantamento: ");
        while ((countlev < num_lev) || (countat < num_at)) {
            // System.out.print(levsize + ":");
            Plane pl_lev = levanta.first(), pl_at = aterra.first();
            if (levsize > 0) {
                // pl_lev = levanta.dequeue();
                timelev = pl_lev.time();
            }
            if (atsize > 0) {
                // pl_at = aterra.dequeue();
                timeat = pl_at.time();
            }
            if (levsize > 0 && atsize > 0) {
                if (t < Math.min(timeat, timelev)) {// precisamos do mínimo, porque vai ser nessa hora que sai o
                    t = Math.min(timeat, timelev);
                }
                if (timelev == timeat) {
                    pl_at = aterra.dequeue();
                    pl_lev = levanta.dequeue();
                    t = move_plane(aterra, pl_at, t);
                    t = move_plane(levanta, pl_lev, t);
                    levsize--;
                    atsize--;
                    countlev++;
                    countat++;
                } else if (timelev < timeat) {
                    if (t < timelev)
                        t = timelev;
                    pl_lev = levanta.dequeue();
                    levsize--;
                    countlev++;
                    t = move_plane(levanta, pl_lev, t);
                    // System.out.print(pl_lev.name() + " levantou voo" + "---");
                    if ((levsize > 0) && pl_at.time() > levanta.first().time()) {
                        /*
                         * System.out.println("o tempo de " + levanta.first().name() + ": " +
                         * levanta.first().time()
                         * + " está atrasado" + "------" + "tempo atual: " + t + "faltam " + levsize
                         * + " levantamentos" + " ... aterros" + atsize);
                         */
                        continue;
                    }
                    // if (levsize == 0)
                    // System.out.println("end");
                    if (t < timeat)
                        t = timeat;
                    pl_at = aterra.dequeue();
                    atsize--;
                    countat++;
                    // System.out.println(atsize + "levs: " + levsize);
                    t = move_plane(aterra, pl_at, t);
                } else if (timeat < timelev) {
                    if (t < timeat)
                        t = timeat;
                    pl_at = aterra.dequeue();
                    atsize--;
                    countat++;
                    t = move_plane(aterra, pl_at, t);
                    if (pl_lev.time() >= aterra.first().time())
                        continue;
                    if (t < timelev)
                        t = timelev;
                    pl_lev = levanta.dequeue();
                    levsize--;
                    countlev++;
                    t = move_plane(levanta, pl_lev, t);
                }
                // atsize--;
                // levsize--;
                // continue;
            } else if (levsize > 0) {
                if (t < timelev)
                    t = timelev;
                pl_lev = levanta.dequeue();
                t = move_plane(levanta, pl_lev, t);
                levsize--;
                countlev++;
            } else if (atsize > 0) {

                if (t < timeat)
                    t = timeat;
                pl_at = aterra.dequeue();
                t = move_plane(aterra, pl_at, t);
                atsize--;
                countat++;
            }
        }
        // System.out.println(";");
    }

    public static int move_plane(MyQueue<Plane> action, Plane aviao, int curtime) {
        // curtime += 1;
        int planetime = aviao.time();
        int newtime = 0;
        if (planetime < curtime)
            newtime = curtime - planetime;
        aviao.setTime(newtime);
        action.enqueue(aviao);
        return (curtime + 1);
    }

    public static void read_planes(MyQueue<Plane> a, Scanner in, int num) {
        for (int i = 0; i < num; i++) {
            String name = in.next();
            int time = in.nextInt();
            if (i < num - 1)
                in.nextLine();
            Plane aux = new Plane(name, time);
            a.enqueue(aux);
        }
    }

    public static void write(MyQueue<Plane> a) {
        Plane aux;
        int size = a.size();
        for (int i = 0; i < size; i++) {
            aux = a.dequeue();
            System.out.println(aux.name() + " " + aux.time());
        }
    }

}

class Plane {
    private String name;
    private int time;

    Plane(String n, int m) {
        name = n;
        time = m;
    }

    public String name() {
        return name;
    }

    public int time() {
        return time;
    }

    public void setTime(int t) {
        time = t;
    }
}
