import java.util.*;

class BinaryTree {

    class Node {

        int value;
        Node left;
        Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    Node root;

    public void buildTree(Scanner scanner) {
        System.out.println("Enter the root node");
        int value = scanner.nextInt();
        root = new Node(value);
        buildTree(scanner, root);
    }

    public void buildTree(Scanner scanner, Node node) {
        System.out.print(
            "Do you want to add new node at left of " + node.value + " : "
        );
        if (scanner.nextBoolean()) {
            System.out.print("Enter the left node value ");
            int value = scanner.nextInt();
            node.left = new Node(value);
            buildTree(scanner, node.left);
        }
        System.out.print(
            "Do you want to add new node at the right of " + node.value + " : "
        );
        if (scanner.nextBoolean()) {
            System.out.print("Enter the right node value ");
            int value = scanner.nextInt();
            node.right = new Node(value);
            buildTree(scanner, node.right);
        }
    }

    public void display() {
        this.display(root, 0);
    }

    private void display(Node node, int level) {
        if (node == null) {
            return;
        }
        display(node.right, level + 1);
        System.out.println("  ".repeat(level) + node.value);
        display(node.left, level + 1);
    }
}
