class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; ++i) {
            for (int j = i + 1; j < n - 1; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        if (!set.contains(tmp)) {
                            res.add(tmp);
                            set.add(tmp);
                        }
                    }
                }
            }
        }

        return res;
    }
}
