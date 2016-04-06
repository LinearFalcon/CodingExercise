public class kthLargestElementInAnArray {
    // naive solution with sort - O(nlgn)
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // min-heap method O(nlgk) 
    // This method is slower than minheap2 method, due to more poll operation
    public int findKthLargest_minheap1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int n : nums) {
            queue.offer(n);
            if (queue.size() > k)
                queue.poll();
        }
        return queue.peek();
    }

    public int findKthLargest_minheap2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int n : nums) {
            if (queue.size() < k) queue.offer(n);
            else if (n > queue.peek()) {
                queue.offer(n);
                queue.poll();
            }
        }
        return queue.peek();
    }


    // O(n) solution

}