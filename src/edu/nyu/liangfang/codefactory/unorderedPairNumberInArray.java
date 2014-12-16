package edu.nyu.liangfang.codefactory;
import java.util.Arrays;

/*
求array里unordered pair的数量(前一个数比后一个数大)

比如{1, 3, 2}里面有一个(3, 2), {1, 2, 3}里面没有, {3, 2, 1}里面有三个(3, 2) (3, 1) (2, 1)
*/

// 利用merge sort的思想，sort每一半的时候计算返回的是每一半的unordered pair数，然后再在merge
// 的时候返回横跨这两半的unordered pair
public class unorderedPairNumberInArray {
	public static int pairNum(int[] arr) {
		if (arr.length == 0) return 0;
		
		return sortAndCount(arr, 0, arr.length - 1);
	}
	
	private static int sortAndCount(int[] arr, int start, int end) {
		if (start >= end) {	// no pair
			return 0;
		}
		
		int res = 0;
		int mid = start + (end - start) / 2;		// avoid overflow
		res += sortAndCount(arr, start, mid);		// count unordered pair number in first half
		res += sortAndCount(arr, mid + 1, end); 	// count unordered pair number in second half
		res += mergeAndCount(arr, start, mid, end);	// count unordered pair number that num1 is in first half and num2 is in second half
		return res;
	}

	private static int mergeAndCount(int[] arr, int start, int mid, int end) {
		int res = 0;
		int leftRemain = mid - start + 1;					// 方便后面计算
		int[] helper = Arrays.copyOf(arr, arr.length);		// here must be a copy of entire array!!!
		
		int curr = start;
		int left = start;
		int right = mid + 1;
		while (left <= mid && right <= end) {
			if (helper[left] > helper[right]) {		// 因为到调用merge的时候，左右两边都已经是sorted，所以如果helper[left]
				arr[curr++] = helper[right++];		// 大于helper[right]，则left - mid的数都大于helper[right]
				res += leftRemain;
			} else {
				arr[curr++] = helper[left++];
				leftRemain--;
			}
		}
		
		while (left <= mid) {
			arr[curr++] = helper[left++];
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {4,3,1,2,9,3,0,1};
		System.out.println(pairNum(arr));
		for (int i : arr)
			System.out.println(i);
	}
}
