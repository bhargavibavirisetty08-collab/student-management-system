package PrefixSum;

import java.util.HashMap;

public class ValidSubArray {
    private boolean getValidArr(int[] arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0;
        map.put(0,-1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            int rem=sum%k;
            if(map.containsValue(rem)){
                    if(i-map.get(rem)>=2) {
                        return true;
                    }
            }
            else{
                map.put(rem,i);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums= {1,0};
        ValidSubArray v = new ValidSubArray();
        System.out.println(v.getValidArr(nums,2));
    }
}
