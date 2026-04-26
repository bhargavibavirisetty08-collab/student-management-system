package Recursion;

public class ReverseWay2 {
    private void reverse(int n){
        if(n==0){
            return ;
        }
        int  rem=n%10;
        System.out.print(n%10);
        reverse (n/10);
    }
    public static void main(String[] args) {
        ReverseWay2 r= new ReverseWay2();
        r.reverse(345);
    }
}
