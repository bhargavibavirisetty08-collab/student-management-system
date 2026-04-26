package Recursion.BackTracking;

import java.util.Arrays;

public class PrintMatrixpaths {
    static void printMatrix(String newpath,boolean[][] maze,int row,int cols,int[][] path,int step){
        if(row==maze.length-1 && cols==maze[0].length-1){
            path[row][cols] = step;
            for(int[] arr:path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(newpath);
            System.out.println();
            return;
        }
        if(!maze[row][cols]){
            return;
        }

        //considering this block in path
        maze[row][cols] =false;
        path[row][cols] = step;
        if(row<maze.length-1){
            printMatrix(newpath+'D',maze,row+1,cols,path,step+1);
        }
        if(cols<maze[0].length-1){
            printMatrix(newpath+'R',maze,row,cols+1,path,step+1);
        }
        if(row>0){
            printMatrix(newpath+'U',maze,row-1,cols,path,step+1);
        }
        if(cols>0){
            printMatrix(newpath+'L',maze,row,cols-1,path,step+1);
        }

        //when the calls return and recursion is over
        //so before functions is removed then changes also removed
        maze[row][cols] = true;
        path[row][cols] = 0;
    }
    public static void main(String[] args) {
        boolean[][] arr = {
                {true,true,true},
                {true,true,true},
                {true,true,true},
        };
        int[][] path = new int[arr.length][arr[0].length];
        printMatrix("",arr,0,0,path,1);
    }
}
