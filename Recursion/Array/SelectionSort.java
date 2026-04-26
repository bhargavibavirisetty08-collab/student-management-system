package Recursion.Array;

import java.util.Arrays;

public class SelectionSort {
//    static int[] sortarr(int[] arr){
//        for(int i=0;i<arr.length-1;i++){
//            int min =i;
//            for (int j=i+1;j<arr.length;j++){
//                if(arr[j]<arr[i]){
//                    min = j;
//                }
//            }
//            if(min!=i) {
//                int temp = arr[i];
//                arr[i] = arr[min];
//                arr[min] = temp;
//            }
//        }
//        return arr;
 // }
    static void swap(int[] arr,int min,int i){
        int temp= arr[i];
        arr[i]=arr[min];
        arr[min]=temp;
    }
    static int[] sortarr(int[] arr,int i,int j,int min) {
        if(i==arr.length-1)
        {
            return arr;
        }
        if(j==arr.length ) {
            if(min!=i) {
                swap(arr, min, i);
            }
            return sortarr(arr,i+1,i+2,i+1);
        }
        if(arr[min] > arr[j])
        {
               return sortarr(arr,i,j+1,j);
        }else {
            return sortarr(arr,i,j+1,min);
        }
    }
    public static void main(String[] args) {
        int[] nums={4,3,2,1};
        System.out.println(Arrays.toString(sortarr(nums,0,1,0)));
    }
}
