package edu.nyu.liangfang.leetcode;

public class compareVersionNumbers {
	// possible input: "1.6.5" "1.6"
	public int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        
        int i = 0;
        while (i < strs1.length && i < strs2.length) {
            int num1 = Integer.valueOf(strs1[i]);
            int num2 = Integer.valueOf(strs2[i]);
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
            i++;
        }
        
        if (i == strs1.length && i == strs2.length) {
            return 0;
        } else if (i == strs1.length && Integer.valueOf(strs2[i]) > 0) {
            return -1;
        } else if (i == strs2.length && Integer.valueOf(strs1[i]) > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
