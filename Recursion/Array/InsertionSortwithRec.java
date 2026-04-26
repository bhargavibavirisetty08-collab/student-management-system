package Recursion.Array;

import java.util.Arrays;

public class InsertionSortwithRec {
    static int[] insert(int[] arr,int i,int j,int temp){
        if(i==arr.length){
            return arr;
        }
        if(j>=0 && arr[j]>temp){
            arr[j+1] = arr[j];
            return insert(arr,i,j-1,temp);
        }
        arr[j+1] =temp;
        if(i+1<arr.length) {
            return insert(arr, i + 1, i, arr[i + 1]);
        }
        return arr;
    }
//    static int[] insert(int[] arr){
//        for(int i=1;i<arr.length;i++){
//            int temp = arr[i];
//            int j=i-1;
//            while(j>=0 && arr[j]>temp){
//                  arr[j+1] = arr[j];
//                  j--;
//            }
//          arr[j+1] = temp;
//        }
//        return arr;
//    }
    public static void main(String[] args) {
        int[] nums={4,3,2,1};
        System.out.println(Arrays.toString(insert(nums,1,0,nums[1])));
    }
}
