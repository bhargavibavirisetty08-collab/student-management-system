package SlidingWindow;

import java.util.ArrayList;
import java.util.HashSet;

public class MaxOFDistinct {
    private int getMaxValue(int[] arr,int k){
        HashSet<Integer> set = new HashSet<>();
        int max=0;int left =0;int curSum=0;
        for(int right=0;right<=arr.length-1;right++){
            while(set.contains(arr[right]) || set.size()==k){
                curSum-=arr[left];
                set.remove(arr[left]);
                left++;
            }
            set.add(arr[right]);
            curSum+=arr[right];
            if(set.size()==k) {
                max = Math.max(curSum, max);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {1,5,4,2,9,9,9};
        MaxOFDistinct m = new MaxOFDistinct();
        System.out.println( m.getMaxValue(nums,3));
    }
}
