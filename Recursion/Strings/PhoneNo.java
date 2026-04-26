package Recursion.Strings;

import java.util.ArrayList;

public class PhoneNo {
    static void getoutcomes(String newout,String  str){
        if(str.isEmpty()){
            System.out.println(newout);
            return;
        }
        int digit= str.charAt(0)-'0';
        for(int i=(digit-1)*3;i<digit*3;i++){
            char ch = (char)('a'+i);
            getoutcomes(newout+ch,str.substring(1));

        }
    }
    static ArrayList<String> getoutcomeslist(String newout, String  str){
        if(str.isEmpty()){
            ArrayList<String>list=new ArrayList<>();
            list.add(newout);
            return list;
        }
        int digit= str.charAt(0)-'0';
        ArrayList<String>ans = new ArrayList<>();
        for(int i=(digit-1)*3;i<digit*3;i++){
            char ch = (char)('a'+i);
           ans.addAll(getoutcomeslist(newout+ch,str.substring(1)));
        }
        return ans;
    }
    static int  getoutcomesCount(String newout, String  str){
        if(str.isEmpty()){
           return 1;
        }
        int count=0;
        int digit= str.charAt(0)-'0';
        for(int i=(digit-1)*3;i<digit*3;i++){
            char ch = (char)('a'+i);
          count = count + getoutcomesCount(newout+ch,str.substring(1));
        }
        return count;
    }
    public static void main(String[] args) {
       // getoutcomes("","12");
        //System.out.println( getoutcomeslist("","12"));
        System.out.println(getoutcomesCount("","12"));
    }
}
