package bigOStudy;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    void main() {
        insert(5);
        insert(3);
        insert(1);
        insert(10);
        insert(15);
        insert(7);

        IO.println("Search 1: " + search(1));
        IO.println("Search 6: " + search(6));
        IO.println("Pre order traversal: " + preorderTraversal());
        IO.println("In order traversal: " + inOrderTraversal());
        IO.println("Post order traversal: " + postOrderTraversal());
    }

    TreeNode root;

    public void insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }
        if (val < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insertRecursive(val, root.left);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insertRecursive(val, root.right);
            }
        }
    }

    private void insertRecursive(int val, TreeNode node) {
        if (val < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else {
                insertRecursive(val, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else {
                insertRecursive(val, node.right);
            }
        }
    }

    public boolean search(int val) {
        return searchRecursive(val, root);
    }

    private boolean searchRecursive(int val, TreeNode node) {
        if (node == null) return false;
        if (val == node.val) return true;
        if (val < node.val) {
            return searchRecursive(val, node.left);
        }
        return searchRecursive(val, node.right);
    }

    public List<Integer> preorderTraversal() {
        List<Integer> result = new ArrayList<>();
        preorderTraversalRecursive(root, result);
        return result;
    }

    private void preorderTraversalRecursive(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            preorderTraversalRecursive(node.left, result);
            preorderTraversalRecursive(node.right, result);
        }
    }

    public List<Integer> inOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        inOrderTraversalRecursive(root, result);
        return result;
    }

    private void inOrderTraversalRecursive(TreeNode node, List<Integer> result) {
        if (node != null) {
            inOrderTraversalRecursive(node.left, result);
            result.add(node.val);
            inOrderTraversalRecursive(node.right, result);
        }
    }

    public List<Integer> postOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        postOrderTraversalRecursive(root, result);
        return result;
    }

    private void postOrderTraversalRecursive(TreeNode node, List<Integer> result) {
        if (node != null) {
            postOrderTraversalRecursive(node.left, result);
            postOrderTraversalRecursive(node.right, result);
            result.add(node.val);
        }
    }

}
