package BitManipulation;

public class reverseOfBit {
    private int getreverse(int n){
        int result=0;
        int bit=31;
        while(n>0){
            int temp=n&1;
            if(temp==1){
                result=result|(1<<bit);
            }
            n=n>>1;
            bit--;
        }
        return result;
    }
    public static void main(String[] args) {
        reverseOfBit r = new reverseOfBit();
        System.out.println(r.getreverse(3));
    }
}
