class BSTWithHeight {

    class Node {

        int value;
        Node left;
        int height;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, int height) {
            this.value = value;
            this.height = height;
        }
    }

    Node root;

    private void buildTree(int value) {
        root = buildTree(root, value);
    }

    private Node buildTree(Node node, int value) {
        if (node == null) {
            return new Node(value, 0);
        } else {
            if (value < node.value) {
                node.left = buildTree(node.left, value);
                System.out.println(
                    "left of the node : " +
                    node.value +
                    " is : " +
                    node.left.value
                );
                node.height = Math.max(node.height, node.left.height + 1);
            } else {
                node.right = buildTree(node.right, value);
                System.out.println(
                    "right of the node : " +
                    node.value +
                    " is : " +
                    node.right.value
                );
                node.height = Math.max(node.height, node.right.height + 1);
            }
        }
        return node;
    }

    public void insert(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            buildTree(nums[i]);
        }
    }

    private void preOrder(Node node) {
        if (node == null) return;
        System.out.println("node : " + node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void travarsePreOrder() {
        preOrder(this.root);
    }

    // inOrder is used to retrieve data in sorted manner

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println("node : " + node.value);
        inOrder(node.right);
    }

    public void travarseInOrder() {
        inOrder(this.root);
    }

    // for deleting a tree or branch or upto a level it is used, post-fix notation of an expression tree etc...

    private void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println("node : " + node.value);
    }

    public void travarsePostOrder() {
        postOrder(this.root);
    }

    public void display() {
        display(root, root.height);
    }

    private void display(Node node, int level) {
        if (node == null) {
            return;
        }
        System.out.println("  ".repeat(level) + node.value);
        display(node.left, level - 1);
        display(node.right, (level - 1) + 2);
    }
}
