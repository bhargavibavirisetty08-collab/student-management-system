package Recursion.Array;

public class RotatedSortedArray {
    static int getKey(int[] arr,int target,int start,int end){
        if(start>end){
            return -1;
        }
        int mid=(start+end)/2;
        if(arr[mid]==target){
            return mid;
        }
        if(arr[mid]>=arr[start]){
            if(arr[mid]>=target && target >=arr[start]){
             return   getKey(arr,target,start,mid-1);
            }
            else{
              return getKey(arr,target,mid+1,end);
            }
        }
      if(target >= arr[mid] && target<=arr[end]){
          return getKey(arr,target,mid+1,end);
      }
      return getKey(arr,target,start,mid-1);
    }
    public static void main(String[] args) {
        int[] nums={5,6,7,8,9,1,2,3};
        System.out.println(getKey(nums,2,0,nums.length-1));
    }
}
