package company.二叉树;

import company.公共类.TreeNode;

/**
 * @author xiu
 * @create 2023-07-15 10:38
 */
public class 找树左下角的值 {
    int res = -1;
    int maxdepth = Integer.MIN_VALUE;

    public int findBottomLeftValue(TreeNode root) {
        help(root, 0);
        return res;
    }

    public void help(TreeNode root, int depth) {
        if (root == null) return;
        if (maxdepth > depth) {
            res = root.val;
            maxdepth = depth;
        }
        if (root.left != null) {
            help(root.left, depth + 1);
        }
        if (root.right != null) {
            help(root.right, depth + 1);
        }
        depth -= 1;
    }
}
