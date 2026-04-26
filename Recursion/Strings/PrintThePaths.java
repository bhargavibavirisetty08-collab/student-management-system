package Recursion.Strings;

import java.util.ArrayList;

public class PrintThePaths {
    static void printpath(String newpath,int row,int cols){
        if(row==1 && cols==1){
            System.out.println(newpath);
            return;
        }
        if(row>1){
            printpath(newpath+'D',row-1,cols);
        }
        if(cols>1){
            printpath(newpath+'R',row,cols-1);
        }


    }
    static ArrayList<String> printpathlist(String newpath, int row, int cols){
        if(row==1 && cols==1){
           ArrayList<String> list= new ArrayList<>();
           list.add(newpath);
           return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(row>1){
            ans.addAll(printpathlist(newpath+'D',row-1,cols));
        }
        if(cols>1){
           ans.addAll(printpathlist(newpath+'R',row,cols-1));
        }
        return ans;
    }
    public static void main(String[] args) {
      // printpath("",3,3);
        System.out.println(printpathlist("",3,3));
    }
}
