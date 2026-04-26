package Recursion;

public class PassingOfnumber {
    private void pass(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        pass(--n); //It prints 5 4 3 2 1
       // pass(n--);     // its give stackOver flow because n-- pass n first after subtract every time it passes n only
    }
    public static void main(String[] args) {
        PassingOfnumber p = new PassingOfnumber();
        p.pass(5);
    }
}
