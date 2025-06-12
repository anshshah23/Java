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
            if (Character.isLetterOrDigit(s.charAt(i))) {
                res.append(s.charAt(i));
            } else if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    res.append(st.pop());
                }
                st.pop();
            } else {
                while (!st.isEmpty() && st.peek() != '(' &&
                        (operatorPrecedence(s.charAt(i)) < operatorPrecedence(st.peek()) ||
                        (operatorPrecedence(s.charAt(i)) == operatorPrecedence(st.peek()) && s.charAt(i) != '^'))) {
                    res.append(st.pop());
                }
                st.push(s.charAt(i));
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
