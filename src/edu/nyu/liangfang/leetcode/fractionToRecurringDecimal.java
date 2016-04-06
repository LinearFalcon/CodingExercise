package edu.nyu.liangfang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class fractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return "NaN";
        } else if (numerator == 0) {
            return "0";
        }

        Map<Long, Integer> map = new HashMap<Long, Integer>();
        StringBuilder sb = new StringBuilder();
        long n = new Long(numerator);
        long d = new Long(denominator);

        if (n * d < 0) {
            sb.append("-");
        }
        n = Math.abs(n);
        d = Math.abs(d);

        // append integral part
        sb.append(n / d);

        long rem = n % d;
        // no fractional part
        if (rem == 0) {
            return sb.toString();
        } else {
            sb.append(".");
        }

        while (rem > 0) {
            if (map.containsKey(rem)) {
                sb.insert(map.get(rem), "(");
                sb.append(")");
                break;
            }

            map.put(rem, sb.length());
            rem *= 10;                  // simulate divide
            sb.append(rem / d);
            rem %= d;
        }
        return sb.toString();
    }
}
