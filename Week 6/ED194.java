public class ED194{
    public static void reverse(MyStack<Integer> s, int n){
        int vec[]=new int[n];
        for(int i=0;i<n;i++){
            vec[i]=s.pop();
        }
        for(int i=0;i<n;i++){
            s.push(vec[i]);
        }
        //System.out.println(s);
    }
}