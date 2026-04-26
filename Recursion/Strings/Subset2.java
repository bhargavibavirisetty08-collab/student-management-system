package Recursion.Strings;

import java.util.ArrayList;

public class Subset2 {
    static ArrayList<String> getSubset1(String newSub, String str){
        ArrayList<String>list = new ArrayList<>();
        if(str.isEmpty()){
            list.add(newSub);
            return list;
        }
        char ch = str.charAt(0);
        ArrayList<String> ans = getSubset1(newSub+ch,str.substring(1));
        ArrayList<String> ans1 = getSubset1(newSub+(ch+0),str.substring(1));
        ArrayList<String>ans2=getSubset1(newSub,str.substring(1));
        list.addAll(ans);
        list.addAll(ans1);
        list.addAll(ans2);
        return list;
    }
    public static void main(String[] args) {
        System.out.println(getSubset1("","abc"));
    }
}
