package BitManipulation;

public class FinddigitsInBinary {
    public static void main(String[] args) {
        int n=32;
        int count =0;
        while(n!=0){
            count++;
            n= n>>1;

        }
        System.out.println(count);
        // this formula for any base
        int num = 3456;
        int base =2;
        int ans = (int)(Math.log(num)/Math.log(base))+1;
        System.out.println(ans);
    }
}
