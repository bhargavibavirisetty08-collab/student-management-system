package Recursion.Array;

public class MountainArrayPeakElement {
    static int getPeak(int[] arr,int start,int end)
    {
        if(start==end) {
            return start;
        }
        int mid=(start+end)/2;
        if(start< mid && end >mid) {
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
        }
            if (arr[mid] < arr[mid + 1] && mid <end) {
                return getPeak(arr, mid + 1, end);
            }
                return getPeak(arr, start, mid);
    }
    public static void main(String[] args) {
        int[] nums={2,1};
        System.out.println(getPeak(nums,0,nums.length-1));
    }
}
