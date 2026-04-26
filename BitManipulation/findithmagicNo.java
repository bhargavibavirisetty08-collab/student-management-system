package BitManipulation;

public class findithmagicNo {

    private int getMagicNo(int num){
        int ans =0;
        for(int bit=0;bit<32;bit++){
            if(((num>>bit)&1)==1){
                ans+=Math.pow(5,bit+1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        findithmagicNo f = new findithmagicNo();
        System.out.println(f.getMagicNo(5));
        // another method with pow method
        int ans =0;int base=5;
        int n=5;
        while(n>0){
           int last= n&1;
              ans= ans + last*base;
              n=n>>1;
              base = base*5;
        }
        System.out.println(ans);
    }
}
