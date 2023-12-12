import java.util.ArrayList;
import java.util.List;

public class Solution0094 {

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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        return helper(root, list);
    }

    private List<Integer> helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        if (root.left != null) {
            helper(root.left, list);
        }

        list.add(root.val);

        if(root.right != null) {
            helper(root.right, list);
        }

        return list;
    }

    public static void main(String[] args) {
    }

    private static void printList(List<Integer> array) {
        System.out.print("[");

        for (int i = 0; i < array.size(); i++) {
            if (i == array.size() - 1) {
                System.out.print(array.get(i));
            } else {
                System.out.print(array.get(i) + ", ");
            }
        }

        System.out.print("]");
    }

    // in order:
    //       4
    //   2       6
    // 1   3   7   8

    //       1
    //   n       2
    // n   n   3   n

}
