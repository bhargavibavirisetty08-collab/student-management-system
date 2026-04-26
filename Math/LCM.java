package Math;

public class LCM {
    static int getGcd(int a ,int b){
        if(b==0){
            return a;
        }
        return getGcd(b,a%b);
    }
    static int lcm(int m ,int n){
        return (m*n)/getGcd(m,n);
    }
    public static void main(String[] args) {

        System.out.println(lcm(8,6));
    }
}
