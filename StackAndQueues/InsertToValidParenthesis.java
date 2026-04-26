package StackAndQueues;

import java.util.Stack;

public class InsertToValidParenthesis {
    public static int getMinToValid(String s){
        Stack<Character>stack = new Stack<>();
        int count =0 ;

        String revstr = new StringBuilder(s).reverse().toString();
        for(int i = 0;i < revstr.length();i++){
            char ch = revstr.charAt(i);
            stack.push(ch);
        }
        // System.out.println(stack);
        while( !stack.empty() && stack.peek() != '(' ) {
            if (!stack.empty() && stack.peek() == ')'  ) {
                stack.pop();
                count+=2;
                if (!stack.empty() && stack.peek() == ')' ) {
                    stack.pop();
                    count-=1;
                }
            }
        }

        while (!stack.empty()) {
            if (stack.peek() == '(') {
                stack.pop();
                count += 2;
            } else if(stack.peek() == ')') {
                stack.pop();
                count -= 1;
            }
        }




//        for(int i = 0;i < s.length();i++){
//            char ch = s.charAt(i);
//            if(ch == '(')
//            {
//                stack.push(ch);
//                count++;
//            }
//            else if (ch == ')') {
//                 if(!stack.empty() &&stack.peek() == '('  )
//                 {
//                     stack.pop();
//                     count--;
//
//                 } else if ( stack.empty()  || stack.peek() != '(') {
//                     count++;
//                 }
//            }
//        }
       return count;
    }
    public static void main(String[] args) {
        System.out.println(getMinToValid(")))))))"));
    }
}
