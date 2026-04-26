package PrefixSum;

import java.util.HashMap;

public class FindSubArray2 {
    private int getarr(int[] arr,int k){
        int sum =0;int count =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            int element = sum-k;
            if(map.containsKey(element)){
                count+=map.get(element);
            }
            if(map.containsKey(sum)){
                map.put(sum,map.get(sum)+1);
            }
            else{
                map.put(sum,1);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums ={1,2,3};
        FindSubArray2 f = new FindSubArray2();
        System.out.println(f.getarr(nums,3));
    }
}
