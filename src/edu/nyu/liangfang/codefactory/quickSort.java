package edu.nyu.liangfang.codefactory;

public class quickSort {
	public void quicksort(int[] array) {
		if (array.length == 0) return;
		quicksort(array, 0, array.length - 1);
	}

	private void quicksort(int[] array, int left, int right) {
		int index = partition(array, left, right);
		if (left < index - 1) {		// sort left half, must determine !!!
			quicksort(array, left, index - 1);
		} 
		if (right > index) {		// sort right half, must determine!!!
			quicksort(array, index, right);
		}
	}

	private int partition(int[] array, int left, int right) {
		int pivot = array[(left + right) / 2];	// pick pivot value
		// mind the equal condition !!
		while (left <= right) {
			while (array[left] < pivot) {
				left++;
			}
			while (array[right] > pivot) {
				right--;
			}
			
			if (left <= right) {
				swap(array, left, right);
				left++;
				right--;
			}
		}
		return left;	// mind the return value!!
	}

	private void swap(int[] array, int left, int right) {
		int tmp = array[left];
		array[left] = array[right];
		array[right] = tmp;
	}
}
