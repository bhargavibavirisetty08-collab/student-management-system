package Recursion;

public class ReverseWay3 {
    private int reverse(int n){
        int digit= (int)(Math.log10(n))+1;
        return helper(n,digit);
    }
    private int helper(int n ,int digit){
        if(n%10==0){
            return n;
        }
        int rem =n%10;
        return rem*(int)Math.pow(10,digit-1) + helper(n/10,digit-1);
    }
    public static void main(String[] args) {
        ReverseWay3  r = new ReverseWay3();
        System.out.println(r.reverse(87654));      //o(log n)
    }
}
