package 树.common;

public class TreeNode {
    public TreeNode leftNode;
    public TreeNode rightNode;
    public Integer data;

    public TreeNode(Integer data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}
