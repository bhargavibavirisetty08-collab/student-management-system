package Recursion;

public class DigitOfProduct {
    private int getProduct(int n){
        if(n==0){
            return 1;
        }
        int ans =  n%10;
        return ans *getProduct(n/10) ;
    }
    public static void main(String[] args) {
        DigitOfProduct d = new DigitOfProduct();
        System.out.println(d.getProduct(2034));
    }
}
