import java.util.ArrayList;
import java.util.List;

public class Solution0101 {
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            System.out.println("1");
            return true;
        }
        if(root.left == null && root.right == null){
            System.out.println("2");
            return true;
        }
        List<Integer> listLeft = new ArrayList<>();
        helperLeft(root.left,listLeft);
        List<Integer> listRight = new ArrayList<>();
        helperRight(root.right,listRight);

        printList(listLeft);
        System.out.print(", ");
        printList(listRight);
        System.out.println();

        if(listLeft.size() != listRight.size()) {
            return false;
        }
        return listLeft.equals(listRight);
    }

    private void helperLeft(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(-1);
            return;
        }
        list.add(root.val);
        helperLeft(root.left, list);
        helperRight(root.right, list);
    }
    private void helperRight(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(-1);
            return;
        }
        list.add(root.val);
        helperRight(root.right, list);
        helperLeft(root.left, list);
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
}
