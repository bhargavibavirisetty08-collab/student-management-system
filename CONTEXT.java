import java.util.concurrent.Callable;

public class CONTEXT {
    public int largestPrime(int n) {
        int j = 2;
        int sum = 0;
        while (j <= n) {
            int count = 0;
            for (int i = 2; i <= n; i++) {
                if (j % i == 0) {
                    count++;
                }
            }
           // System.out.println(count);
            if (count == 1 && (sum+j) < n) {
                sum += j;
            }
           // System.out.println(sum);
            j++;
        }
        return sum;
    }
    class Solution {
        boolean isPrime(int k){
            int count=0;
            for(int i=2;i<=k;i++){
                count++;
            }
            if(count==1){
                return true;
            }else
            {
                return false;
            }
        }
        public int largestPrime(int n) {
            int j = 2;
            int sum = 0;
            while (j <= n){
                if(isPrime(j) && (sum+j) <=n)
                {
                    sum+=j;
                }
                j++;
            }
            if(isPrime(sum) && sum<=n){
                return sum;
            }
            return sum-j;
        }
    }

    public static void main(String[] args) {
        CONTEXT c = new CONTEXT();
        int[] arr = {4,4,5};
        System.out.println((c.largestPrime(20)));
    }
}
