import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class BSInInfiniteNumber {
    static int ans(int[] arr,int key )
    {
        //in this we get exception becoz we don't have  infinite numbers
        int start =0;
        int end=1;
        while(arr[end] < key) { //we only double when key>arr[end] after we perform search on particular part of arr
            start=(end+1);
            end = (start * 2) + 1;
        }
        return search2( arr, key, start, end);
    }
    static int  search2(int[] x, int keys,int a,int b) {
        int mid=-1;
        int left = a;
        int right = b;
        while (left <= right) {
            mid = (left + right) / 2;
            if (keys == x[mid]) {
                return mid;
            } else if (keys > x[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
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
        int find = ans( nums, num);
        if(find != -1) {
            System.out.println(num + " is found at " + find);
        }else{
            System.out.println(num + " doesn't found!!! please enter existing numbers ");
        }
    }
}
