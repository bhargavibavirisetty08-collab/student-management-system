package Recursion.Array;

import java.util.Arrays;

public class Quicksort {
    private void swap(int[] arr,int start,int end){
        int temp= arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
    }
    private int getSort(int[] arr,int lb,int ub){
        int start=lb;
        int end = ub;
        int pivot=arr[lb];
        while(start<end){
            while (start<=ub && pivot>=arr[start])
            {
                start++;
            }
            while (pivot<arr[end]) {
                end--;
            }
            if(start<end){

                swap(arr,start,end);

            }
        }
        swap(arr,lb,end);
        return end;
    }
    private void QuickSorting(int[] arr,int lb,int ub){
        if(lb < ub) {
            int mid = getSort(arr, lb, ub);
            QuickSorting(arr, lb, mid - 1);
            QuickSorting(arr, mid+1,ub);
        }
    }
    public static void main(String[] args) {
        int[] nums={6,4,3,2,8,9,1,5};
        Quicksort q = new Quicksort();
        q.QuickSorting(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));

    }
}
