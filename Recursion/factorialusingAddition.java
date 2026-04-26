package Recursion;

public class factorialusingAddition {
    private int fact(int n){
        if(n<2){
            return n;
        }
        return n+fact(n-1);
    }
    public static void main(String[] args) {
        factorialusingAddition f = new factorialusingAddition();
        System.out.println(f.fact(5));
    }
}
