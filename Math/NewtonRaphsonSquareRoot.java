package Math;

public class NewtonRaphsonSquareRoot {
    public static void main(String[] args) {
        int n=40;
        double root;
        double x =n;
        while(true){
             root= 0.5*(x + (n/x));
            if(Math.abs(root-x) <0.5){
                break;
            }
            x=root;
        }
        System.out.println(root);
    }
}
