package queue;

class MyQueue implements QueueInterface {

    private int size = 0;
    private int front = -1;
    private int[] myQueue;
    // private static final int DEFAULT_SIZE = 10;
    private int total_length = DEFAULT_SIZE;

    public MyQueue(int size) {
        if (size > 0) {
            myQueue = new int[size];
            total_length = size;
        }
    }

    public MyQueue() {
        this(DEFAULT_SIZE);
    }

    public void insert(int item) {
        if (front != total_length - 1) {
            myQueue[++front] = item;
            size++;
        } else {
            System.out.println("queue is full");
        }
    }

    public int delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("queue is empty");
        } else {
            int popedItem = myQueue[0];
            for (int i = 0; i < front; i++) {
                myQueue[i] = myQueue[i + 1];
            }
            size--;
            front--;
            return popedItem;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return front >= total_length - 1;
    }

    public void display() {
        for (int i = 0; i < front; i++) {
            System.out.println(myQueue[i]);
        }
    }
}
