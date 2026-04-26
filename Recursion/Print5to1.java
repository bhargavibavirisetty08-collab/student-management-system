package Recursion;

public class Print5to1 {
    private void print(int n){
        if(n==0){
            return;
        }
        System.out.println(n);  //5 4 3 2 1
        print(n-1);
    }
    public static void main(String[] args) {
        Print5to1 p = new Print5to1();
        p.print(5);
    }
}
