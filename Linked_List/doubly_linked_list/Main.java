package doubly_linked_list;

class Main {

    public static void main(String[] arr) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addAtFirst(1);
        list.addAtLast(2);
        list.add(3, 2);
        list.printList();
        list.add(35, -4);
        list.printList();
        list.addAtFirst(80);
        list.printList();
        System.out.println(list.size);
    }
}
