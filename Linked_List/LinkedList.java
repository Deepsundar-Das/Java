// package Linked_List;

class LinkedList {

    Node head;
    Node tail;
    int size = 0;

    public class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // always add items at last of the current list
    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        }
        if (tail != null) tail.next = node;
        tail = node;
        size++;
    }

    //always add items at the start of the current list
    public void addAtFirst(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    // method overloading
    // add items as per user's choice
    // pos(position) is must be given as 0 index

    public void add(int data, int pos) {
        Node pointer = head;

        if (pos > size) {
            System.out.println(
                "Insertion is not possible, insertion position is greater than list size"
            );
            return;
        }
        if (pos == 0) {
            addAtFirst(data);
        } else {
            for (int count = 1; count < pos; count++) {
                pointer = pointer.next;
            }
            Node node = new Node(data, pointer.next);
            pointer.next = node;
        }
        size++;
        return;
    }

    public void insert(int index, int data) {
        Node posPointer = head;
        insertUsingRec(0, index, data, posPointer);
    }

    public void insertUsingRec(
        int curIndex,
        int index,
        int data,
        Node currPosPointer
    ) {
        if (currPosPointer == null) {
            System.out.println("error: LinkedListIndexOutOfBound");
            return;
        } else if (index == 0) {
            Node node = new Node(data);
            node.next = currPosPointer;
            head = node;
            return;
        } else if (curIndex == (index - 1)) {
            Node node = new Node(data);

            node.next = currPosPointer.next;
            currPosPointer.next = node;
            size++;
            return;
        } else {
            insertUsingRec(++curIndex, index, data, currPosPointer.next);
        }
    }

    public void inNode(int index, int data) {
        Node curPosPointer = head;
        head = insertUsingRecNode(index, data, curPosPointer);
    }

    private Node insertUsingRecNode(int index, int data, Node curPosPointer) {
        if (index == 0) {
            Node node = new Node(data);
            node.next = curPosPointer;
            size++;
            return node;
        } else {
            curPosPointer.next = insertUsingRecNode(
                --index,
                data,
                curPosPointer.next
            );
            return curPosPointer;
        }
    }

    public void printList() {
        Node pointer = head;
        while (pointer != null) {
            System.out.print(pointer.data + "\t");
            pointer = pointer.next;
        }
        System.out.println();
    }

    public int removeLast() {
        Node firstPointer = null;
        Node secondPointer = head;

        if (size == 1) {
            int data = removeFirst();
            return data;
        }

        while (secondPointer.next != null) {
            firstPointer = secondPointer;
            secondPointer = secondPointer.next;
        }
        int ans = secondPointer.data;
        firstPointer.next = null;
        tail = firstPointer;
        size--;
        return ans;
    }

    public int removeFirst() {
        Node removedHead = head;
        head = head.next;
        removedHead.next = null;
        size--;
        return removedHead.data;
    }

    public int remove(int pos) {
        int data;
        if (pos == 0) {
            data = removeFirst();
        } else if (pos == size - 1) {
            data = removeLast();
        } else {
            Node pointer = head;
            for (int count = 1; count < pos; count++) {
                pointer = pointer.next;
            }
            data = pointer.next.data;
            pointer.next = pointer.next.next;
            size--;
        }
        return data;
    }
}
