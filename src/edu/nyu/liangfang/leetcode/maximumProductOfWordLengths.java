public class maximumProductOfWordLengths {


    // TLE, O(n^2 * L), L is average length of word
    public int maxProduct(String[] words) {
        if (words.length <= 1) return 0;
        
        Set<Character> set = new HashSet<>();
        int maxProd = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                set.clear();
                boolean isDiff = true;
                for (int p = 0; p < words[i].length(); p++) set.add(words[i].charAt(p));
                for (int q = 0; q < words[j].length(); q++) {
                    if (set.contains(words[j].charAt(q))) {
                        isDiff = false;
                        break;
                    }
                }
                if (isDiff) {
                    int prod = words[i].length() * words[j].length();
                    if (prod > maxProd) maxProd = prod;
                }
            }
        }
        return maxProd;
    }
}