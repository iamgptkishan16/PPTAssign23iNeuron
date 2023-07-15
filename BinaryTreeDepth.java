/*
💡 Question-1:

Given preorder of a binary tree, calculate its **[depth(or height)](https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/)** [starting from depth 0]. The preorder is given as a string with two possible characters.

1. ‘l’ denotes the leaf
2. ‘n’ denotes internal node

The given tree can be seen as a full binary tree where every node has 0 or two children. The two children of a node can ‘n’ or ‘l’ or mix of both.

**Examples :**

Input  : nlnll
Output : 2
Explanation :

!https://media.geeksforgeeks.org/wp-content/uploads/btree1.png

Input  : nlnnlll
Output : 3

*/

package Java_DSA.HeapsAndHashing.Assignment23;
public class BinaryTreeDepth {
    public static int calculateDepth(String preorder) {
        int depth = 0;
        int n = preorder.length();

        for (int i = 0; i < n; i++) {
            if (preorder.charAt(i) == 'n') {
                depth++;
            }
        }

        return depth;
    }

    public static void main(String[] args) {
        String preorder = "nlnll";
        int depth = calculateDepth(preorder);
        System.out.println("Depth of the binary tree: " + depth);
    }
}
