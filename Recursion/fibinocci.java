package Recursion;

public class fibinocci {
    private int fib(int n){
        if (n<2){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
    public static void main(String[] args) {
        fibinocci f = new fibinocci();
        int ans = f.fib(4);
        System.out.println(ans);
    }
}
