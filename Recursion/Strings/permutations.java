package Recursion.Strings;

import java.util.ArrayList;

public class permutations {
    static void getPermutations(String newper, String str){
        if(str.isEmpty()){
            System.out.println(newper);
            return;
        }
        //System.out.println(newper.length());
        char ch = str.charAt(0);
        for(int i=0;i<=newper.length();i++)
        {
            String first = newper.substring(0,i);
            String second = newper.substring(i,newper.length());
          getPermutations(first+ch+second,str.substring(1));
        }
    }
    public static void main(String[] args) {

        getPermutations("","abc");
    }
}
