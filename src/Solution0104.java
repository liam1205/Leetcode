import com.sun.source.tree.Tree;

public class Solution0104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int counterL = maxDepth(root.left);
        int counterR = maxDepth(root.right);

        return 1 + Math.max(counterL, counterR);
    }
}
