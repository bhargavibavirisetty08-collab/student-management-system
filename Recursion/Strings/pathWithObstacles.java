package Recursion.Strings;

public class pathWithObstacles {
    static void getpath(String newpath,boolean[][] maze,int row,int cols){
        if(row==maze.length-1 && cols==maze[0].length-1){
            System.out.println(newpath);
            return;
        }
        if(!maze[row][cols]){
            return;
        }
        if(row<maze.length-1){
            getpath(newpath+'D',maze,row+1,cols);
        }
        if(cols<maze[0].length-1){
            getpath(newpath+'R',maze,row,cols+1);
        }
    }
    public static void main(String[] args) {
        boolean[][] arr = {
                {true,true,true},
                {true,false,true},
                {true,true,true},
        };
        getpath("",arr,0,0);
    }
}
