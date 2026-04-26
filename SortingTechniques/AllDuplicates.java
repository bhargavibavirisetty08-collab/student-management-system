package SortingTechniques;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AllDuplicates {
    private ArrayList<Integer> getDuplicates(int[] arr)
    {
        int start =0;
        int end = arr.length-1;
        while(start<=end){
            if(start+1 == arr[start] || arr[start] == arr[arr[start]-1]){
                start++;
            } else{
                int temp = arr[arr[start]-1];
                arr[arr[start]-1]=arr[start];
                arr[start] =temp;
            }
        }
        ArrayList<Integer> ele = new ArrayList<>();
        for(int i =0;i<arr.length;i++){
            if(arr[i] != i+1)
            {
                ele.add(arr[i]);
            }
        }
        return ele;
    }
    public static void main(String[] args) {
        int[] num ={4,3,2,7,8,2,3,1};
        AllDuplicates  a = new AllDuplicates();
        System.out.println(a.getDuplicates(num));
    }
}
