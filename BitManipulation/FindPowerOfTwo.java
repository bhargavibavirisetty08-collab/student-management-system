package BitManipulation;

public class FindPowerOfTwo {
    public static void main(String[] args) {
        int n = 128;
        int count =0;
        while(n>0){
            if((n&1)==1){
                count++;
            }
            n=n>>1;
        }
        if(count==1){
            System.out.println("its a power of 2");
        }
        else{
            System.out.println("its not a power of 2");
        }
        // another method
        int num = 0; // for 0 its give power of 2
        if(num!=0) {
            if ((num & num - 1) == 0) {
                System.out.println("its a power of 2");
            } else {
                System.out.println("its not a power of 2");
            }
        }
        else{
            System.out.println("its not a power of 2");
        }
    }
}
