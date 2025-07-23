import java.util.*;

class Main {

    public static void main(String[] arr) {
        // Normal binary tree

        // Scanner sc = new Scanner(System.in);
        // BinaryTree b = new BinaryTree();
        // b.buildTree(sc);
        // b.display();

        // Binary search tree

        int[] nums = new int[20];
        for (int i = 0; i < 20; i++) {
            nums[i] = i;
        }
        AVL b = new AVL();
        b.insert(nums);
        System.out.println(b.root.value);
        System.out.println("Height of the root is : " + b.root.height);
        b.display();

        // int[] nums = new int[] { 2, 8, 7, -1, -4, -1, 3, 4 };
        // SegmentTree s = new SegmentTree();
        // s.insert(nums);
        // System.out.println(s.sumOf(0, 7));
    }
}
