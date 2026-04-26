package Math;

public class PrimesInRange {
    private void checkPrime(int n){
        boolean[] prime = new boolean[n+1];
        for(int i=2;i*i<=n;i++){
            if(!prime[i]){
                for(int j=i*2;j<=n;j+=i){
                    prime[j]=true;
                }
            }
        }
       for(int i=2;i<=n;i++){
           if(!prime[i]){
               System.out.print(i+ " ");
           }
       }
    }
    public static void main(String[] args) {
        PrimesInRange p = new PrimesInRange();
        p.checkPrime(100);

    }
}
