/*
Once again, we need to use XOR to solve this problem. But this time, we need to do it in two passes:

1, In the first pass, we XOR all elements in the array, and get the XOR of the two numbers we need to find. Note that since the two numbers are distinct, so there must be a set bit (that is, the bit with value '1') in the XOR result. Find out an arbitrary set bit (for example, the rightmost set bit).

2, In the second pass, we divide all numbers into two groups, one with the aforementioned bit set, another with the aforementinoed bit unset. Two different numbers we need to find must fall into thte two distrinct groups. XOR numbers in each group, we can find a number in either group.
*/

public class singleNumber3 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }

        // generate a binary number with rightmost diff 1 as 1 and other digits zero
        // e.g: diff = 110, then diff ^ -diff = 010
        diff &= -diff;

        int[] res = {0, 0};     // must initialize as zero to XOR all other numbers
        for (int num : nums) {
            if ((num & diff) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}