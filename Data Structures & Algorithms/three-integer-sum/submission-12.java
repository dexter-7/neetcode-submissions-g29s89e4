class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        ArrayList<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; ++i) { 
            // move to the last one of the duplicates
            if (i > 0 && nums[i - 1] == nums[i]) continue;

            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) { // we need to reduce sum, move r to left
                    --r;
                } else if (sum < 0) { // we need to increase sum, move l to right
                    ++l;
                } else { // sum = 0
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    r--;
                    while (l < r && nums[r] == nums[r + 1]) --r; 

                    // move to a diferent left number to avoid duplicate res item
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) ++l; 
                }
            }
        }

        return res;
    }
}
