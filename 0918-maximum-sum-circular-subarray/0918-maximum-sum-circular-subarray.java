class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int Total = nums[0];

        int maxend = nums[0];
        int minend = nums[0];

        int max_sum = nums[0];
        int min_sum = nums[0];

        for(int i = 1 ; i< nums.length; i++){
            Total += nums[i];
            maxend = Math.max(maxend+nums[i], nums[i]);
            max_sum = Math.max(max_sum, maxend);
            minend = Math.min(minend +nums[i], nums[i]);
            min_sum = Math.min(min_sum, minend);

        }
        if (max_sum < 0) {
        return max_sum;
        }
        return Math.max(max_sum,Total-min_sum);
    }
}