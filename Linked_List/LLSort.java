import java.util.*;

class LLSort {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(5);
        list.add(2);
        list.add(6);
        list.add(3);
        list.add(4);
        // mergeSort(list.head);
        // list.printList();
        bucketSort(list.head);
        list.printList();
    }

    public static LinkedList.Node mergeSort(LinkedList.Node head) {
        if (head == null || head.next == null) return head;
        LinkedList.Node mid = findMiddle(head);
        LinkedList.Node left = mergeSort(head);
        LinkedList.Node right = mergeSort(mid);
        return merge(left, right);
    }

    public static LinkedList.Node findMiddle(LinkedList.Node head) {
        LinkedList.Node slow = head;
        LinkedList.Node fast = head;
        LinkedList.Node prev = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the list into two halfs
        // tail of the first half
        if (prev != null) {
            prev.next = null;
        }
        // here slow is the middle element and now left part is from head to prev and right part is from slow(mid) to tail
        // head of the second half
        return slow;
    }

    public static LinkedList.Node merge(
        LinkedList.Node head1,
        LinkedList.Node head2
    ) {
        LinkedList.Node pointer1 = head1;
        LinkedList.Node pointer2 = head2;
        LinkedList.Node curPointer = head1;
        LinkedList.Node returnableHead = head1;

        if (head1 == null) return head2;
        else if (head2 == null) return head1;
        if (head2.data < head1.data) {
            curPointer = head2;
            returnableHead = head2;
            pointer2 = pointer2.next;
        } else {
            pointer1 = pointer1.next;
        }

        while (pointer1 != null && pointer2 != null) {
            if (pointer1.data < pointer2.data) {
                curPointer.next = pointer1;
                curPointer = curPointer.next;
                pointer1 = pointer1.next;
            } else {
                curPointer.next = pointer2;
                curPointer = curPointer.next;
                pointer2 = pointer2.next;
            }
        }

        if (pointer1 != null) {
            curPointer.next = pointer1;
        } else if (pointer2 != null) {
            curPointer.next = pointer2;
        }

        return returnableHead;
    }

    static LinkedList.Node bucketSort(LinkedList.Node head) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        LinkedList.Node pointer = head;
        while (pointer != null) {
            max = Math.max(max, pointer.data);
            min = Math.min(min, pointer.data);
            pointer = pointer.next;
        }

        LinkedList.Node posPointer = head;
        int[] counter = new int[max - min + 1];
        while (posPointer != null) {
            counter[posPointer.data - min]++;
            posPointer = posPointer.next;
        }

        LinkedList.Node retPointer = head;
        for (int i = 0; i < counter.length; i++) {
            while (counter[i]-- > 0) {
                retPointer.data = i + min;
                retPointer = retPointer.next;
            }
        }
        return head;
    }
}
