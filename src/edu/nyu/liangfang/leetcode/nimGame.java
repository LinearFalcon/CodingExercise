public class nimGame {
    /* canWinNim(1 ~ 3) is true
       canWinNim(4) is false
       canWinNim(5 ~ 7) is true: because we can always leave 4 stones and let other play
       canWinNim(8) is false
    */
    public boolean canWinNim2(int n) {
        if (n < 0) return false;
        return n % 4 != 0;
    }

    // Memory Limit Exceed - java.lang.OutOfMemoryError: Java heap space
    public boolean canWinNim2(int n) {
        boolean[] canWin = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i <= 3) canWin[i] = true;
            else canWin[i] = !canWin[i - 1] || !canWin[i - 2] || !canWin[i - 3];
        }
        return canWin[n];
    }

    // TLE
    public boolean canWinNim3(int n) {
        if (n <= 3) return true;
        return !canWinNim(n - 1) || !canWinNim(n - 2) || !canWinNim(n - 3);
    }
}