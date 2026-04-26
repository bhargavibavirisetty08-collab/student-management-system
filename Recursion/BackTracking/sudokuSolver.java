package Recursion.BackTracking;

import java.util.Arrays;

public class sudokuSolver {
    static void display(char[][] maze){
        for(char[] arr : maze){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();
    }
    static void solve(char[][] maze,int row,int cols){
        if(row==maze.length){
            display(maze);
            return;
        }
        if(cols == maze.length){
            solve(maze,row+1,0);
            return;
        }
            if(maze[row][cols] == '.'){
                for(int i=1;i<=9;i++) {
                    if (IsSafe((char)('0'+i), row, cols, maze)) {
                        maze[row][cols] = (char)('0'+i);
                        solve(maze, row, cols + 1);
                        maze[row][cols] = '.';
                    }
                }
            }
            else{
                solve(maze,row,cols+1);
                return;
            }
    }
    static int get(int i){
        if(i<3){
            return 3;
        }
        if (i<6){
            return 6;
        }
        if(i<9){
           return 9;
        }
        return 0;
    }
    static boolean IsSafe(char ch,int row,int cols,char[][] maze){
        //check row
            for(int i=0;i<9;i++){
                if(maze[row][i] == ch){
                    return false;
                }
            }
            //check column
        for(int i=0;i<9;i++){
            if(maze[i][cols] == ch){
                return false;
            }
        }
        // check box
        int rowlast =  get(row);
        int collast =  get(cols);
//        int startrow = row - row % 3;
//        int startcol = cols - cols % 3;
        for(int i = rowlast-3 ;i < rowlast ; i++){
            for(int j = collast-3 ;j < collast; j++){
                if(maze[i][j] == ch){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board={
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solve(board,0,0);

    }
}
