package Recursion.Array;

public class CheckSortedOrNot {
    private boolean check(int[] arr,int start){
        if(start==arr.length-1){
            return true;
        }
        return arr[start]<arr[start+1] && check(arr,start+1);
    }
    public static void main(String[] args) {
        CheckSortedOrNot c = new CheckSortedOrNot();
        int[] nums={1,2,4,5,6};
        System.out.println(c.check(nums,0));
    }
}
