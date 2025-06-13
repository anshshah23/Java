package stack;

import java.util.*;

public class infixToPostfix {
    static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^');
    }

    private static int operatorPrecedence(Character op) {
        if (op == '^')
            return 3;
        if (op == '*' || op == '/')
            return 2;
        if (op == '+' || op == '-')
            return 1;
        return -1;
    }

    public static String convertToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(Character.isLetterOrDigit(cur)){
                res.append(cur);
            }
            else if(cur == '('){
                st.push(cur);
            }else if(cur == ')'){
                while(!st.isEmpty() && st.peek()!='('){
                    res.append(st.pop());
                }
                st.pop();
            } else {
                while(!st.isEmpty() && st.peek()!='(' && (operatorPrecedence(cur)>operatorPrecedence(st.peek()) || operatorPrecedence(cur) == operatorPrecedence(st.peek()) && cur!='^')){
                    res.append(st.pop());
                }
                st.push(cur);
            }
        }
        while (!st.isEmpty()) {
            res.append(st.pop());                
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String infix = "(A+B)*(C-D)";
        System.out.println("Postfix: " + convertToPostfix(infix));
    }
}
