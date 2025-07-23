package queue;

interface QueueInterface {
    public static final int DEFAULT_SIZE = 10;
    public void insert(int item);
    public int delete() throws Exception;
    public boolean isEmpty();
    public boolean isFull();
    public void display();
}
