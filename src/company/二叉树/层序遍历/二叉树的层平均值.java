package company.二叉树.层序遍历;

import company.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xiu
 * @create 2023-07-14 19:52
 */
public class 二叉树的层平均值 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode1.left=treeNode3;
        treeNode1.right=treeNode4;
        new 二叉树的层平均值().averageOfLevels(treeNode);

    }
    List<Double> res=new LinkedList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        if (root!=null) help(root);
        return res;
    }
    public void help(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()){
            double sum=0;
            int size = queue.size();
            int temp=size;
            while (size>0){
                TreeNode pop = queue.pop();
                sum+=pop.val;
                if (pop.left!=null) queue.add(pop.left);
                if (pop.right!=null) queue.add(pop.right);
                size--;
            }
            res.add(sum/temp);
        }
    }
}
