package edu.nyu.liangfang.leetcode;

public class countAndSay {
    //now
    public String countAndSay(int n) {
        String str = "1";                       // special case: first sequence
        for (int i = 2; i <= n; i++) {
            StringBuilder tmp = new StringBuilder();
            int count = 1;
            char pre = str.charAt(0);
            for (int j = 1; j < str.length(); j++) {
                if (str.charAt(j) == str.charAt(j - 1)) 
                    count++;
                else {
                    tmp.append(count).append(pre);
                    pre = str.charAt(j);
                    count = 1;
                }
            }
            tmp.append(count).append(pre);
            str = tmp.toString();
        }
        return str;
    }

    // past
	public String countAndSay2(int n) {
		int count = 1;
        String str = "1";
        
        while (count < n) {
            int num = 0;
            char prev = '\0';
            StringBuilder newStr = new StringBuilder();		// when multiple concatenation of string,
            for (int i = 0; i < str.length(); i++) {		// remember to use StringBuilder
                if (i == 0) {
                    num = 1;
                    prev = str.charAt(i);
                } else if (str.charAt(i) == prev) {
                    num++;
                } else if (str.charAt(i) != prev) {
                    newStr.append(String.valueOf(num)).append(prev);
                    num = 1;
                    prev = str.charAt(i);
                }
            }
            newStr.append(String.valueOf(num)).append(prev);
            str = newStr.toString();
            
            count++;
        }
        return str;    
    }
}
