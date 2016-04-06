public class serializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        sb.append(root.val).append(',');
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
                sb.append(node.left.val).append(',');
            } else {
                sb.append('#').append(',');
            }
            if (node.right != null) {
                queue.offer(node.right);
                sb.append(node.right.val).append(',');
            } else {
                sb.append('#').append(',');
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] list = data.split(",");
        int point = 0;
        TreeNode root = new TreeNode(Integer.valueOf(list[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            point++;
            TreeNode left = list[point].equals("#") ? null : new TreeNode(Integer.valueOf(list[point]));
            point++;
            TreeNode right = list[point].equals("#") ? null : new TreeNode(Integer.valueOf(list[point]));
            node.left = left;
            node.right = right;

            if (left != null) queue.offer(left);
            if (right != null) queue.offer(right);
        }
        return root;
    }
}