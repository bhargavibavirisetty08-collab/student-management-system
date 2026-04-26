import java.util.Arrays;
import java.util.Scanner;

public class OrderAgnosticBinarySearch {
      static String checkOrder(int[] ar){
          if (ar[0] < ar[ar.length-1]) {
              return "Increasing";
          }
          else{
              return "Decreasing";
          }
      }
    static int  AgnosticBS(int[] a,int key){
       String order = checkOrder(a);
        System.out.println(order);
        int left=0;
        int right=(a.length)-1;
        if(order=="Increasing"){
            while(left<=right){
                int mid = (left+right)/2;
                if (key == a[mid]) {
                    return mid;
                } else if (key > a[mid]) {
                    left=mid+1;
                } else {
                    right = mid-1;
                }
            }
        }
        else{
            while(left<=right){
                int mid = (left+right)/2;
                if (key == a[mid]) {
                    return mid;
                } else if (key > a[mid]) {
                    right=mid-1;
                } else {
                   left = mid+1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {2,1,34,23,54,67,21,9,76,43,12,18};
        int[] arr = new int[nums.length];
        Arrays.sort(nums);
        System.out.println("sorted increasing order : "+Arrays.toString(nums) );
        System.out.println(nums.length);
        int k=0;
        for(int i=nums.length-1;i>=0;i--){
                arr[k] = nums[i];
            k++;
        }
        System.out.println("reverse array is : " + Arrays.toString(arr));
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number to be search : ");
        int num = sc.nextInt();
        int find = AgnosticBS(arr,num);
        if(find != -1) {
            System.out.println(num + " is found at " + find);
        }else{
            System.out.println(num + " doesn't found!!! please enter existing numbers ");
        }
    }
}
