package Recursion.BackTracking;

import java.util.Arrays;

public class NQueens {
    static void display(boolean[][] maze){
        for(boolean[] row : maze){
            for (boolean element : row){
                if(element){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
    static int getpaths(boolean[][] maze,int row){
        if(row == maze.length ){
            display(maze);
            System.out.println();
            return 1;
        }
        int count=0;
        for(int col=0;col<maze.length;col++){
            if(isSafe(maze,row,col)){
                maze[row][col]=true;
                count+=getpaths(maze,row+1);
                maze[row][col]=false;
            }
        }
        return count;
    }
    static boolean isSafe(boolean[][] maze,int row,int col){
        // check vertical row
        for (int i =0;i<row;i++){
            if(maze[i][col]){
                return false;
            }
        }
        //diagonal left
        int maxLeft= Math.min(row,col);
        for(int i=1;i<=maxLeft;i++){
            if(maze[row-i][col-i]){
                return false;
            }
        }
        //diagonal right
        int maxRight = Math.min(row,maze.length-col-1);
        for (int i =1;i<=maxRight;i++){
            if(maze[row-i][col+i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int n=4;
        boolean[][] arr = new boolean[n][n];
        //System.out.println(Arrays.deepToString(arr));
        System.out.println(getpaths(arr,0));
    }
}
