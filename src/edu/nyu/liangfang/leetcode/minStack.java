class MinStack {
    Stack<Integer> st = new Stack<Integer>();
    Stack<Integer> minSt = new Stack<Integer>();

    public void push(int x) {
        st.push(x);
        if (minSt.isEmpty() || x <= minSt.peek()) minSt.push(x);
    }

    public void pop() {
        if (!st.isEmpty()) {
            int x = st.pop();
            if (x == minSt.peek()) minSt.pop();
        }
    }

    public int top() {
        return st.isEmpty() ? -1 : st.peek();
    }

    public int getMin() {
        return minSt.peek();
    }
}
