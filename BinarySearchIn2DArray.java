import java.util.Arrays;

public class BinarySearchIn2DArray {
    private int[] getAnsIn2DArray(int[][] arr,int key){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            if(key == arr[left][right]){
                return new int[] {left,right};
            } else if (key < arr[left][right]) {
                right--;
            }else{
                left++;
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        BinarySearchIn2DArray bs = new BinarySearchIn2DArray();
        int[][] nums ={
                {10,20,30,40},
                {15,25,35,45},
                {28,29,38,49},
                {33,34,38,50}
        };
        int[] ans = bs.getAnsIn2DArray(nums,10);
        System.out.println(Arrays.toString(ans));
    }
}
