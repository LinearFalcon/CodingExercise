package edu.nyu.liangfang.leetcode;

/*
 * For case where AL == AM == AR, the minimum could be on AM’s left or right side 
 * (eg, [1, 1, 1, 0, 1] or [1, 0, 1, 1, 1]). In this case, we could not discard 
 * either subarrays and therefore such worst case degenerates to the order of O(n).
 */
public class findMinimumInRotatedSortedArray2 {
	// Simple iterative code
	public int findMin(int[] num) {
        int left = 0; 
        int right = num.length - 1;
        // num[left] > num[right]说明数组不是全部increasing order
        while (left < right && num[left] >= num[right]) {
            int mid = (left + right) / 2;
            if (num[mid] > num[right]) {		// left part is in increasing order, so we check right part for min value
                left = mid + 1;
            } else if (num[mid] < num[left]) {	// right part is in increasing order, so we check left part for min value, mind mid might be min index, so right = mid not mid - 1;
                right = mid;
            } else {    // num[left] == num[mid] == num[right], cannot determine
                left++;
            }
        }
        return num[left];
    }
	
	
	
	// My AC code - too complicated
	public int findMin2(int[] num) {
        return findMin(num, 0, num.length - 1);
    }
    
    public int findMin(int[] num, int left, int right) {
        int mid = (left + right) / 2;
        if (mid == left || mid == right) {
            return Math.min(num[left], num[right]);
        }
        
        if (num[left] < num[mid]) {
            if (num[mid] <= num[right]) {
                return num[left];
            } else {
                return findMin(num, mid + 1, right);
            }
        } else if (num[left] == num[mid]) {
            if (num[mid] < num[right]) {
                return num[left];
            } else if (num[mid] > num[right]) {
                return findMin(num, mid + 1, right);
            } else {
                return Math.min(findMin(num, left, mid), findMin(num, mid, right)); 	// eg, [1, 1, 1, 0, 1] or [1, 0, 1, 1, 1], cannot determine, must compute both half
            }
        } else {
            if (num[mid - 1] <= num[mid]) {
                return findMin(num, left, mid - 1);
            } else {
                return num[mid];
            }
        }
    }
}
