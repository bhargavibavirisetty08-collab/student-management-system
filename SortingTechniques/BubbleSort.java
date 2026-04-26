package SortingTechniques;

import java.util.Arrays;

public class BubbleSort {
    private int[] Sort(int[] arr){
       for(int i=0;i<arr.length;i++){
           for(int j=0;j<arr.length-i-1;j++){
               if(arr[j]>arr[j+1]){ // > is increasing  < is decreasing
                   int temp = arr[j];
                   arr[j]=arr[j+1];
                   arr[j+1] = temp;
               }
           }
       }
       return arr;
    }
    public static void main(String[] args) {
        int[] num = {5,0,1,8,7,6,1};
        BubbleSort b = new BubbleSort();
        System.out.println(Arrays.toString(b.Sort(num)));
    }
}
