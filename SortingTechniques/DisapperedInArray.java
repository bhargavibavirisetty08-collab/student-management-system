package SortingTechniques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisapperedInArray {
    private List<Integer> disapperedelements(int[] arr){
        int start =0;
        int end = arr.length-1;
        while(start<=end){
            if(start+1 == arr[start] || arr[start] == arr[arr[start]-1]){
                start++;
            }else{
                int temp = arr[arr[start]-1];
                arr[arr[start]-1]=arr[start];
                arr[start] =temp;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i =0;i<arr.length;i++){
            if(arr[i] != i+1)
            {
                ans.add(i+1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] num = {4,3,2,7,8,2,3,1};
        DisapperedInArray d = new DisapperedInArray();
        //System.out.println(d.disapperedelements(num));
        System.out.println(d.disapperedelements(num));
    }
}
