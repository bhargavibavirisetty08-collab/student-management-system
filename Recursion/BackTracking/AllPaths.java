package Recursion.BackTracking;

public class AllPaths {
    static void getallpaths(String newpath,boolean[][] maze,int row,int cols){
        if(row==maze.length-1 && cols==maze[0].length-1){
            System.out.println(newpath);
            return;
        }
        if(!maze[row][cols]){
            return;
        }

        //considering this block in path
        maze[row][cols] =false;
        if(row<maze.length-1){
            getallpaths(newpath+'D',maze,row+1,cols);
        }
        if(cols<maze[0].length-1){
            getallpaths(newpath+'R',maze,row,cols+1);
        }
        if(row>0){
            getallpaths(newpath+'U',maze,row-1,cols);
        }
        if(cols>0){
            getallpaths(newpath+'L',maze,row,cols-1);
        }

        //when the calls return and recursion is over
        //so before functions is removed then changes also removed
        maze[row][cols] = true;
    }
    public static void main(String[] args) {
        boolean[][] arr = {
                {true,true,true},
                {true,true,true},
                {true,true,true},
        };
        getallpaths("",arr,0,0);
    }
}
