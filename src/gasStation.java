package edu.nyu.liangfang.leetcode;

public class gasStation {
	// O(n) solution
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int index = -1;
        int finalGas = 0;	// total accumulate gas
        int gasLeft = 0;	// accumulate gas from a index with positive gas left
        int [] arr = new int[n];
        
        // 先将从每一个点出发到下一点所剩gas算出来，之后只用看这个arr数组就可以
        for (int i = 0; i < n; i++) {
            arr[i] = gas[i] - cost[i];
        }
        
        for (int i = 0; i < n; i++) {
            if (index == -1 ) {		// 如果index是-1表示暂时没有合适的出发点，这时候如果找到一个
                if (arr[i] >= 0) {	// 出发点的arr[i]大于0，就暂时当做从这个点出发
                    index = i;
                    gasLeft = arr[i];
                }
            } else {
            	// 不断计算从暂时的index出发到目前为止剩余的gas， 如果小于0了表示从
            	// index出发不行，重置index为-1
                if (arr[i] + gasLeft < 0) {
                    index = -1;
                } else {
                    gasLeft += arr[i];	
                }
            }
            finalGas += arr[i];	
        }
        
        // 只有finalGas大于0，才表示有可能从一个点走完所有路线
        if (finalGas >= 0) {
            return index;
        }
        return -1;
    }
	
	// more simple
	public int canCompleteCircuit_moresimple(int[] gas, int[] cost) {
        int n = gas.length;
        int index = 0;
        int finalGas = 0;
        int gasLeft = 0;
        int [] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = gas[i] - cost[i];
        }
        
        for (int i = 0; i < n; i++) {
            finalGas += arr[i];
            gasLeft += arr[i];
            if (gasLeft < 0) {	// 找第一个sum大于0的连续子序列
                gasLeft = 0;
                index = i + 1;
            }
        }
        
        if (finalGas >= 0) {
            return index;
        }
        return -1;
    }
	
	// brutal force solution - TLE
	public int canCompleteCircuit_TLE(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int pos = i;
            int step = 0;
            int remain = 0;
            boolean isFound = false;
            while (step < n) {
                if (remain + gas[pos] < cost[pos]) {
                    break;
                }
                remain = remain + gas[pos] - cost[pos];
                step++;
                pos++;
                pos = pos % n;
            }
            if (isFound) {
                return i;
            }
        }
        return -1;
    }
}
