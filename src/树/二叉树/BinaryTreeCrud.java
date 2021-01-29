package 树.二叉树;

import 树.common.TreeNode;
import 链表.common.ListNode;

public class BinaryTreeCrud {
    public static TreeNode query(TreeNode root, Integer q) {
        if (root == null) return null;
        if (root.data == q) return root;
        if (q > root.data) {
            return query(root.rightNode, q);
        } else {
            return query(root.leftNode, q);
        }
    }

    public static void insert(TreeNode root, Integer q) {
        TreeNode pre = null;
        while (root != null) {
            if (root.data > q) {
                if (root.leftNode == null) {
                    pre.leftNode = new TreeNode(q);
                    return;
                }
                root = root.leftNode;
            } else {
                if (root.rightNode == null) {
                    pre.rightNode = new TreeNode(q);
                    return;
                }
                root = root.rightNode;
            }
        }
    }

    public static void delete(TreeNode root, Integer q) {
        TreeNode node = root;
        TreeNode pnode = null;
        boolean turn = false; //false为左
        while (node != null && node.data != q) {
            if (q > node.data) {
                if (node.rightNode.data == q) {
                    pnode = node;
                    turn = true;
                }
                node = node.rightNode;
            } else {
                if (node.leftNode.data == q) {
                    pnode = node;
                }
                node = node.leftNode;
            }
        }

        if (node == null) return;
        if (pnode==null){
            if (node.rightNode==null&&node.leftNode==null){
                node = null;
                return;
            }
            if (node.leftNode==null&&node.rightNode!=null){
                return;
            }
            if (node.rightNode==null&&node.leftNode!=null){
                if (turn)pnode.rightNode=null;
                else pnode.leftNode=null;
                return;
            }
        }
        //只有一个节点
        if (node.leftNode==null&&node.rightNode!=null){
            if (turn)pnode.rightNode=null;
            else pnode.leftNode=null;
            return;
        }
        if (node.rightNode==null&&node.leftNode!=null){
            if (turn)pnode.rightNode=null;
            else pnode.leftNode=null;
            return;
        }
        //有两个节点
        if (node.rightNode!=null&&node.leftNode!=null){
            if (turn) {pnode.rightNode = node.rightNode;
                pnode.rightNode.leftNode = node.leftNode;
            }else {
                pnode.leftNode = node.rightNode;
                pnode.leftNode.rightNode = node.leftNode;
            }
            return;
        }
        //没有节点
        if (node.rightNode==null&&node.leftNode==null){
            if (turn) pnode.rightNode=null;
            else pnode.leftNode=null;
        }
    }

    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.leftNode);
        System.out.print(root.data + " ");
        inorder(root.rightNode);
    }


    /**
     * 4
     * |   \
     * 3     6
     * |    /  \
     * 2   5    7
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);
        root.leftNode = node1;
        root.rightNode = node2;
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        node1.leftNode = node3;
        node2.leftNode = node4;
        node2.rightNode = node5;
//        System.out.println(query(root, 1));
        inorder(root);
        System.out.println("");
//        insert(root, 1);
        delete(root,4);
        inorder(root);
//        insert(root,9);
    }
}
