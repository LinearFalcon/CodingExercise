package edu.nyu.liangfang.codefactory;

class NodeP {    // with parent variable
    public int val;
    public NodeP left;
    public NodeP right;
    public NodeP parent;

    public NodeP(int x) {
        val = x;
    }
}

public class lowestCommonAncestor {
    // No parent pointer version
    public boolean cover(Node2 root, Node2 node) {
        if (root == null)
            return false;
        if (root == node)
            return true;
        return cover(root.left, node) || cover(root.right, node);
    }

    public Node2 lca(Node2 root, Node2 n1, Node2 n2) {
        if (root == null || n1 == null || n2 == null)
            return null;
        if (root == n1 || root == n2) {
            return root;
        }

        boolean n1_on_left = cover(root.left, n1);
        boolean n2_on_left = cover(root.left, n2);

        if (n1_on_left != n2_on_left) {
            return root;
        }
        return n1_on_left ? lca(root.left, n1, n2) : lca(root.right, n1, n2);
    }


    // with parent pointer version, O(h) time, O(1) space
    public NodeP lca_parent(NodeP n1, NodeP n2) {
        if (n1 == null || n2 == null) {
            return null;
        }

        int h1 = height(n1);
        int h2 = height(n2);

        NodeP p = h1 < h2 ? n1 : n2;    // higher node
        NodeP q = h1 < h2 ? n2 : n1;    // deeper node
        int diff = Math.abs(h1 - h2);

        for (int i = 0; i < diff; i++) {
            q = q.parent;
        }

        while (p != null && q != null) {
            if (p == q) return p;
            p = p.parent;
            q = q.parent;
        }
        return null;

    }

    private int height(NodeP n) {
        int height = 0;
        while (n != null) {
            height++;
            n = n.parent;
        }
        return height;
    }
}
