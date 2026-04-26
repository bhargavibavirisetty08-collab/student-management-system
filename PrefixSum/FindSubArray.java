package PrefixSum;

public class FindSubArray {
    private int getArr(int[] arr,int k){
        int left=0;int sum=0;int count=0;
        for(int right =0;right<arr.length;right++){
            sum+=arr[right];
            while(sum>=k && left<=right){
                if(sum==k){
                    count++;
                }
                sum-=arr[left];
                left++;
            }

        }
        return count;
    }
    public static void main(String[] args) {
        FindSubArray f = new FindSubArray();
        int[] nums ={1,1,1};
        System.out.println(f.getArr(nums,2));
    }
}
