package Recursion.Strings;

public class SkipACharcter {
    static void skip(String newstr,String str){
        if(str.isEmpty()){
            System.out.println(newstr);
            return;
        }
        char ch = str.charAt(0);
        if(ch =='a')
        {
            skip(newstr,str.substring(1));
        }else {
            skip(newstr+ch,str.substring(1));
        }
    }
    public static void main(String[] args) {
        skip("","abhaba");
    }
}
