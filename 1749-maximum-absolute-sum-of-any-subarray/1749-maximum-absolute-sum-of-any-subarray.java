class Solution {
    public int maxAbsoluteSum(int[] nums) {
      int maxend = nums[0];
      int minend = nums[0];

      int max_sum = nums[0];
      int min_sum = nums[0];

      for(int i = 1; i<nums.length; i++){
        maxend = Math.max(maxend+nums[i], nums[i]);
        minend = Math.min(minend+nums[i], nums[i]);

        max_sum = Math.max(maxend,max_sum);
        min_sum = Math.min(minend, min_sum);

      } 
      return Math.max(Math.abs(max_sum),
      Math.abs(min_sum));
    }
}