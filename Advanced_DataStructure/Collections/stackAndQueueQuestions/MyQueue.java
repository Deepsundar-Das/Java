//Leetcode : 232
// https://leetcode.com/problems/implement-queue-using-stacks/

package stackAndQueueQuestions;

import java.util.Stack;

class MyQueue {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public MyQueue() {}

    public void push(int x) {
        stack1.push(x);
    }

    public void display() {
        System.out.println(stack1);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            for (int i = stack1.size(); i > 0; i--) {
                int x = stack1.pop();
                stack2.push(x);
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            for (int i = stack1.size(); i > 0; i--) {
                int x = stack1.pop();
                stack2.push(x);
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}
