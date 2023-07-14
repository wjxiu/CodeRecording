package company.二叉树.层序遍历;

import company.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-14 17:58
 */
public class 层序遍历 {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root!=null){
            help(root);
        }
        return list;
    }

    public void help(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while (size > 0) {
                TreeNode pop = queue.pop();
                if (pop.left != null) queue.add(pop.left);
                if (pop.right != null) queue.add(pop.right);
                if (size==1){
                    temp.add(pop.val);
                }
                size--;
            }
            list.add(temp);
        }
    }
}
