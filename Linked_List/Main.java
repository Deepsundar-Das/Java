class Main {

    public static void main(String[] arr) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.printList();
        System.out.println(list.size);
        list.inNode(1, 99);
        list.inNode(3, 45);

        // list.printList();
        // list.remove(1);
        // list.remove(1);
        // list.remove(1);
        // list.removeLast();
        // list.removeLast();
        list.printList();
    }
}
