package Recursion.Array;

import java.util.ArrayList;
import java.util.List;

public class LinearSearchAtmultiOccurence2 {
    static ArrayList<Integer> search1(int[] arr, int target, int start){
        ArrayList<Integer>list=new ArrayList<>();
        if(start==arr.length){
            return list;
        }
        if(arr[start]==target ){
            list.add(start);
        }
        ArrayList<Integer> ans = search1(arr, target, start + 1);
        list.addAll(ans);
        return list;
    }
    public static void main(String[] args) {
        int[] nums = {2,4,4};
        System.out.println(search1(nums,4,0));
    }
}
