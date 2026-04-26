package BitManipulation;

import java.util.Arrays;

public class ImageGoggleQuestion {
    private int[][] getFlipImage(int[][] arr){
        for(int[] a : arr){
            for(int i=0;i<(arr[0].length+1)/2;i++){
                int temp = a[i]^1;
                a[i]=a[a.length-1-i]^1;
                a[a.length-1-i] = temp;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[][] nums = {{1,1,0},{1,0,1},{0,0,0}};
        ImageGoggleQuestion i = new ImageGoggleQuestion();
        System.out.println(Arrays.deepToString(i.getFlipImage(nums)));
    }
}
