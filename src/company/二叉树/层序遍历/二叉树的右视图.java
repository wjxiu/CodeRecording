package company.二叉树.层序遍历;

import company.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-14 19:48
 */
public class 二叉树的右视图 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        help(root);
        return list;
    }
    public void help(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int temp = 0;
            while (size > 0) {
                TreeNode pop = queue.pop();
                if (pop.left != null) queue.add(pop.left);
                if (pop.right != null) queue.add(pop.right);
                if (size==1){
                    temp=pop.val;
                }
                size--;
            }
            list.add(temp);
        }
    }
}
