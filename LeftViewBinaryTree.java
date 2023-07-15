/*
💡 Question-2:

Given a Binary tree, the task is to print the **left view** of the Binary Tree. The left view of a Binary Tree is a set of leftmost nodes for every level.

**Examples:**

***Input:***

            4

          /   \

        5     2

             /   \

            3     1

           /  \

          6    7

***Output:** 4 5 3 6*

**Explanation:**

!https://media.geeksforgeeks.org/wp-content/cdn-uploads/left-view.png

***Input:***

                    1

                  /   \

                2       3

                 \

                   4

                     \

                        5

                           \

                             6

**Output:** 1 2 4 5 6

 */
package Java_DSA.HeapsAndHashing.Assignment23;


class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class LeftViewBinaryTree {
    Node root;
    int maxLevel = 0;

    void printLeftView() {
        printLeftViewUtil(root, 1);
    }

    void printLeftViewUtil(Node node, int level) {
        if (node == null) {
            return;
        }

        if (level > maxLevel) {
            System.out.print(node.data + " ");
            maxLevel = level;
        }

        printLeftViewUtil(node.left, level + 1);
        printLeftViewUtil(node.right, level + 1);
    }

    public static void main(String[] args) {
        LeftViewBinaryTree tree = new LeftViewBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Left View of Binary Tree:");
        tree.printLeftView();
    }
}
