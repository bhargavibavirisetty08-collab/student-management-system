package SortingTechniques;

import java.util.Arrays;

public class FindMissingNumber {
    void swap(int[] a,int i,int j)
    {
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    private int find (int[] arr){
        int start = 0;
        while(start <= arr.length-1){
            if(arr[start] < arr.length &&arr[start] != start){
                swap(arr,arr[start],start);
            }
            else{
               start++;
            }
        }
        for(int index=0;index<arr.length;index++)
        {
            if(arr[index]!=index){
                return index;
            }
        }
        return arr.length;
    }
    public static void main(String[] args) {
        FindMissingNumber f = new FindMissingNumber();
        int[] num ={3,0,1,4,2,7,5};
        System.out.println(f.find(num));
       System.out.println(Arrays.toString(num));
    }
}
