import java.util.Arrays;

public class BinarySearchInStricted2DArray {
    private int[] SearchInStrictedArray(int[][] arr,int key){
        int left = arr.length-1;
        int right = 0;
        while(left>=0 && right<arr[0].length){
            if(key==arr[left][right]){
                return new int[]{left,right};
            } else if (key < arr[left][right]) {
                left--;
            }else{
                right++;
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        BinarySearchInStricted2DArray bss = new BinarySearchInStricted2DArray();
        int[][] nums ={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int row = nums.length;
        int col = nums[0].length;
        System.out.println(row + " " + col);
        int[] found =bss.SearchInStrictedArray(nums,5);
        System.out.println(Arrays.toString(found));
    }
}
