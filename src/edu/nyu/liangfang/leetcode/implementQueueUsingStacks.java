class implementQueueUsingStacks {
    Stack<Integer> inSt = new Stack<Integer>();
    Stack<Integer> outSt = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        inSt.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (outSt.isEmpty()) {
            while (!inSt.isEmpty())
                outSt.push(inSt.pop());
        }
        outSt.pop();
    }

    // Get the front element.
    public int peek() {
        if (outSt.isEmpty()) {
            while (!inSt.isEmpty())
                outSt.push(inSt.pop());
        }
        return outSt.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return inSt.isEmpty() && outSt.isEmpty();
    }
}