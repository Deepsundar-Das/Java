import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreePrinter {

    /**
     * Represents a single node in the binary tree.
     */
    static class Node {

        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // A placeholder value for empty spots in the tree structure.
    private static final int PLACEHOLDER = Integer.MIN_VALUE;

    /**
     * The main public method to print the tree.
     * It orchestrates the printing process level by level.
     *
     * @param root The root node of the tree to be printed.
     */
    public void printTree(Node root) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        int height = getHeight(root);
        for (int i = 0; i < height; i++) {
            printRow(root, height, i);
        }
    }

    /**
     * Prints a single row or level of the tree.
     * This includes the connecting branches and the node values.
     *
     * @param root   The root of the tree.
     * @param height The total height of the tree.
     * @param depth  The current depth (level) to print.
     */
    private void printRow(Node root, int height, int depth) {
        List<Integer> vec = new ArrayList<>();
        getLine(root, depth, vec);

        // Calculate initial spacing for the current row
        int spacing = (int) Math.pow(2, height - depth - 1);

        // Print spaces before the first element
        printSpaces(spacing * 2);

        // Print the connecting branches (/ and \) for the current level
        if (vec.size() > 1) {
            for (int val : vec) {
                if (val != PLACEHOLDER) {
                    System.out.print("/");
                    printSpaces(spacing * 4 - 2);
                    System.out.print("\\ ");
                } else {
                    printSpaces(spacing * 4);
                }
            }
            System.out.println();
        }

        // Print spaces before the first element again for the values
        printSpaces(spacing * 2);

        // Print the node values for the current level
        for (int val : vec) {
            if (val != PLACEHOLDER) {
                System.out.print(val);
                // Adjust spacing for multi-digit numbers
                printSpaces(spacing * 4 - String.valueOf(val).length());
            } else {
                // Print spaces for placeholder nodes
                printSpaces(spacing * 4);
            }
        }
        System.out.println();
    }

    /**
     * Recursively collects the values at a specific depth (level) of the tree.
     *
     * @param node   The current node being visited.
     * @param depth  The target depth to collect values from.
     * @param values The list to store the collected values.
     */
    private void getLine(Node node, int depth, List<Integer> values) {
        // Base case: If we are at the target depth, add the node's value.
        if (depth == 0) {
            if (node != null) {
                values.add(node.val);
            } else {
                values.add(PLACEHOLDER);
            }
            return;
        }

        // Recursive step: Go to the next level.
        if (node != null) {
            getLine(node.left, depth - 1, values);
            getLine(node.right, depth - 1, values);
        } else {
            // If the current node is null, we need to add placeholders for its children
            // to maintain the tree's structure.
            int numPlaceholders = (int) Math.pow(2, depth);
            for (int i = 0; i < numPlaceholders; i++) {
                values.add(PLACEHOLDER);
            }
        }
    }

    /**
     * Calculates the height of the tree.
     * The height is the number of nodes along the longest path from the root node
     * down to the farthest leaf node.
     *
     * @param node The root node of the tree.
     * @return The height of the tree.
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    /**
     * A simple helper method to print a specified number of spaces.
     * @param count The number of spaces to print.
     */
    private void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    /**
     * The main method to demonstrate the tree printing functionality.
     */
    public static void main(String[] args) {
        // Create a new instance of our printer
        BinaryTreePrinter printer = new BinaryTreePrinter();

        // Build a sample binary tree
        Node root = new Node(50);
        root.left = new Node(25);
        root.right = new Node(75);
        // root.left.left = new Node(12);
        // root.left.right = new Node(37);
        // root.right.left = new Node(62);
        // root.right.right = new Node(87);
        // root.left.right.left = new Node(30);

        System.out.println("--- Printing a Pretty Vertical Tree ---");

        // Call the printTree method to display the tree
        printer.printTree(root);
    }
}
