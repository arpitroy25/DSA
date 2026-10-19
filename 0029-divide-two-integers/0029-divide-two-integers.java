
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negative = (dividend < 0) ^ (divisor < 0);

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long ans = 0;

        while (n >= d) {
            int p = 0;

            while (p < 32 && n >= (d << p)) {
                p++;
            }

            p--;

            n -= d << p;
            ans += 1L << p;
        }

        if (negative) {
            return (int) -ans;
        }

        return (int) ans;
    }
}
