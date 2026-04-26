package Recursion;

public class factorial {
    private int fact(int n){
        if(n<2){
            return n;
        }
        return n*fact(n-1);
    }
    public static void main(String[] args) {
        factorial f =new factorial();
        System.out.println(f.fact(5));
    }
}
