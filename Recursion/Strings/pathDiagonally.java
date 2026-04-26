package Recursion.Strings;

import java.util.ArrayList;

public class pathDiagonally {
    static void getdiagonal(String newpath,int row,int cols){
        if(row==1 && cols==1){
            System.out.println(newpath);
            return;
        }
        if(row>1){
            getdiagonal(newpath+'D',row-1,cols);
        }
        if(cols>1) {
            getdiagonal(newpath + 'R', row, cols - 1);
        }if(row>1 && cols>1) {
            getdiagonal(newpath + "Di", row - 1, cols - 1);
        }
    }
    static ArrayList<String> getdiagonallist(String newpath, int row, int cols){
        if(row==1 && cols==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(newpath);
            return list;
        }
        ArrayList<String>ans= new ArrayList<>();

        if(row>1){
            ans.addAll(getdiagonallist(newpath+'D',row-1,cols));
        }
        if(cols>1) {
            ans.addAll(getdiagonallist(newpath + 'R', row, cols - 1));
        }if(row>1 && cols>1) {
            ans.addAll(getdiagonallist(newpath + "Di", row - 1, cols - 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        // getdiagonal("",3,3);
        System.out.println(getdiagonallist("",3,3));
    }
}
