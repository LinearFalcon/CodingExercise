package edu.nyu.liangfang.leetcode;

public class multiplyStrings {
	// best solution
	public String multiply_Solution1(String num1, String num2) {
		// 先把string翻转  
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();
        
        int[] products = new int[n1.length() + n2.length()];		// 构建数组存放乘积，最多需要n1.length()+n2.length()这么长
        for (int i = 0; i < n1.length(); i++) {
            for (int j = 0; j < n2.length(); j++) {
                products[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');	 // 在正确位置累加乘积，利用的就是乘法的运算习惯
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < products.length; i++) {
            int curr = products[i] + carry;
            carry = curr / 10;
            int digit = curr % 10;
            sb.insert(0, digit);
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        
        // trim starting zeros, becuase we define products has size of n1.length() + n2.length(),
        // it's possible that tailing element is zero, e.g: multiply("0", "0")
        while (sb.charAt(0) == '0' && sb.length() > 1) {
        	sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
	
	
	// my solution
	public String multiply_Solution2(String num1, String num2) {
//		if (num1 == "0" || num2 == "0") {
//            return "0";
//		}
        
        String[] products = new String[10];
        String result = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            int x = num2.charAt(i) - '0';
            
            String intermediate = null;
            if (products[x] != null) {
                intermediate = products[x];
            } else {
                intermediate = multiplyDigit(x, num1);
                products[x] = intermediate;
            }
            
//            if (intermediate != "0") {
            if (!(intermediate.length() == 1 && intermediate.charAt(0) == '0')) {		// intermediate == 0 does not works ????????????
	            for (int j = 0; j < num2.length() - i - 1; j++) {
	                intermediate += "0";
	            }
            }
                        
            result = addTwoString(result, intermediate);
         
        }
        return result;
    }
    
    private String multiplyDigit(int x, String num) {
        if (x == 0) return "0";
        
        String product = "";
        int carry = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';
            int curr = digit * x + carry;
            carry = curr / 10;
            curr = curr % 10;
            product = String.valueOf(curr) + product;
        }
        if (carry != 0) {
            product = String.valueOf(carry) + product;
        }
        return product;
    }
    
    public String addTwoString(String s1, String s2) {  	
        if (s1 == "0" || s2 == "0") {
            return s1 == "0" ? s2 : s1;
        }
        
        String sum = "";
        int diffOfLength = Math.abs(s2.length() - s1.length());
        if (s1.length() > s2.length()) {
            for (int i = 0; i < diffOfLength; i++) {
                s2 = "0" + s2;
            }
        } else {
            for (int i = 0; i < diffOfLength; i++) {
                s1 = "0" + s1;
            }
        }
        
        int carry = 0;
        for (int i = s1.length() - 1; i >= 0; i--) {
            int d1 = s1.charAt(i) - '0';
            int d2 = s2.charAt(i) - '0';
            int curr = d1 + d2 + carry;
            carry = curr / 10;
            curr = curr % 10;
            sum = String.valueOf(curr) + sum;
        }
        if (carry != 0) {
            sum = String.valueOf(carry) + sum;
        }
                
        return sum;
    }
}
