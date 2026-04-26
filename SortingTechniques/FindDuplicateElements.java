package SortingTechniques;

public class FindDuplicateElements {
    private int DuplicateElementsInArray(int[] arr){
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
        for(int i =0;i<arr.length;i++){
            if(arr[i] != i+1)
            {
                return arr[i];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        FindDuplicateElements f = new FindDuplicateElements();
        int[]  nums = {1,3,4,2,2};
        System.out.println(f.DuplicateElementsInArray(nums));
    }
}
