package Recursion.Array;

public class RotatedSortedArrayPivot {
    static int getPivot(int[] arr,int start,int end){
        if(start>end)
        {
            return -1;
        }
        int mid=(start+end)/2;
        if(mid<end && arr[mid]>arr[mid+1])
        {
            return mid;
        }
        if(mid>start && arr[mid-1]>arr[mid])
        {
            return mid-1;
        }
        if(arr[mid] >= arr[start]){
            return getPivot(arr,mid+1,end);
        }
        else {
            return getPivot(arr,start,mid-1);
        }
    }
    public static void main(String[] args) {
        int[] nums={3,4,5,1,2};
        System.out.println(getPivot(nums,0,nums.length-1));
    }
}
