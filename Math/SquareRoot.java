package Math;

public class SquareRoot {
    private double getsquare(int num,int p){
        int left=0;
        int right=num;
        double root=0;
        while(left<=right) {
            int mid = (left + right) / 2;
            if (mid * mid == num) {
                root = mid;
            }
            if (mid * mid > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
            double incr = 0.1;
            for (int i = 0; i < p; i++) {
                while (root * root <= num) {
                    root = root+incr;
                }
                root = root-incr;
                incr = incr/ 10;
            }

        return root;
    }
    public static void main(String[] args) {
        SquareRoot s = new SquareRoot();
        System.out.println(s.getsquare(40,3));
    }
}
