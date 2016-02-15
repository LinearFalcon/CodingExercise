


// TLE - for every char appearing more than 1 time, you have two choices, choose or not
//       edge case: have to choose if it's last character
class Solution_TLE {
    private String res = "";
    public String removeDuplicateLetters(String s) {
        if (s.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) map.put(s.charAt(i), 1);
            else map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
        find(s, map, "");
        return res;
    }
    
    private void find(String s, Map<Character, Integer> map, String curr) {
        if (curr.length() == map.size()) {
            if (res.length() == 0 || curr.compareTo(res) < 0) 
                res = curr;
            return;
        }
        
        char c = s.charAt(0);
        if (map.get(c) > 1) {
            int num = map.get(c);
            map.put(c, 0);
            find(s.substring(1), map, curr + String.valueOf(c));
            map.put(c, num);
            
            if (s.substring(1).indexOf(c) != -1)
                find(s.substring(1), map, curr);
        } else if (map.get(c) == 1) {
            find(s.substring(1), map, curr + String.valueOf(c));
        } else {
            find(s.substring(1), map, curr);
        }
    }
}