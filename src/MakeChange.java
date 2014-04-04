
/*
 * CTCI Chap 9 9.8
 */
public class MakeChange {				
	public int makeChange(int n) {			//相当于依次排列下来，因为顺序不考虑，所以对于11，（10，1）和（1，10）是一样的，因此就是从只有1个quarter，2个quarter ... 到没法再用quater，然后每一层再排dime，这样就不考虑重复的
		int[] denoms = {25, 10, 5, 1};
		return makeChange(n, denoms, 0);
	}
	
	public int makeChange(int amount, int[] denoms, int index) {	//相当于计算这棵树有多少个叶子结点
		if (index >= denoms.length - 1)								//tree的第一层减25，再下一层减10，依次，到1得时候，因为后面没有选择，所以返回1
			return 1;
		int denomAmount = denoms[index];
		int ways = 0;
		for (int i = 0; i * denomAmount <= amount; i++) {
			int remaining = amount - i * denomAmount;
			ways += makeChange(remaining, denoms, index + 1);
		}
		return ways;
	}
}
