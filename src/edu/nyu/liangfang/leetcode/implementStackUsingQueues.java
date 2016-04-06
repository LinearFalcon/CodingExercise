// Push is o(1), pop is O(n); 
class MyStack_1 {
    Queue<Integer> q = new LinkedList<Integer>();
    int top;

    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
        top = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        for (int i = 0; i < q.size() - 1; i++) {
            top = q.poll();
            q.add(top);
        }
        q.poll();
    }

    // Get the top element.
    public int top() {
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}

// Push is O(n), Pop is O(1)
class MyStack_2 {
    Queue<Integer> q = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++)
            q.add(q.poll());
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}