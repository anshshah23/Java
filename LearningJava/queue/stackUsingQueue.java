package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class stackUsingQueue {
    Queue<Integer> queue;
    Queue<Integer> queue1;

    public stackUsingQueue() {
        queue=new LinkedList<>();
        queue1=new LinkedList<>();
    }
    
    public void push(int x) {
        if(queue.isEmpty()){
            queue.add(x);
        }
        else{
            while(!queue.isEmpty()){
                queue1.add(queue.poll());
            }
            queue.add(x);
            while(!queue1.isEmpty()){
                queue.add(queue1.poll());
            }
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
    public static void main(String[] args) {
        stackUsingQueue obj = new stackUsingQueue();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
        
        System.out.println("Popped Element: " + param_2);
        System.out.println("Top Element: " + param_3);
        System.out.println("Is Stack Empty? " + param_4);
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
