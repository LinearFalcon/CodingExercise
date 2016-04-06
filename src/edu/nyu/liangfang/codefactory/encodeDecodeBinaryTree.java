package edu.nyu.liangfang.codefactory;

/*
 * Because Binary Tree does not have BST rules, we need to store every node's
 * children, including null node
 */
public class encodeDecodeBinaryTree {
    // encode in pre-order
    public String encode(Node2 root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        encodeHelper(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void encodeHelper(Node2 root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(" ");
        } else {
            sb.append(root.val).append(" ");
            encodeHelper(root.left, sb);
            encodeHelper(root.right, sb);
        }
    }


    // decode using pre-order traverse, if node is null node sign ("#"), we ignore it
    public Node2 decode(String s) {
        String[] a = s.split("\\s");

        int[] index = {0};    // 必须要传一个能够mutable的index进去，因为读输入数组，每次都要保证index[0]++之后会影响后面调用的method
        return decodeHelper(a, index);
    }

    private Node2 decodeHelper(String[] a, int[] index) {
        if (index[0] == a.length) return null;
        if (a[index[0]].equals("#")) return null;        // ignore null node

        Node2 root = new Node2(a[index[0]]);

        index[0]++;                                        // MUST increment index[0] each time before call recursion function,
        root.left = decodeHelper(a, index);                // because we store all children of every node
        index[0]++;
        root.right = decodeHelper(a, index);
        return root;
    }


    // test
    public static void main(String[] args) {
        encodeDecodeBinaryTree o = new encodeDecodeBinaryTree();
        Node2 n = new Node2("30");
        n.left = new Node2("20");
        n.left.left = new Node2("10");
        n.right = new Node2("40");
        n.right.left = new Node2("35");
        n.right.right = new Node2("50");

        String s = o.encode(n);
        System.out.println(s);

        Node2 root = o.decode(s);
        System.out.println(root.left.val);
        System.out.println(root.left.left.val);
        System.out.println(root.right.val);
        System.out.println(root.right.left.val);
        System.out.println(root.right.right.val);
    }
}
