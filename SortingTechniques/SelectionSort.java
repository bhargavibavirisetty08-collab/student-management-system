package SortingTechniques;

import java.util.Arrays;

public class SelectionSort {
    private void swap(int[] a,int first,int mini ){
        int temp = a[first];
        a[first] = a[mini];
        a[mini] = temp;
    }
    private int[] Sorting(int[] arr){
        //by using smallest element
        for(int i =0;i<arr.length-1;i++){
            int min = i;
            for(int j = i+1;j<arr.length;j++){
               if(arr[min]>arr[j]){
                  min =j;
               }
            }
            if(min!=i){
                swap(arr,i,min);
            }
        }
        return arr;
        // by using largest element
//        for(int i =arr.length-1;i>=0;i--){
//            int max = i;
//            for(int j = i-1;j>=0;j--){
//                if(arr[max]<arr[j]){
//                    max =j;
//                }
//            }
//            if(max!=i){
//                swap(arr,i,max);
//            }
//        }
//        return arr;
    }
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,2,1};
        SelectionSort ss = new SelectionSort();
        int[] k = ss.Sorting(nums);
        System.out.println(Arrays.toString(ss.Sorting(nums)));
    }
}
