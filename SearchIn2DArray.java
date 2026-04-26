import java.util.Arrays;
import java.util.Scanner;

public class SearchIn2DArray {

    static int[] search0(int[][] nums,int num)
    {
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums[i].length;j++)
            {
                if(nums[i][j]==num){
                    return new int[] {i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int[][] arr={
                {1,3,4},
                {2,7,6,5},
                {8,9,0}
        };
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to search : ");
        int number = sc.nextInt();
       int[] find = search0(arr,number);
        if(find[0] != -1) {
            System.out.println(number + " is found at " + Arrays.toString(find));
        }else{
            System.out.println(number + " doesn't found!!! please enter existing numbers ");
        }
    }
}
