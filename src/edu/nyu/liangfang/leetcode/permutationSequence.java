package edu.nyu.liangfang.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class permutationSequence {
    // latest solution
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();

        List<Integer> digits = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            digits.add(i);

        int fac = 1;
        for (int i = 1; i <= n; i++)
            fac *= i;

        for (int i = n; i > 0; i--) {
            fac /= i;
            int index = (k - 1) / fac;
            sb.append(digits.get(index));
            digits.remove(index);
            k -= index * fac;
        }
        return sb.toString();
    }

    // O(n) solution
    public String getPermutation_quick(int n, int k) {
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

    // TLE solution 1
    public String getPermutation_tle1(int n, int k) {
        boolean[] chosen = new boolean[n + 1];
        int[] count = {0};
        String[] target = {""};
        dfs(chosen, n, k, count, "", 0, target);
        return target[0];
    }

    public void dfs(boolean[] chosen, int n, int k, int[] count, String curr, int level, String[] target) {
        if (count[0] > k) return;
        else if (level == n) {
            count[0]++;
            if (count[0] == k) target[0] = curr;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!chosen[i]) {
                chosen[i] = true;
                dfs(chosen, n, k, count, curr + String.valueOf(i), level + 1, target);
                chosen[i] = false;
            }
        }
    }

    // TLE solution 2
    public String getPermutation_tle2(int n, int k) {
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
