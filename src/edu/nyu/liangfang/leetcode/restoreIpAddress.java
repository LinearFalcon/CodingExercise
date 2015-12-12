package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class restoreIpAddress {
	
	// Iterate method
	public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<String>();
        
        for (int i = 1; i <= 3; i++) {
            for (int j = i + 1; j <= i + 3; j++) {
                for (int k = j + 1; k <= j + 3; k++) {
                    if (k <= s.length() - 1 && k >= s.length() - 3) {
                        String s1 = s.substring(0, i);
                        String s2 = s.substring(i, j);
                        String s3 = s.substring(j, k);
                        String s4 = s.substring(k);
                        
                        System.out.println(s1);
                        System.out.println(s2);
                        System.out.println(s3);
                        System.out.println(s4);
                        // 0.0.0.0 is right, 0.01.100.00 is wrong
                        if (
                                !((s1.charAt(0) == '0' && s1.length() > 1) || (s2.charAt(0) == '0' && s2.length() > 1) ||
                                  (s3.charAt(0) == '0' && s3.length() > 1) || (s4.charAt(0) == '0' && s4.length() > 1)) &&
                                Integer.valueOf(s1) < 256 && Integer.valueOf(s2) < 256 &&
                                Integer.valueOf(s3) < 256 && Integer.valueOf(s4) < 256) {
                                list.add(s1 + "." + s2 + "." + s3 + "." + s4);        
                            }
                    }
                }
            }
        }
        return list;
    }
	
	// Recursion method
	public List<String> restoreIpAddresses_recursion(String s) {
        List<String> result = new ArrayList<String>();
        findIPAddress(result, s, "", 0);
        return result;
    }
    
    public void findIPAddress(List<String> result, String s, String curr, int level) {
        if (level == 4) {
            if (s.length() == 0) {
                result.add(curr.substring(0, curr.length() - 1));
            }
            return;
        }


        for (int i = 1; i <= 3; i++) {
            if (s.length() >= i) {				// must make sure !!!!!!
                String sub = s.substring(0, i);
                int num = Integer.valueOf(sub);
                if (!((i > 1 && sub.charAt(0) == '0') || num >= 256)) {		// cannot have string like "020"
                    findIPAddress(result, s.substring(i), curr + sub + ".", level + 1);
                }
            }
        }
    }
}
