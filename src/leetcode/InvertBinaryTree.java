package leetcode;

import utils.TreeNode;

public class InvertBinaryTree {

    void main() {
        TreeNode example1 = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)
                ),
                new TreeNode(7,
                        new TreeNode(6),
                        new TreeNode(9)
                )
        );
        TreeNode example2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode example3 = new TreeNode();

        IO.println(invertTree(example1));
        IO.println(invertTree(example2));
        IO.println(invertTree(example3));
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        var tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }
}
