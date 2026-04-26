package Math;

public class Prime {
    private boolean checkPrime(int num){
        if(num<=1){
            return false;
        }
        else {
            for (int i = 2; i <num;i++){
                if(num%i==0){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Prime p = new Prime();
        System.out.println(p.checkPrime(87));
    }
}
