class Solution {

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;

        long[] sums = new long[n + 1];

        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        return mergeSort(sums, 0, n + 1, lower, upper);
    }

    private int mergeSort(long[] sums, int left, int right,
                           int lower, int upper) {

        if (right - left <= 1) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        int count = 0;

        count += mergeSort(sums, left, mid, lower, upper);
        count += mergeSort(sums, mid, right, lower, upper);

        int j = mid;
        int k = mid;

        for (int i = left; i < mid; i++) {

            while (j < right && sums[j] - sums[i] < lower) {
                j++;
            }

            while (k < right && sums[k] - sums[i] <= upper) {
                k++;
            }

            count += k - j;
        }

        long[] temp = new long[right - left];

        int p1 = left;
        int p2 = mid;
        int t = 0;

        while (p1 < mid && p2 < right) {
            if (sums[p1] <= sums[p2]) {
                temp[t++] = sums[p1++];
            } else {
                temp[t++] = sums[p2++];
            }
        }

        while (p1 < mid) {
            temp[t++] = sums[p1++];
        }

        while (p2 < right) {
            temp[t++] = sums[p2++];
        }

        for (int i = 0; i < temp.length; i++) {
            sums[left + i] = temp[i];
        }

        return count;
    }
}