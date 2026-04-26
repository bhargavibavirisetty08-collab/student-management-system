package Math;

public class factor {
    public static void main(String[] args) {
        int n = 10000;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                System.out.print(i+" ");
            }
        }
    }
}
