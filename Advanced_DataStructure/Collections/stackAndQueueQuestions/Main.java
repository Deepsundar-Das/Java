package stackAndQueueQuestions;

import java.util.*;

// import java.util.Arrays;

class Main {

    public static void main(String[] a) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(6);
        queue.display();
        System.out.println(queue.peek());
        queue.display();
        System.out.println(queue.pop());
        queue.display();
        // System.out.println(Arrays.toString(queue));
    }
}
