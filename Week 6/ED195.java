public class ED195 {


    public static boolean balanced(String s) {
        MyStack<Character> pi = new LinkedListStack<Character>();
        char aux;
        for (int i = 0; i < s.length(); i++) {
            aux = s.charAt(i);
            if (aux == '(' || aux == '[') {
                pi.push(aux);
            }
            if (aux == ')') {
                if (pi.isEmpty())
                    return false;
                else if (pi.top() == '(') {
                    pi.pop();
                } else {
                    return false;
                }
            } else if (aux == ']') {
                if (pi.isEmpty())
                    return false;
                else if (pi.top() == '[') {
                    pi.pop();
                } else {
                    return false;
                }
            }
        }
        return pi.isEmpty();
    }
}