public class reverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        for (int i = 0, j = 31; i < 16; i++, j--) {
            int left = (n >> j) & 1, right = (n >> i) & 1;
            if (left != right && left == 0) {
                n |= 1 << j;
                n &= ~(1 << i);
            } else if (left != right && right == 0) {
                n |= 1 << i;
                n &= ~(1 << j);
            }
        }
        return n;
    }
}