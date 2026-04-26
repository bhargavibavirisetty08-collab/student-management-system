package Recursion.BackTracking;

public class KNights {
    static void display(boolean[][] maze){
        for(boolean[] row : maze){
            for (boolean element : row){
                if(element){
                    System.out.print("K ");
                }
                else{
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }
    static int getKnights(boolean[][] maze,int row,int col,int knights)
    {
        if( knights==0 ){
            display(maze);
            System.out.println();
            return 1;
        }
        if(row==maze.length){
          return 0;
        }
        if(col==maze.length){
           return getKnights(maze,row+1,0,knights);
        }
        int count=0;
        if(isSafe(maze,row,col)){
            maze[row][col]=true;
           count+= getKnights(maze,row,col+1,knights-1);
            maze[row][col]=false;
        }
        count+=getKnights(maze,row,col+1,knights);
        return count;
    }
    static boolean isSafe(boolean[][] maze,int row,int col){
        // only check upper cases
        if(row-2>=0 && (col-1)>=0  && maze[row-2][col-1] ){
            return false;
        }
        if(row-2>=0  && col+1 < maze.length&& maze[row-2][col+1] ){
            return false;
        }
        if(  row-1>=0 &&  col-2 >=0 && maze[row-1][col-2]  ){
            return false;
        }
        if( row-1 >=0 && col+2<maze.length && maze[row-1][col+2] ){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int n=4;
        boolean[][] arr = new boolean[n][n];
        System.out.println(getKnights(arr,0,0,4));

    }
}
