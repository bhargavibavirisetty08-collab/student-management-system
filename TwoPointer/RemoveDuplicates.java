package TwoPointer;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RemoveDuplicates {
    private int removeDup(int[] arr){
        //for k;
        int start = 0;
        int end = 1;
        int k=1;
        while (end <= arr.length-1) {
            if (arr[start] == arr[end]) {
                end++;
            } else if (arr[start] != arr[end]) {
                start = end;
                k++;
            }
        }
        return k;
    }
    private int[] getarray(int[] arr){
        // for arr
        int start = 0;
        for(int end =1;end<arr.length;end++) {
            if (arr[start] != arr[end]) {
                start++;
                arr[start] = arr[end];
            }
        }
//        while (end <=arr.length-1) {
//            if (arr[start] == arr[end]) {
//                end++;
//            } else if (arr[start] != arr[end]) {
//                start++;
//                arr[start] = arr[end];
//            }
//        }
       return arr;
    }
    public static void main(String[] args) {
        int[] num ={1,1,1,2,3,3};
        RemoveDuplicates r = new RemoveDuplicates();
        System.out.println(r.removeDup(num));
       // System.out.println(r.getarray(num));
        System.out.println(Arrays.toString(r.getarray(num)));
    }
}
