package SortingTechniques;

import java.util.Arrays;

public class CyclicSort {
    private int[] sortthearr(int[] arr){
        int start =0;
        int end = arr.length-1;
        while(start<end){
            if(start+1 == arr[start]){
                start++;
            }else{
                int temp = arr[arr[start]-1];
                arr[arr[start]-1]=arr[start];
                arr[start] =temp;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] num = {7,3,6,2,8,1,4,5};
        System.out.println(Arrays.toString(num));
        CyclicSort c = new CyclicSort();
        System.out.println(Arrays.toString(c.sortthearr(num)));
    }
}
