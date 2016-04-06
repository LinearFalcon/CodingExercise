package edu.nyu.liangfang.codefactory;


/* find indices m and n that you sort m to n then entire array is sorted */
public class minRangeToSort_cc150_ch17_6 {
    public void findUnsortedSequence(int[] arr) {
        // find left and right longest increasing sequence
        int end_left = findEndOfLeft(arr);
        int start_right = findStartOfRight(arr);

        if (end_left == arr.length - 1) {    // already sorted
            return;
        }

        // find minIndex and maxIndex in middle
        int minIndex = end_left + 1;    // index of min value in middle range
        int maxIndex = start_right - 1;    // index of max value in middle range
        for (int i = end_left; i <= start_right; i++) {
            if (arr[i] < arr[minIndex]) minIndex = i;
            if (arr[i] > arr[maxIndex]) maxIndex = i;
        }

        int left_index = shrinkLeft(arr, minIndex, end_left);
        int right_index = shrinkRight(arr, maxIndex, start_right);
        System.out.println(left_index + " to " + right_index);
    }

    // find right longest increasing sequence start index
    private int findStartOfRight(int[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1])
                return i + 1;
        }
        return 0;
    }

    // find left longest increasing sequence end index
    private int findEndOfLeft(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return i - 1;
        }
        return arr.length - 1;
    }

    // return end index of sequence that needs to be sorted
    private int shrinkRight(int[] arr, int maxIndex, int start_right) {
        int comp = arr[maxIndex];
        for (int i = start_right; i < arr.length; i++) {
            if (arr[i] > comp)
                return i - 1;
        }
        return arr.length - 1;
    }

    // return start index of sequence that needs to be sorted
    private int shrinkLeft(int[] arr, int minIndex, int end_left) {
        int comp = arr[minIndex];
        for (int i = end_left; i >= 0; i--) {
            if (arr[i] < comp)
                return i + 1;
        }
        return 0;
    }
}
