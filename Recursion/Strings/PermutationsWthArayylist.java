package Recursion.Strings;

import java.util.ArrayList;

public class PermutationsWthArayylist {
     static ArrayList<String> getlist(String newper, String str){
        if(str.isEmpty()){
            ArrayList<String>list=new ArrayList<>();
            list.add(newper);
            return list;
        }
        //System.out.println(newper.length());
        char ch = str.charAt(0);
         ArrayList<String>ans=new ArrayList<>();

         for(int i=0;i<=newper.length();i++)
        {
            String first = newper.substring(0,i);
            String second = newper.substring(i,newper.length());
            ans.addAll(getlist(first+ch+second,str.substring(1)));
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(getlist("" ,"abc"));
    }
}
