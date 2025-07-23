package queue;

class CircularQueue implements QueueInterface {

    int front = -1;
    int back = 0;
    int length = 0;
    int size = 0;
    int[] myCircularQueue;

    public CircularQueue(int size) {
        length = size;
        myCircularQueue = new int[size];
    }

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public void insert(int item) {
        if (isFull()) {
            increaseQueueCapacity(myCircularQueue);
        }
        myCircularQueue[++front] = item;
        size++;
        front %= length;
    }

    public int delete() throws Exception {
        return 1;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isFull() {
        return size == length;
    }

    public void display() {
        for (int i = front; front != back; i++) {
            System.out.println(myCircularQueue[i % length]);
        }
    }

    private void increaseQueueCapacity(int[] myCircularQueue) {
        length = length * 2;
        front++;
        int[] tempQueue = new int[length];
        for (int i = front, j = 0; front != back; i++, j++) {
            tempQueue[j] = myCircularQueue[i];
            front--;
        }
        myCircularQueue = tempQueue;
    }
}
