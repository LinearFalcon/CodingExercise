package edu.nyu.liangfang.codefactory;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;


public class preorderTraversalIterator implements Iterator<Integer> {
    Stack<Node> st = new Stack<Node>();

    public preorderTraversalIterator(Node root) {
        st.push(root);
    }

    @Override
    public boolean hasNext() {
        return !st.isEmpty();
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            Node n = st.pop();
            if (n.right != null) st.push(n.right);
            if (n.left != null) st.push(n.left);
            return n.val;
        } else {
            throw new NoSuchElementException("No next node!");
        }
    }

}
