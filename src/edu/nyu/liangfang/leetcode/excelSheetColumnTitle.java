public class excelSheetColumnTitle {
    public String convertToTitle(int n) {
        String res = "";
        while (n > 0) {
            res = String.valueOf((char)((n - 1) % 26 + 'A')) + res;		// n-1 not n, since 1 is A and 26 is Z
            n = (n - 1) / 26;
        }
        return res;
    }
}