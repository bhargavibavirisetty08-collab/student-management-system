package StackAndQueues;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean IsValid(String s){
        Stack<Character> st = new Stack<>();
        for(int i = 0 ;i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else {
                if(ch == ')'){
                    if(  st.empty() || st.pop() != '('   ){
                        return false;
                    }
                }
                else if (ch == ']') {
                    if( st.empty()  ||  st.pop() != '['    ){
                        return false;
                    }
                }
                else if (ch == '}') {
                    if(  st.empty() ||  st.pop() != '{'    ){
                        return false;
                    }
                }
            }
        }
        return st.empty();
    }
    public static void main(String[] args) {
        System.out.println(IsValid("(])"));
    }
}
