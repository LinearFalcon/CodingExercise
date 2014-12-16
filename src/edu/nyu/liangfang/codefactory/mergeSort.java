package edu.nyu.liangfang.codefactory;

public class mergeSort {
	public void mergesort(int[] array) {
		int[] helper = new int[array.length];
		mergesort(array, helper, 0, array.length - 1);
	}

	private void mergesort(int[] array, int[] helper, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergesort(array, helper, start, mid);
			mergesort(array, helper, mid + 1, end);
			merge(array, helper, start, mid, end);
		}
	}

	private void merge(int[] array, int[] helper, int start, int mid, int end) {
		// copy both halves into helper array
		for (int i = start; i <= end; i++) {
			helper[i] = array[i];
		}
		
		int left = start;
		int right = mid + 1;
		int current = start;	// index of sorted array
		// compare two halves and merge
		while (left <= mid && right <= end) {
			if (helper[left] < helper[right]) {
				array[current] = helper[left];
				left++;
			} else {
				array[current] = helper[right];
				right++;				
			}
			current++;
		}
		
		
		int remaining = mid - left;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = helper[left + i];
		}
	}
}
