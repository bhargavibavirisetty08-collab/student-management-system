import java.util.Arrays;
import java.util.Scanner;
      //it gives the greatest number of smallest or equal to target
public class FloorOfNumber {
    static int  search6(int[] arr,int key)
    {
        int left=0;
        int right=(arr.length)-1;
        while(left<=right){
            int mid = (left+right)/2;
            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                left=mid+1;
            } else {
                right = mid-1;
            }
        }
        return right;
    }
    public static void main(String[] args) {
        int[] nums = {2,4,45,76,98,24,1,87};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number to be search : ");
        int num = sc.nextInt();
        int index=search6(nums,num);
        if (index < nums.length && nums[index] == num) {
            System.out.println(num + " found at index " + index);
        }
        else if (index < nums.length) {
            System.out.println(num + " not found. Ceiling is " + nums[index] +
                    " at index " + index);
        }
        else {
            System.out.println("No ceiling exists for " + num);
        }
    }
}
