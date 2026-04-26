import java.util.Arrays;

public class leetcode34 {
    static public int[] searchRange(int[] nums, int target) {
        if(nums.length!=0){
            int left=0;
            int right=nums.length-1;
            int[] arr=new int[2];
            int k=0;
            while(left<=right || k<1){
                int mid = (left+right)/2;
                if(target>nums[mid]){
                    left=mid+1;
                }
                else if(target<nums[mid]){
                    right = mid-1;
                }
                else {
                    arr[k] = mid;
                    k++;
                    if(target == arr[mid-1]){
                        arr[k] = mid;
                    } else if (target==arr[mid+1]) {
                        arr[k]=mid;
                    }
                    return arr;
                }
            }
            return new int[]{-1,-1};
        }
        else{
            return new int[]{-1,-1};
        }
    }
    public static void main(String[] args) {
            int[] a = {1,2,2,3,4,5};
            int[] x=searchRange(a,2);
            System.out.println(Arrays.toString(x));
    }

}
