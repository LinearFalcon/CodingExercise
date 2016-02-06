package edu.nyu.liangfang.leetcode;

public class multiplyStrings {
	// best solution
	public String multiply_Solution1(String num1, String num2) {
		// 先把string翻转  
		String s1 = new StringBuilder(num1).reverse().toString();
        String s2 = new StringBuilder(num2).reverse().toString();
        
        int[] prod = new int[s1.length() + s2.length()];		// 构建数组存放乘积，最多需要n1.length()+n2.length()这么长，不是 length * length !!!
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
            	prod[i + j] += (s1.charAt(i) - '0') * (s2.charAt(j) - '0');	 // 在正确位置累加乘积，利用的就是乘法的运算习惯
            }
        }
        
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prod.length; i++) {
            int num = prod[i] + carry;
            carry = num / 10;
            num = num % 10;
            sb.insert(0, num);
        }
        
        // trim starting zeros, becuase we define products has size of n1.length() + n2.length(),
        // it's possible that tailing element is zero, e.g: multiply("0", "0")
        while (sb.charAt(0) == '0' && sb.length() > 1) {
        	sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}
