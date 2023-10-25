package com.company.二叉树.二叉搜索树;

import com.company.公共类.TreeNode;
import javafx.concurrent.Task;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.IntStream;

/**
 * @author xiu
 * @create 2023-07-16 14:21
 */
public class 修剪二叉搜索树 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.geneTree(new Integer[]{3,0,4,null,2,null,null,1});
        TreeNode treeNode1 = trimBST1(treeNode, 1, 3);
        System.out.println(Arrays.toString(TreeNode.parse(treeNode1)));
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return root;
        if (root.val < low) {
//            递归右子树
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left=trimBST(root.left,low,high);
        root.right=trimBST(root.right,low,high);
        return root;
    }

    static TreeNode trimBST1(TreeNode root, int low, int high){
       if(root==null)return null;
       if (root.val<low){
          return trimBST1(root.right,low,high);
       } if (root.val>high) {
           return trimBST1(root.left, low, high);
       }
       root.left=trimBST1(root.left, low, high);
       root.right=trimBST1(root.right, low, high);
        return root;
    }

}
class HashMapGetUnsafeExample {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            Thread thread = Thread.currentThread();
            thread.interrupt();
            for (int i = 0; i < 3; i++) {
//                LockSupport.unpark(thread);
                //此时park之后会让线程陷入阻塞状态，需要调用unpark之后才会继续运行
                System.out.printf("第%d次阻塞前%n",i);
                LockSupport.park();
                System.out.printf("第%d次阻塞后%n",i);
            }
        },"t1");
        t1.start();
        Thread.sleep(100);
        for (int i = 0; i < 3; i++) {
            System.out.printf("第%d次取消阻塞前%n",i);
            LockSupport.unpark(t1);
            System.out.printf("第%d次取消阻塞后%n",i);
        }
    }
}
class JDKThreadPoolExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        Runnable r=()->{
            for (int i = 0; i < 100000000; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread interrupted. Exiting.");
                    return; // 退出循环和线程
                }
                System.out.println(i);
            }
        };
        SubClass2 subClass2 = new SubClass2();

    }
}
final class SubClass2  {
    int a=10;
    int b;
    private final void privateEat() {//编译通过，但这并不是真正的重写

    }
}