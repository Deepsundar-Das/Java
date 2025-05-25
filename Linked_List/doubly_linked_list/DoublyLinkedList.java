package doubly_linked_list;

class DoublyLinkedList {

    Node head;
    Node tail;
    Node prev_node;
    int size = 0;

    private class Node {

        int data;
        Node next;
        Node prev;

        private Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        private Node(int data) {
            this.data = data;
        }
    }

    public void addAtFirst(int data) {
        Node node = new Node(data);
        node.next = head;

        if (head != null) {
            head.prev = node;
        } else {
            node.next = null;
            tail = node;
        }
        head = node;
        size++;
    }

    public void addAtLast(int data) {
        Node node = new Node(data);
        if (tail != null) {
            tail.next = node;
            node.prev = tail;
        } else {
            node.prev = null;
        }
        node.next = null;
        tail = node;
        size++;
    }

    public void add(int data, int index) {
        if (index == 0) addAtFirst(data);
        else if (index == size) addAtLast(data);
        else if (index > 0) {
            posAddNode(data, index);
        } else {
            if (index == -1) addAtLast(data);
            else if (index == -(size + 1)) addAtFirst(data);
            else negAddNode(data, index);
        }
    }

    private void posAddNode(int data, int index) {
        Node posPointer = head;
        for (int count = 1; count < index; count++) {
            posPointer = posPointer.next;
        }
        Node node = new Node(data, posPointer.next, posPointer);
        posPointer.next = node;
        node.next.prev = node;
        size++;
    }

    private void negAddNode(int data, int index) {
        index = -index;
        Node posPointer = tail;
        for (int count = 1; count < index - 1; count++) {
            posPointer = posPointer.prev;
        }
        Node node = new Node(data, posPointer, posPointer.prev);
        node.next.prev = node;
        node.prev.next = node;
        size++;
    }

    public void printList() {
        Node posPointer = head;
        while (posPointer != null) {
            System.out.print(posPointer.data + "\t");
            posPointer = posPointer.next;
        }
        System.out.println();
    }
}
