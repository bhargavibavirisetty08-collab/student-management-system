package Recursion;

public class ReverseOfNumber {
    int sum=0;
    private int reverse(int n){
        if(n==0){
            return 1;
        }
         int  rem=n%10;
         sum = sum*10+rem;
//        System.out.print(n%10);
        reverse (n/10);
        return sum;
    }
    public static void main(String[] args) {
        ReverseOfNumber r = new ReverseOfNumber();
        System.out.println(r.reverse(837));

    }
}
