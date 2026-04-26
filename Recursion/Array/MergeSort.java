package Recursion.Array;

import java.util.Arrays;

public class MergeSort {
    static void merge(int[] arr,int lb ,int mid,int ub){
        int[] finalArr = new int[ub-lb+1];
        int i= lb;
        int j =mid+1;
        int k=0;
        while(i<=mid && j<=ub){
            if(arr[i] >= arr[j]){
                finalArr[k] = arr[j];
                j++;
                k++;
            } else if (arr[i]<=arr[j]) {
                finalArr[k]=arr[i];
                i++;
                k++;
            }
        }
        if(i>mid){
            while (j<=ub){
                finalArr[k]=arr[j];
                k++;
                j++;
            }
        } else  {
            while(i<=mid){
                finalArr[k]=arr[i];
                i++;
                k++;
            }
        }
        for(int l=0;l<finalArr.length;l++){
            arr[lb+l] = finalArr[l];
        }
    }
    static void mergesort(int[] arr,int lb,int ub){
        if(lb<ub){
            int mid=(lb+ub)/2;
            mergesort(arr,lb,mid);
            mergesort(arr,mid+1,ub);
         merge(arr,lb,mid,ub);
        }
    }
    public static void main(String[] args) {
        int[] nums={1,8,3,6,2,5,7};
        mergesort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
