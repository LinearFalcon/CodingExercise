public class Solution {
    // split function method
    public int lengthOfLastWord_short(String s) {
        String[] arr = s.split(" ");
        if (arr.length == 0) return 0;
        return arr[arr.length - 1].length();
    }

    // No split function
    public int lengthOfLastWord(String s) {
        int count = 0;
        int mark = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (count == 0 && s.charAt(i) != ' ') {
                mark = i;
                count++;
            } else if (count == 1 && s.charAt(i) == ' ') {
                return mark - i;
            }
        }
        if (count == 1) return mark + 1;    // in case no whitespace at the head, e.g: 'ss  '
        return 0;
    }
}