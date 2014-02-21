
public class ClimbingStairs {
	public int climbStairs(int n) {
		if (n <= 0)
			return 0;
        int[] arr = new int[n + 1];		// Because we will consider 0 to n, so n + 1 numbers in total
        return climbStairs(n, arr);
    }
    
    public int climbStairs(int n, int[] arr) {
        if (n < 0)				//Corner condition
            return 0;
        else if (n == 0)		// Because when we consider n as 2, then either climb from 1 or climb form 0, each counts as 1
            return 1;
        else if (arr[n] > 0)
            return arr[n];
        int num = climbStairs(n-1, arr) + climbStairs(n-2, arr);
        arr[n] = num;
        return num;
    }
}
