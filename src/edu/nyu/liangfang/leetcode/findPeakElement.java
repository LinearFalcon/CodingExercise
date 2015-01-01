package edu.nyu.liangfang.leetcode;

public class findPeakElement {
	// Best O(lgn) solution
	// 这个题目要求时间复杂度为O(log(N))，可以利用二分查找来做，只是这里更新搜索区间的时候不太一样：如果到mid的前一步是上坡而mid的下一步是下坡，
	// 那么mid即是山顶；如果mid的前一步和后一步都是上坡，那么山顶必然位于后半区间；如果mid的前一步和后一步都是下坡，那么山顶必然位于前半区间。
	// 除此之外，还需要处理边界问题。
	public int findPeakElement(int[] num) {
        int low = 0;
        int high = num.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean isUpForward = (mid == 0 ? true : num[mid] > num[mid - 1]);
            boolean isUpAfter = (mid == num.length - 1 ? false : num[mid] < num[mid + 1]);
            
            if (isUpForward && !isUpAfter) {
                return mid;
            } else if (isUpForward && isUpAfter) {
                low = mid + 1;
            } else {
                high = mid - 1; // if both is downhill or num[mid] is less than both side, choose left,
            }                   // because we must can find a peak on left even if less than both
        }
        return -1;
    }
	
	// my O(lgn) solution
	public int findPeakElement_lgn(int[] num) {
        int left = 0; 
        int right = num.length - 1;
        if (num.length == 1 || num[left] > num[left + 1]) {
            return left;
        } else if (num[right] > num[right - 1]) {
            return right;
        }
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) {
                return mid;
            } else if (num[mid] < num[mid - 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return -1;
    }
	
	
	// O(n) solution
	public int findPeakElement_On(int[] num) {
        for (int i = 0; i < num.length; i++) {
            boolean bigL = true;
            boolean bigR = true;
            if (i > 0 && num[i] <= num[i - 1]) {
                bigL = false;
            }
            if (i < num.length - 1 && num[i] <= num[i + 1]) {
                bigR = false;
            }
            
            if (bigL && bigR) {
                return i;
            }
        }
        return -1;
    }
}
