package edu.nyu.liangfang.codefactory;

/*
  example:
  input:12 
  output:
    1 * 12
    2 * 6
    2 * 2 * 3
    3 * 4

  input:32
  output:
    1 * 32
    2 * 16
    2 * 2 * 8
    2 * 2 * 2 * 4
    2 * 2 * 2 * 2 * 2
    2 * 4 * 4
    4 * 8
*/

public class printFactors {
	public void findFactor(int n) {
        System.out.println("1 * " + n);
        helper(2, "", n);
	}


	public void helper(int start, String str, int n) {
        for (int i = start; i <= Math.sqrt(n); i++) {
                if (n % i == 0 && n / i >= i) {
                        System.out.println(str + i + " * " + n / i);
                        helper(i, str + i + " * ", n / i);
                }
        }
	}
}
