package Recursion.Strings;



public class SkipString {
    static String skip(String str,String leave){
        if(str.isEmpty()){
            return str;
        }

        if(str.startsWith(leave)){
           return skip(str.substring(leave.length()),leave);
        }
            return str.charAt(0) + skip(str.substring(1),leave);
    }
    static String skipwithsomechar(String str){
        if(str.isEmpty()){
            return str;
        }

        if(str.startsWith("app") && !str.startsWith("apple")){
            return skipwithsomechar(str.substring("app".length()));
        }
        return str.charAt(0) + skipwithsomechar(str.substring(1));
    }
    public static void main(String[] args) {
        System.out.println( skip("applemk","apple"));
        System.out.println(skipwithsomechar("appmuyg"));
    }
}
