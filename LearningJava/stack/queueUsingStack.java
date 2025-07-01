package Stack;

import java.util.Stack;
class queueUsingStack {
    private Stack<Integer> input;
    private Stack<Integer> output;
    public queueUsingStack() {
        input  = new Stack<>();
        output = new Stack<>();
    }
    public void push(int x) {
        input.push(x);   
    }
    
    public int pop() {
        peek();
        return output.pop();
    }
    
    public int peek() {
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    public static void main(String[] args) {
        queueUsingStack obj = new queueUsingStack();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();

        System.out.println("Popped Element: " + param_2); // Should print 1
        System.out.println("Peek Element: " + param_3); // Should print 2
        System.out.println("Is Queue Empty? " + param_4); // Should print false
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */