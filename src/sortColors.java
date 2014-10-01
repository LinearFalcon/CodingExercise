package edu.nyu.liangfang.leetcode;

public class sortColors {
	// 1 pass and constant space
	public void sortColors(int[] A) {
        int left = 0;
        int right = A.length - 1;
        
        // left means first non zero number index from left
        while (left < right && A[left] == 0) {
            left++;
        }
     // right means first non 2 number index from right
        while (left < right && A[right] == 2) {
            right--;
        }
        
        if (left < right) {
            int index = left;
            while (index <= right) {
                if (A[index] == 1) {
                    index++;
                } else if (A[index] == 2) {
                    swap(A, index, right);
                    right--;
                } else if (A[index] == 0) {
                    swap(A, index, left);
                    left++;
                    index++;	// must! because previous has been processed, 
                    			// 2 is impossible here
                }
            }
        }
    }
    
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
	
	// 2 pass and O(n) space
	public void sortColors_2pass(int[] A) {
        int[] num = new int[3];
        for (int i = 0; i < A.length; i++) {
            num[A[i]]++;
        }
        
        int index = 0;
        for (int i = 0; i < 3; i++) {
            while (num[i] > 0) {
                A[index] = i;
                num[i]--;
                index++;
            }
        }
    }
}
