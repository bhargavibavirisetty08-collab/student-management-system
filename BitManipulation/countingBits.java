package BitManipulation;

import java.util.Arrays;

public class countingBits {
    static int[] countBits(int n) {
        int[] arr = new int[n+1];
        for(int i=0;i<=n;i++){
            int count =0;
            int temp=i;
            while(temp>0){
                count++;
                temp=temp&temp-1;
            }
            arr[i]=count;
        }
        return arr;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }
}
