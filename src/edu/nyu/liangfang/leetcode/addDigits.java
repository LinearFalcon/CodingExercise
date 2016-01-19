public class addDigits {
    // Without loop
    // return 1 + (num - 1) % 9;

    // With loop and recursion
    public int addDigits(int num) {
        if (num < 10) return num;
        int curr = 0;
        while (num > 0) {
            curr += num % 10;
            num /= 10;
        }
        return addDigits(curr);
    }
}