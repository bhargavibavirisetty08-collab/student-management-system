package Recursion.Strings;

import java.util.ArrayList;

public class Diceroll {
    static void get(String newout,int target){
        if(target==0){
            System.out.println(newout);
            return;
        }
        for(int i=1;i<=target && i<=6;i++){
            get(newout+i,target-i);
        }
    }
    static ArrayList<String>getlist(String newout, int target){
        if(target==0){
            ArrayList<String>list=new ArrayList<>();
           list.add(newout);
            return list;
        }
        ArrayList<String>ans = new ArrayList<>();
        for(int i=1;i<=target && i<=6;i++){
            ans.addAll(getlist(newout+i,target-i));
        }
        return ans;
    }
    static ArrayList<String>customface(String newout, int target,int face){
        if(target==0){
            ArrayList<String>list=new ArrayList<>();
            list.add(newout);
            return list;
        }
        ArrayList<String>ans = new ArrayList<>();
        for(int i=1;i<=target && i<=face;i++){
            ans.addAll(customface(newout+i,target-i,face));
        }
        return ans;
    }
    public static void main(String[] args) {
        get("",4);
       System.out.println(getlist("",4));
        System.out.println(customface("",7,8));
    }
}
