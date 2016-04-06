package edu.nyu.liangfang.leetcode;

public class populatingNextRightPointersInEachNode2 {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        // 找与root同一层的下一个node，这个node是第一个有left或者right的结点，
        // 这样我们才能知道左边子树的结点应该指向右边子树的哪一个
        TreeLinkNode nextRoot = root.next;
        TreeLinkNode next = null;
        // nextRoot如果是null了说明这一层处理完了，否则继续找next
        while (nextRoot != null) {
            if (nextRoot.left != null) {    // 先找左节点
                next = nextRoot.left;
                break;
            } else if (nextRoot.right != null) {
                next = nextRoot.right;
                break;
            } else {
                nextRoot = nextRoot.next;
            }
        }

        // 说明root的right就是root下一层里面最右边的结点
        if (root.right != null) {
            root.right.next = next;    // 跨树相连
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;    // 内部相连
            } else {
                root.left.next = next;    // 跨树相连
            }
        }

        // 一定要先处理右子树再处理左子树,因为我们需要往右找
        connect(root.right);
        connect(root.left);
    }
}
