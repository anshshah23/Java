package Stack;

import java.util.*;

class sortStackRecursive {
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        Stack<Integer> ans = new Stack<>();
        while(!s.isEmpty()) {
            int top = s.pop();
            if(ans.isEmpty() || ans.peek() > top){
                insertAtBottom(ans, top);
            }
            else{
                ans.push(top);
            }
        }
        return ans;
    }
    private static void insertAtBottom(Stack<Integer> ans, int ele){
        if(ans.isEmpty() || ele > ans.peek()) {
            ans.push(ele);
        } else {
            int top = ans.pop();
            insertAtBottom(ans, ele);
            ans.push(top);
        }
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        
        sortStackRecursive sorter = new sortStackRecursive();
        Stack<Integer> sortedStack = sorter.sort(stack);
        
        while (!sortedStack.isEmpty()) {
            System.out.println(sortedStack.pop());
        }
    }
}