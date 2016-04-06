package edu.nyu.liangfang.leetcode;

import java.util.LinkedList;
import java.util.List;


public class addBinary {
    /*
     * #2:
     */
    public String addBinaryFun2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int p = a.length() - 1;
        int q = b.length() - 1;

        while (p >= 0 || q >= 0 || carry > 0) {
            int pValue = (p < 0 ? 0 : a.charAt(p) - '0');
            int qValue = (q < 0 ? 0 : b.charAt(q) - '0');
            int sum = pValue + qValue + carry;
            sb.insert(0, sum % 2);
            carry = sum / 2;
            p--;
            q--;
        }
        return sb.toString();
    }


    /*
     * #1: convert string to list, then add them and convert the sum back to string
     *
     * Comments: too long and too complicated
     */
    public String addBinaryFun(String a, String b) {
        List<Character> alist = convertToList(a);
        List<Character> blist = convertToList(b);
        List<String> result = addTwoList(alist, blist);
        return listToString(result);
    }

    // reverse list
    private List<Character> convertToList(String s) {
        List<Character> list = new LinkedList<Character>();
        for (int i = s.length() - 1; i >= 0; i--) {
            list.add(s.charAt(i));
        }
        return list;
    }

    private List<String> addTwoList(List<Character> alist, List<Character> blist) {
        int carry = 0;
        int pointer = 0;
        List<String> result = new LinkedList<String>();
        while (!(carry == 0 && pointer >= alist.size() && pointer >= blist.size())) {
            int sum = 0;
            if (pointer < alist.size() && pointer < blist.size()) {
                sum += alist.get(pointer) - '0' + blist.get(pointer) - '0' + carry;
            } else if (pointer < alist.size()) {
                sum += alist.get(pointer) - '0' + carry;
            } else if (pointer < blist.size()) {
                sum += blist.get(pointer) - '0' + carry;
            } else {
                sum += carry;
            }
            carry = 0;
            pointer++;

            if (sum >= 2) {
                sum -= 2;
                carry = 1;
            }
            result.add(String.valueOf(sum));
        }
        return result;
    }

    // convert back to correct order
    private String listToString(List<String> list) {
        String result = "";
        for (String s : list) {
            result = s + result;
        }
        return result;
    }


}
