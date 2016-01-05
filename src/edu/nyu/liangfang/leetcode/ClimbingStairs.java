package edu.nyu.liangfang.leetcode;

public class ClimbingStairs {
	// iterative solution
    public int climbStairs_iterative(int n) {
        if (n <= 0) return 0;
        
        int[] map = new int[n + 1];
        map[0] = 1;
        map[1] = 1;
        for (int i = 2; i <= n; i++) {
            map[i] = map[i - 1] + map[i - 2];
        }
        return map[n];
    }

    // recursion solution
    public int climbStairs_recursion(int n) {
		if (n <= 0) 
            return 0;
        
        int[] map = new int[n + 1];
        map[0] = 1;
        map[1] = 1;
        return res(n, map);
    }
    
    private int res(int n, int[] map) {
        if (map[n] > 0) 
            return map[n];
        int r = res(n - 1, map) + res(n - 2, map);
        map[n] = r;
        return r;
    }


    // Simple recursion solution - no dynamic programming
    public int climbStairs_simple(int n) {
        if (n == 0 || n == 1) return 1;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
