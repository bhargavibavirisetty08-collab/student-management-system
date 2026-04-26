package Math;

public class GcdByEclideanAlogorithm {
    // hcf and gcd are same
    private int getGcd(int a ,int b){
        if(b==0){
            return a;
        }
        return getGcd(b,a%b);
    }
    public static void main(String[] args) {
        GcdByEclideanAlogorithm g = new GcdByEclideanAlogorithm();
        System.out.println(g.getGcd(15,15));
    }
}
