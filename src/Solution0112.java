import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution0112 {

    public static boolean hasPathSumRuntimeOptimized(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSumRuntimeOptimized(root.left, targetSum - root.val) || hasPathSumRuntimeOptimized(root.right, targetSum - root.val);
    }

    public static boolean hasPathSumMemoryOptimized(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(root);
        while (!nodeStack.empty()) {
            TreeNode current = nodeStack.peek();
            if (current.left == null && current.right == null && current.val == targetSum) {
                return true;
            }
            nodeStack.pop();
            if (current.right != null) {
                current.right.val += current.val;
                nodeStack.push(current.right);
            }
            if (current.left != null) {
                current.left.val += current.val;
                nodeStack.push(current.left);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        System.out.println(hasPathSumMemoryOptimized(root, 22));
    }
}
