class BST {

    class Node {

        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    Node root;

    private void buildTree(int value) {
        root = buildTree(root, value);
    }

    private Node buildTree(Node node, int value) {
        if (node == null) {
            return new Node(value);
        } else {
            if (value < node.value) {
                node.left = buildTree(node.left, value);
                System.out.println(
                    "left of the node : " +
                    node.value +
                    " is : " +
                    node.left.value
                );
            } else {
                node.right = buildTree(node.right, value);
                System.out.println(
                    "right of the node : " +
                    node.value +
                    " is : " +
                    node.right.value
                );
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
}
