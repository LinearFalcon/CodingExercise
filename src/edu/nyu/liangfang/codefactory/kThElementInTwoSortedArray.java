package edu.nyu.liangfang.codefactory;

public class kThElementInTwoSortedArray {
    public int kThElement(int[] A, int[] B, int k) {
        if (k < 1 || k > A.length + B.length) {
            return -1;
        }
        return findKIndexElement(A, 0, A.length - 1, B, 0, B.length - 1, k - 1);
    }

    public int findKIndexElement(int[] A, int aStart, int aEnd, int[] B, int bStart, int bEnd, int k) {
        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;

        if (aLen == 0) {
            return B[bStart + k];
        } else if (bLen == 0) {
            return A[aStart + k];
        }
        if (k == 0) {
            return Math.min(A[aStart], B[bStart]);
        }

        int aMid = (aLen * k) / (aLen + bLen);    // Do NOT write like "aLen / (aLen + bLen) * k",
        int bMid = k - aMid - 1;                // because aLen/(aLen+bLen) will be cast to 0, but actually aLen * k > aLen + bLen sometimes
        aMid += aStart;
        bMid += bStart;


        if (A[aMid] < B[bMid]) {
            k = k - (aMid - aStart + 1);
            aStart = aMid + 1;
            bEnd = bMid;
        } else {
            k = k - (bMid - bStart + 1);
            bStart = bMid + 1;
            aEnd = aMid;
        }

        return findKIndexElement(A, aStart, aEnd, B, bStart, bEnd, k);
    }
}
