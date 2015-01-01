package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class permutationSequence {
	// O(n) solution
	public String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList<Integer>();
        // fill num with 1 to n in order
        for (int i = 1; i <= n; i++) {
            num.add(i);
        }
        
        // compute n factorial
        int mod = 1;
        for (int i = 1; i <= n; i++) {
            mod = mod * i;
        }
        
        // change k to index
        k--;
        String result = "";
        // from left to right, compute the very first bit, n bits so loop n times
        for (int i = n; i > 0; i--) {
            // mod should be (n - 1) factorial
            mod = mod / i;
            int currBitIndex = k / mod;
            k = k % mod;
            result += num.get(currBitIndex);
            // important, must remove this index becuase every num only appears once
            num.remove(currBitIndex);
        }
        return result;
    }
	
	
	// TLE solution
	public String getPermutation_TLE(int n, int k) {
        List<String> perm = new ArrayList<String>();
        perm = getAllPerm(n);
        Collections.sort(perm);
        return perm.get(k - 1);
    }
    
    public List<String> getAllPerm(int n) {
        
        if (n == 1) {
        	List<String> perm = new ArrayList<String>();
            perm.add("1");
            return perm;
        }
        
        List<String> perm = new ArrayList<String>();
        for (String str : getAllPerm(n - 1)) {
            for (int i = 0; i <= str.length(); i++) {
            	StringBuilder sb = new StringBuilder();
                String left = str.substring(0, i);
                String right = str.substring(i);
                sb.append(left).append(String.valueOf(n)).append(right);
                perm.add(sb.toString());
                
            }
        }
        return perm;
    }
}
