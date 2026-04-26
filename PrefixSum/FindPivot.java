package PrefixSum;

public class FindPivot {
    private int getPivot(int[] arr){
        int leftSum =0;
        int rightSum =0;
        int left=0;
        int total=0;
        for(int i=0;i<arr.length;i++){
            total+=arr[i];
        }
        System.out.println(total);
        for(int i=0;i<arr.length;i++){
            rightSum = total-leftSum -arr[i];
            if(leftSum == rightSum){
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        FindPivot f = new FindPivot();
        System.out.println(f.getPivot(nums));
    }
}
