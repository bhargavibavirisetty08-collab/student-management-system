package Recursion.Array;

import java.util.ArrayList;
import java.util.List;

public class LinearSearchAtmultiOccurence {
   static List<Integer> list= new ArrayList<>();
    static List<Integer> search(int[] arr, int target, int start){
        if(start==arr.length){
            return list;
        }
        if(arr[start]==target){
            list.add(start);
         //   return search(arr, target, start + 1);
        }
       // else {
            return search(arr, target, start + 1);
       // }
    }

    static List<Integer> search1(int[] arr, int target, int start,List<Integer>list){
        if(start==arr.length){
            return list;
        }
        if(arr[start]==target && start!=arr.length){
            list.add(start);
        }
            return search1(arr, target, start + 1,list);
    }
    public static void main(String[] args) {
        int[] nums = {6,3,3};
        System.out.println(search(nums,3,0));
        System.out.println(search1(nums,3,0,new ArrayList<>()));
    }
}
