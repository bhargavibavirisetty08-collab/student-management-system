package Recursion.Strings;

import java.util.ArrayList;

public class Phoneno2 {
    static ArrayList<String> getno(String str){

        if(str.isEmpty()){
            ArrayList<String>list=new ArrayList<>();
            list.add("");
            return list;
        }
        ArrayList<String>Smallans =getno(str.substring(1));
        ArrayList<String>ans = new ArrayList<>();
        int digit= str.charAt(0)-'0';
        int start=(digit-2)*3;
        int end=start+3;
        if(digit==7){
            end = start +4;
        }
        if(digit==8){
            start++;
            end=start+3;
        }
        if(digit==9){
            start ++;
            end=start+4;
        }
       for(int i=start;i<end;i++){
            char ch = (char)('a'+i);
            for (String s : Smallans)
            {
                ans.add(ch+s);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(getno("23"));
    }
}
