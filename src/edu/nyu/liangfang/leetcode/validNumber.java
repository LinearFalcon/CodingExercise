package edu.nyu.liangfang.leetcode;

public class validNumber {

    public boolean isNumber(String s) {
        String str = s.trim();
        if (str.isEmpty()) {    // trim leading and tailing whitespace
            return false;
        }
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {  // ignore leading sign bit 
            str = str.substring(1);
        }

        // find position of dot and e
        int dot = -1;
        int ee = -1;
        for (int i = 0; i < str.length(); i++) {
            if (dot == -1 && str.charAt(i) == '.') {
                dot = i;
            } else if (ee == -1 && str.charAt(i) == 'e') {
                ee = i;
                if (i + 1 < str.length() && (str.charAt(i + 1) == '+' || str.charAt(i + 1) == '-')) {    // ignore possible sign bit after 'e'
                    i++;
                }
            } else {
                if (Character.isDigit(str.charAt(i))) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        //xxx.xxexx
        String startStr, midStr, lastStr;
        if (dot == -1 && ee == -1) {    //xxx
            startStr = s;
            if (startStr.length() < 1) {
                return false;
            }
        } else if (dot != -1 && ee == -1) { //xxx.yy
            startStr = str.substring(0, dot);
            midStr = str.substring(dot + 1);
            if (startStr.length() < 1 && midStr.length() < 1) { // because '9.' and '.9' is both correct
                return false;
            }
        } else if (dot == -1 && ee != -1) { //xxxeyy
            startStr = str.substring(0, ee);
            if (startStr.length() < 1) {
                return false;
            }
            if (ee + 1 < str.length() && (str.charAt(ee + 1) == '+' || str.charAt(ee + 1) == '-')) {    //xxxe-yy
                lastStr = str.substring(ee + 2);
            } else {
                lastStr = str.substring(ee + 1);
            }
            if (lastStr.length() < 1) {
                return false;
            }
        } else {                            // xxx.yyezz
            if (dot > ee) {         // wrong position for dot and e !!!!!!!!!
                return false;
            }
            startStr = str.substring(0, dot);
            midStr = str.substring(dot + 1, ee);
            if (startStr.length() < 1 && midStr.length() < 1) { // because '9.' and '.9' is both correct
                return false;
            }
            if (ee + 1 < str.length() && (str.charAt(ee + 1) == '+' || str.charAt(ee + 1) == '-')) {    //xxxe-yy
                lastStr = str.substring(ee + 2);
            } else {
                lastStr = str.substring(ee + 1);
            }
            if (lastStr.length() < 1) {
                return false;
            }
        }
        return true;
    }
}	
