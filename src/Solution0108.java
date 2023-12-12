public class Solution0108 {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        // null if empty
        if (start > end) {
            return null;
        }
        // middle value
        int mid = (start+end)/2;
        int middle = nums[mid];
        TreeNode root = new TreeNode(middle);

        // left part
        root.left = helper(nums, start, mid - 1);

        // right part
        root.right = helper(nums, mid+1, end);


        return root;
    }
}
