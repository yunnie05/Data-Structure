import java.util.Scanner;
import java.util.LinkedList;

public class ED172 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BSTMap<String, Integer> map = new BSTMap<>();
        readLine(map, in);
        LinkedList<String> keys = map.keys();
        for (String i : keys)
            System.out.println(i + ": " + map.get(i));
    }

    public static void readLine(BSTMap<String, Integer> map, Scanner in) {
        while (in.hasNext()) {
            String key = in.next();
            LinkedList<String> keys = map.keys();
            Integer val = map.get(key);
            if (val == null)
                map.put(key, 1);
            else {
                int n = map.get(key);
                map.put(key, n + 1);
            }
        }
    }
}