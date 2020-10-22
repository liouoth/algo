package 树.二叉树;

import 树.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.DelayQueue;

public class BinaryTreeTest {

    //层序遍历
    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root==null) return;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode front = queue.poll();
            if (front.leftNode!=null){
                queue.add(front.leftNode);
            }
            if (front.rightNode!=null){
                queue.add(front.rightNode);
            }
            System.out.print(front.data+" ");
        }
    }

    /**
     *          O
     *        /   \
     *       3    4
     *     /    /
     *    5    8
     *    层序遍历：0 3 4 5 8 从末尾层序遍历：5 8 3 4 0
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        root.leftNode = node1;
        root.rightNode = node2;
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(8);
        node1.leftNode = node3;
        node2.leftNode = node4;
        levelOrder(root);
    }
}
