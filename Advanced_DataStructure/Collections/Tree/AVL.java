class AVL {

    class Node {

        int value;
        Node left;
        Node right;
        int height;

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
        return checkBF(node);
    }

    public int height(Node node) {
        if (node == null) return -1;
        else return node.height;
    }

    public Node checkBF(Node node) {
        Node new_node = node;
        if (height(node) > 1) {
            System.out.println(node.value);
            // left heavy
            if ((height(node.left) - height(node.right)) > 1) {
                Node c = node.left;
                // left(left-left)
                if (height(c.left) > height(c.right)) {
                    new_node = rightRotate(node);
                }
                // right(left-right)
                else {
                    node.left = leftRotate(c);
                    new_node = rightRotate(node);
                }
            }
            // right heavy
            else if ((height(node.left) - height(node.right)) < -1) {
                Node c = node.right;
                // left
                if (height(c.left) > height(c.right)) {
                    node.right = rightRotate(c);
                    new_node = leftRotate(node);
                }
                // right
                else {
                    new_node = leftRotate(node);
                }
            }
        }
        return new_node;
    }

    public Node rightRotate(Node p) {
        Node c = p.left;
        Node t3 = c.right;
        c.right = p;
        p.left = t3;
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        return c;
    }

    public Node leftRotate(Node p) {
        Node c = p.right;
        Node t2 = c.left;
        c.left = p;
        p.right = t2;
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        return c;
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
        System.out.print("  ".repeat(level - 1) + node.left.value);
        System.out.println("  ".repeat(1) + node.right.value);
        // display(node.left, level - 1);
        // display(node.right, (level - 1) + 2);
        display2(node.left, level - 1);
        display2(node.right, level - 1);
    }

    private void display2(Node node, int level) {
        if (node.left == null || node.right == null) {
            return;
        }
        // System.out.println();
        System.out.print("  ".repeat(level - 1) + node.left.value);
        System.out.println("  ".repeat(1) + node.right.value);
        display2(node.left, level - 1);
        display2(node.right, level - 1);
    }
}
