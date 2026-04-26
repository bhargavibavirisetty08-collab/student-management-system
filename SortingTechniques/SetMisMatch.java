package SortingTechniques;

import java.util.Arrays;

public class SetMisMatch {
    void swap(int[] a,int i,int j)
    {
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    private int[] MisMatch(int[] arr){
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
        for(int index=0;index<arr.length;index++)
        {
            if(arr[index]!=index+1){
                return new int[]{arr[index],index+1};
            }
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        SetMisMatch s = new SetMisMatch();
        int[] num = {1,2,2,4};
        System.out.println(Arrays.toString(s.MisMatch(num)));
    }
}
