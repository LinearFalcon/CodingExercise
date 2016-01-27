public class happyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int res = 0;
            while (n != 0) {
                res += (int) Math.pow((n % 10), 2);
                n /= 10;
            }
            if (res == 1) return true;
            else if (set.contains(res)) return false;
            set.add(res);
            n = res;
        }
    }
}