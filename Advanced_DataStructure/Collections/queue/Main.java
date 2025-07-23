package queue;

class Main {

    public static void main(String[] arr) {
        CircularQueue queue = new CircularQueue(2);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.display();
        // System.out.println(queue.delete());
        // System.out.println(queue.delete());
        // System.out.println(queue.delete());
        // System.out.println(queue.delete());
        // System.out.println(queue.delete());
    }
}
