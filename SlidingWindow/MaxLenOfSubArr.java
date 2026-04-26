package SlidingWindow;

import java.util.HashSet;

public class MaxLenOfSubArr {
    private int getArraylen(int[] arr,int target){
        int left=0;
        int minlen =Integer.MAX_VALUE;int curSum=0;
        int curlen=Integer.MAX_VALUE;
        for(int right =0;right<arr.length;right++){
            curSum+=arr[right];
            while(target <= curSum){
                curlen = right-left+1;
                curSum-=arr[left];
                left++;
            }
            minlen = Math.min(curlen,minlen);
        }
        return( minlen == Integer.MAX_VALUE)?0:minlen;
    }
    public static void main(String[] args) {
        int[] nums={2,3,1,2,4,3};
        MaxLenOfSubArr m = new MaxLenOfSubArr();
        System.out.println(m.getArraylen(nums,7));
    }
}
