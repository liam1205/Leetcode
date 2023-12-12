import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution0100 {
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            System.out.println("1");
            return true;
        }
        if(p == null || q == null){
            System.out.println("2");
            return false;
        }
        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

    //   1         1
    // 2   3     2   3

    //    1             1
    // 2     3       2     3
    //     4   5

}
