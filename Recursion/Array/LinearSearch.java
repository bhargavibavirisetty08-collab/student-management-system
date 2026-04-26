package Recursion.Array;

public class LinearSearch {
    static boolean search(int[] arr,int target,int start){
        if(start==arr.length){
            return false;
        }
        return arr[start]==target || search(arr,target,start+1);
    }
    static int searchIndex(int[] arr,int target,int start){
        if(start==arr.length){
            return -1;
        }
        if(arr[start]==target){
            return start;
        }
       else {
            return searchIndex(arr, target, start + 1);
        }
    }
    static int searchIndexAtlast(int[] arr,int target,int start){
        if(start==-1){
            return -1;
        }
        if(arr[start]==target){
            return start;
        }
        else {
            return searchIndexAtlast(arr, target, start - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums={1,4,6,2,8,5,10};
        System.out.println(search(nums,6,0));
        System.out.println(searchIndex(nums,6,0));
        System.out.println(searchIndexAtlast(nums,6,nums.length-1));
    }
}
