package edu.nyu.liangfang.codefactory;

public class Foo {

    public int singleNumber(int[] A) {
        int[] count = new int[32];  // each int has 32 bits
        int result = 0;
        // count number of appearance of each bit in all numbers
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                if (((A[j] >> i) & 1) == 1) {   // check if this bit of number is 1
                    count[i]++;
                }
            }
            result |= ((count[i] % 3) << i);    // set this bit to 1 if it is 1
        }
        return result;
    }

    public int vowelNum(String s) {
        String vowel = "aeiouAEIOU";
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (vowel.indexOf(s.charAt(i)) != -1) {
                num++;
            }
        }
        return num;
    }

    public int fibonacciNum_recursion(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        }

        return fibonacciNum_recursion(n - 1) + fibonacciNum_recursion(n - 2);
    }

    public int fibonacci_iterative(int n) {
        int first = 1;
        int second = 1;
        if (n < 3) {
            return 1;
        }

        int count = 2;
        while (count < n) {
            int tmp = first;
            first = first + second;
            second = tmp;
            count++;
        }
        return first;
    }

    public void swap(int[] a, int[] b) {
        a[0] = a[0] ^ b[0];
        b[0] = a[0] ^ b[0];
        a[0] = a[0] ^ b[0];
    }
}
