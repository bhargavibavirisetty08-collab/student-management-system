package Recursion.Strings;

public class NoOfPaths {
    static int getPaths(int row ,int cols){
        if(row==1 || cols==1){
            return 1;
        }
        int left=getPaths(row-1,cols);
        int right=getPaths(row,cols-1);
        return left+right;
        //return getPaths(row-1,cols) + getPaths(row,cols-1);
    }
    public static void main(String[] args) {
        System.out.println(getPaths(3,3));
    }
}
