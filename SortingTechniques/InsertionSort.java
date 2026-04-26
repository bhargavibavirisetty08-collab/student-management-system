package SortingTechniques;

import java.util.Arrays;

public class InsertionSort {
    private int[] SortingNum(int[] arr){
        for(int i=1;i<arr.length;i++){
            int temp = arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        return arr;
    }
    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        int[] nums = {7,5,9,4,7,-3};
        System.out.println(Arrays.toString(is.SortingNum(nums)));
    }
}
