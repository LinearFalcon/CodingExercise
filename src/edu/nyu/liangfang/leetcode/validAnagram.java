public class validAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() == 0) 
            return t.length() == 0;
        else if (s.length() != t.length())
            return false;
        
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < t.length(); i++) {
            int pos = t.charAt(i) - 'a';
            count[pos]--;
            if (count[pos] < 0) {
                return false;
            }
        }
        return true;
    }
}