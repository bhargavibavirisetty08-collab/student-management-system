package BitManipulation;

public class Power {
    public static void main(String[] args) {
        int base = 2;
        int power = 8;
        int ans =1;
        while(power>0){
            if((power&1)==1){
                ans*=base;
            }
            power=power>>1;
            base*=base;
        }
        System.out.println(ans);
    }
}
