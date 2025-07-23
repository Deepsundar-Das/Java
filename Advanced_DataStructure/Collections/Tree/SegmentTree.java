// this is for sum of stInd to endInd in an array

import java.util.Objects;

class SegmentTree {

    private class Node {

        int value;
        Node right;
        Node left;
        int stInd;
        int endInd;

        public Node(int stInd, int endInd) {
            this.stInd = stInd;
            this.endInd = endInd;
        }
    }

    private Node root;
    private int[] arr;

    public void insert(int[] nums) {
        arr = nums;
        root = buildTree(0, nums.length - 1);
    }

    private Node buildTree(int stInd, int endInd) {
        if (stInd == endInd) {
            Node node = new Node(stInd, endInd);
            node.value = arr[stInd];
            return node;
        }

        Node node = new Node(stInd, endInd);
        int mid = (stInd + endInd) / 2;
        node.left = buildTree(stInd, mid);
        node.right = buildTree(mid + 1, endInd);
        node.value = node.left.value + node.right.value;
        return node;
    }

    public int sumOf(int targetstInd, int targetendInd)
        throws ArrayIndexOutOfBoundsException {
        // System.out.println(root.value);
        if (
            targetstInd < root.stInd || targetendInd > root.endInd
        ) throw new ArrayIndexOutOfBoundsException(
            "Check the starting index and end index properly"
        );
        return calculateSum(targetstInd, targetendInd, root);
    }

    private int calculateSum(int targetSt, int targetEnd, Node node) {
        Objects.requireNonNull(node);
        System.out.println(node.value);
        if (
            (targetSt <= node.stInd && targetEnd >= node.endInd) ||
            ((node.stInd == node.endInd) &&
                (targetSt <= node.stInd && targetEnd >= node.endInd))
        ) {
            return node.value;
        } else if (targetSt > node.endInd || targetEnd < node.stInd) return 0;
        int leftValue = calculateSum(targetSt, targetEnd, node.left);
        int rightValue = calculateSum(targetSt, targetEnd, node.right);
        return leftValue + rightValue;
    }
}
