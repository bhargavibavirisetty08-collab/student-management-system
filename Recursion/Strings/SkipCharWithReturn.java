package Recursion.Strings;

public class SkipCharWithReturn {
    static String skips(String str)
    {
        if(str.isEmpty())
        {
            return "";
        }
        char ch = str.charAt(0);
        if (ch=='a')
        {
            return skips(str.substring(1));
        }
        else {
            return ch + skips(str.substring(1));
        }
    }
    public static void main(String[] args) {
        System.out.println(skips("fasuytreaaaoaa"));
    }
}
