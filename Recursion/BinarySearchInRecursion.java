package Recursion;
public class BinarySearchInRecursion {
    private int getIndex(int[] arr,int left,int right,int key){
        int mid = (left+right)/2;
        if(left>right){
            return -1;
        }
        if(arr[mid]==key){
            return mid;
        } else if (arr[mid]>key) {
           return getIndex(arr,left,mid-1,key);
        }
        return getIndex(arr,mid+1,right,key);
    }
    public static void main(String[] args) {
        int[] nums={4,5,6,7,8,9};
        BinarySearchInRecursion b = new BinarySearchInRecursion();
        int start=0;
        int end=nums.length-1;
        System.out.println(b.getIndex(nums,start,end,9));
    }
}
