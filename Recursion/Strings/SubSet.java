package Recursion.Strings;

import java.util.ArrayList;

public class SubSet {
    static ArrayList<String> getSubset(String newSub, String str){
        ArrayList<String>list = new ArrayList<>();
        if(str.isEmpty()){
            list.add(newSub);
            return list;
        }
        char ch = str.charAt(0);
        ArrayList<String> ans = getSubset(newSub+ch,str.substring(1));
        ArrayList<String>ans1=getSubset(newSub,str.substring(1));
        list.addAll(ans);
        list.addAll(ans1);
        return list;
    }
    public static void main(String[] args) {
        System.out.println(getSubset("","abc"));
    }
}
