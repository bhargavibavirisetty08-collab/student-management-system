import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    static int  search1(int[] arr,int key)
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
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {2,4,45,76,98,24,1,87};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number to be search : ");
        int num = sc.nextInt();
        int find=search1(nums,num);
        if(find != -1) {
            System.out.println(num + " is found at " + find);
        }else{
            System.out.println(num + " doesn't found!!! please enter existing numbers ");
        }
    }
}
