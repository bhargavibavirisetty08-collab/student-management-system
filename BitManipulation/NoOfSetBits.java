package BitManipulation;

public class NoOfSetBits {
    public static void main(String[] args) {
        int n =8;
        int count =0;
        while(n>0){
            if((n&1)==1){
                count++;
            }
            n>>=1;
        }
        System.out.println(count);
    }
}
