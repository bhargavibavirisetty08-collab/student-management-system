package Recursion;

public class SumOfDigits {
    private int getSum(int n){
        if(n==0){
            return n;
        }
       int ans =  n%10;
        return ans +getSum(n/10) ;
    }
    public static void main(String[] args) {
        SumOfDigits s = new SumOfDigits();
        System.out.println(s.getSum(134234));
    }
}
