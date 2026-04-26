package BitManipulation;

public class NoOfSetBits2 {

    public static void main(String[] args) {
        int n=3;
        System.out.println(Integer.toBinaryString(n)); // binary representation of a number
        int count =0;
        while(n>0){
            count++;
           n= n-(n&-n); // two formulas gives an answer
            //n = n&n-1;
        }
        System.out.println(count);
    }
}
