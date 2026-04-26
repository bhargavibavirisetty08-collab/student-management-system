package TwoPointer;

import java.util.Arrays;

public class TwoSumII {
    private int[] getSum(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        while(start!=end){
            int sum = arr[start]+arr[end];
            if(sum == target){
                return new int[]{start,end};
            }
            else if (sum>target){
                end--;
            }else{
                start++;
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int[] num = {2,7,11,15};
        TwoSumII t = new TwoSumII();
        System.out.println(Arrays.toString(t.getSum(num,18)));
    }
}
