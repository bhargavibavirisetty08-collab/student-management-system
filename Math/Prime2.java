package Math;

public class Prime2 {
    private boolean checkPrime(int n){
        if(n<=1){
            return false;
        }
        int i=2;
        while(i*i<=n){
            if(n%i==0){
                return false;
            }
            i++;
        }
        return true;
    }
    public static void main(String[] args) {
        Prime2 p = new Prime2();
        System.out.println(p.checkPrime(97));
    }
}
