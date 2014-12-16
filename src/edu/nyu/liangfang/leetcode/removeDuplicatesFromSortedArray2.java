package edu.nyu.liangfang.leetcode;

public class removeDuplicatesFromSortedArray2 {
	public int removeDuplicates(int[] A) {
    if (A.length == 0)
        return 0;
    
    int newTail = 0;
    int index = 1;
    int repeatNum = 0;
    while (index < A.length) {
        if (A[newTail] != A[index]) {
            newTail++;
            A[newTail] = A[index];
            repeatNum = 0;
        } else {
            repeatNum++;
            if (repeatNum < 2) {
                newTail++;
                A[newTail] = A[index];
            }
        }
        index++;
    }
    return newTail + 1;
	}
}
