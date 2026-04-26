import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {
    void reverse(int[] a , int start,int end){
        while(start<end) {
            int temp =a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }
    private int[] rotate(int[] arr,int k){
        // this solution is takes more complexity
//        int a =0;
//        while(a<k){
//            int temp = arr[arr.length-1];
//            for(int i=arr.length-1;i>0;i--){
//                arr[i] = arr[i-1];
//            }
//            arr[0] = temp;
//            a++;
//        }
//        return arr;
         // this will less complexity
        if(arr==null || arr.length==0){
            return arr;
        }
        int len = arr.length-1;
        k = k%len;
        reverse(arr,0,len);
        reverse(arr,0,k-1);
        reverse(arr,k,len);
        return arr;
    }
    public static void main(String[] args) {
        RotateArray r = new RotateArray();
        int[] nums ={1,2,3,4,5,6,7};
        System.out.println("enter the k : ");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        System.out.println(Arrays.toString(r.rotate(nums,x)));
    }
}
