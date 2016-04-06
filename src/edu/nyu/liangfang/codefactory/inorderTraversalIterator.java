package edu.nyu.liangfang.codefactory;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;


public class inorderTraversalIterator implements Iterator<Integer> {
    Stack<Node> st = new Stack<Node>();

    public inorderTraversalIterator(Node root) {
        pushAllLeftNodes(root);
    }

    // This is important!!!
    public void pushAllLeftNodes(Node node) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }

    @Override
    public boolean hasNext() {
        return !st.isEmpty();
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            Node node = st.pop();
            pushAllLeftNodes(node.right);
            return node.val;
        } else {
            throw new NoSuchElementException("No next node!");
        }
    }

}
