package edu.nyu.liangfang.codefactory;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;


public class postorderTraversalIterator implements Iterator<Integer> {
    Stack<Node> st = new Stack<Node>();
    Node lastVisit = null;

    public postorderTraversalIterator(Node root) {
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
            while (true) {
                Node peek = st.peek();
                if (peek.right != null && lastVisit != peek.right) {
                    pushAllLeftNodes(peek.right);
                } else {
                    int rst = peek.val;
                    lastVisit = peek;
                    st.pop();
                    return rst;
                }
            }
        } else {
            throw new NoSuchElementException("No next node!");
        }
    }

}
