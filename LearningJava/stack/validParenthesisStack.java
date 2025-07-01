package Stack;
//Ignore the above line.

import java.util.Stack;
class validParenthesisStack {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            } else {
                if(st.isEmpty()) return false;
                char top = st.peek();
                if (top == '(' && a == ')') {
                    st.pop();
                } else if (top == '{' && a == '}') {
                    st.pop();
                } else if (top == '[' && a == ']') {
                    st.pop();
                }
                else return false;
            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        validParenthesisStack vps = new validParenthesisStack();
        System.out.println(vps.isValid("()")); // true
        System.out.println(vps.isValid("()[]{}")); // true
        System.out.println(vps.isValid("(]")); // false
        System.out.println(vps.isValid("([)]")); // false
        System.out.println(vps.isValid("{[]}")); // true
    }
}