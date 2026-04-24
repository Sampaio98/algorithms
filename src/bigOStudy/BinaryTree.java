package bigOStudy;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static java.lang.IO.println;

public class BinaryTree {

    void main() {
        insert(5);
        insert(3);
        insert(1);
        insert(10);
        insert(15);
        insert(7);
        insert(20);

        println("Search 1: " + dfs(1));
        println("Search 6: " + dfs(6));
        println("Pre order traversal: " + preorderTraversal());
        println("In order traversal: " + inOrderTraversal());
        println("Post order traversal: " + postOrderTraversal());
        println("Breadth first search: " + bfs(20));
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

    public boolean dfs(int val) {
        return dfs(val, root);
    }

    private boolean dfs(int val, TreeNode node) {
        if (node == null) return false;
        if (val == node.val) return true;
        if (val < node.val) {
            return dfs(val, node.left);
        }
        return dfs(val, node.right);
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

    private boolean bfs(int target) {
        if (root == null) return false;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var node = queue.poll();
            println(node.val);
            if (node.val == target) return true;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return false;
    }

}
