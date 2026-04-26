package Recursion;

public class printBoth {
    private void print(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        print(n - 1);
        System.out.println(n); //1 2 3 4 5

    }
    public static void main(String[] args) {
        printBoth p =new printBoth();
        p.print(5);
    }
}
