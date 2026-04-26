package Recursion.Array;

import java.util.Arrays;

public class BubbleSort {
    static int[] sort(int[] arr,int i,int j){
        if(i==arr.length-1){
            return arr;
        }
        if(j==arr.length-i-1) {
            return sort(arr,i+1,0);
        }
        if(arr[j]>arr[j+1]){
            int temp = arr[j];
            arr[j]=arr[j+1];
            arr[j+1] = temp;
        }
        return sort(arr,i,j+1);
    }
    public static void main(String[] args) {
        int[] nums={9,8,7,6,99,76,5,45,23,12,65,76};
        System.out.println(Arrays.toString(sort(nums,0,1)));
    }
}
