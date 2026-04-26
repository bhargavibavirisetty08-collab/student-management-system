package SortingTechniques;

import java.util.Arrays;

public class MissingPositiveNumber {
    void  swap(int[] a , int i , int j){
        int temp=a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private int FindMissing(int[] arr){
//        int start =0;
//        while(start <= arr.length-1){
//            if((arr[start] == start+1) || ((arr[start]<=0) || (arr[start]>arr.length)))
//            {
//                start++;
//            }
//            else {
//                swap(arr,arr[start]-1,start);
//            }
//        }
//        for(int i =0;i<arr.length;i++){
//            if(arr[i] != i+1){
//                return i+1;
//            }
//        }
//        return -1;
        int start =0;
        while(start <= arr.length-1){
            if((arr[start] == start+1) || ((arr[start]<=0) || (arr[start]>=arr.length-1)))
            {
                start++;
            }else if((arr[start]>arr.length)){
                return 1;
            }
            else {
                swap(arr,arr[start]-1, start);
            }
        }
        for(int i =0;i<arr.length;i++){
            if(arr[i] != i+1){
                return i+1;
            }
        }
        return arr.length+1;

    }
    public static void main(String[] args) {
        MissingPositiveNumber  m = new MissingPositiveNumber();
        int[] num = {1,2,0};
        System.out.println(m.FindMissing(num));
    }
}
