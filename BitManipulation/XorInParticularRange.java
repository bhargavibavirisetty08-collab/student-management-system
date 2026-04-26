package BitManipulation;

public class XorInParticularRange {
    private int Xor(int num){
        if(num%4==0){
            return num;
        } else if (num%4==1) {
           return 1;
        } else if (num%4==2) {
            return num+1;
        }
        return 0;
    }
    public static void main(String[] args) {
        int a =3;
        int b =9;
        XorInParticularRange x = new XorInParticularRange();
        int ans = x.Xor(a-1)-x.Xor(b);
        System.out.println(ans);
    }
}
