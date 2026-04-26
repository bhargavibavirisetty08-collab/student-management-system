package Recursion;

public class print1ton {
    private void print(int n) {
        if (n == 0) {
            return;
        }
        print(n - 1);
        System.out.println(n); //1 2 3 4 5

    }
    public static void main(String[] args) {
        print1ton p =new print1ton();
        p.print(5);
    }
}
