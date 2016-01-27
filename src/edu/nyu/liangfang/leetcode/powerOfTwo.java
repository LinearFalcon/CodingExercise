public class powerOfTwo {
    // general
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;   // Must take care of non-positive number!
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n >> i & 1) == 1) count++;     // '>>' evaluates before '&'
        }
        return count == 1;
    }

    // most simple way
    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    // bit version
    // n & -n get a number with only one 1 bit in the position of rightmost 1 bit of original n; 
    // '~' flip the binary number
    public boolean isPowerOfTwo3(int n) {
        if (n <= 0) return false;
        return (~(n & -n) & n) == 0;
    }
}