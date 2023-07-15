/*
💡 Question-3:

Given a Binary Tree, print the Right view of it.

The right view of a Binary Tree is a set of nodes visible when the tree is visited from the Right side.

**Examples:**

**Input:**

         1

      /     \

   2         3

/   \       /  \

4     5   6    7

             \

               8

**Output**: 

Right view of the tree is 1 3 7 8

**Input:**

         1

       /

    8

  /

7

**Output**: 

Right view of the tree is 1 8 7

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

class RightViewBinaryTree {
    Node root;
    int maxLevel = 0;

    void printRightView() {
        printRightViewUtil(root, 1);
    }

    void printRightViewUtil(Node node, int level) {
        if (node == null) {
            return;
        }

        if (level > maxLevel) {
            System.out.print(node.data + " ");
            maxLevel = level;
        }

        printRightViewUtil(node.right, level + 1);
        printRightViewUtil(node.left, level + 1);
    }

    public static void main(String[] args) {
        RightViewBinaryTree tree = new RightViewBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.right.left.left = new Node(7);

        System.out.println("Right View of Binary Tree:");
        tree.printRightView();
    }
}
