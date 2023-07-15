/*
💡 Question-4:

Given a Binary Tree, The task is to print the **bottom view** from left to right. A node **x** is there in output if x is the bottommost node at its horizontal distance. The horizontal distance of the left child of a node x is equal to a horizontal distance of x minus 1, and that of a right child is the horizontal distance of x plus 1.

**Examples:**

**Input:**

             20

           /     \

        8         22

    /      \         \

5         3        25

        /    \

   10       14

**Output:** 5, 10, 3, 14, 25.

**Input:**

             20

           /     \

        8         22

    /      \      /   \

 5         3    4     25

         /    \

     10       14

**Output:**

5 10 4 14 25.

**Explanation:**

If there are multiple bottom-most nodes for a horizontal distance from the root, then print the later one in the level traversal.

**3 and 4** are both the bottom-most nodes at a horizontal distance of 0, we need to print 4.

*/

package Java_DSA.HeapsAndHashing.Assignment23;
import java.util.*;

class Node {
    int data;
    int hd; // Horizontal distance
    Node left, right;

    Node(int item) {
        data = item;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}

class BottomViewBinaryTree {
    Node root;

    void printBottomView() {
        if (root == null)
            return;

        int hd = 0; // Horizontal distance of root node
        Map<Integer, Integer> map = new TreeMap<>();

        Queue<Node> queue = new LinkedList<>();
        root.hd = hd;
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            hd = node.hd;

            // Update the horizontal distance in the map
            map.put(hd, node.data);

            if (node.left != null) {
                node.left.hd = hd - 1;
                queue.add(node.left);
            }
            if (node.right != null) {
                node.right.hd = hd + 1;
                queue.add(node.right);
            }
        }

        // Print the bottom view
        for (int value : map.values()) {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        BottomViewBinaryTree tree = new BottomViewBinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(25);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        System.out.println("Bottom View of Binary Tree:");
        tree.printBottomView();
    }
}
