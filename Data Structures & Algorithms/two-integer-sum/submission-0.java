class Solution {
    public int[] twoSum(int[] nums, int target) {
        // a + b = target; a = target - b
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);

        for (int i = 1; i < nums.length; ++i) {
            Integer aIndex = map.get(target - nums[i]);
            if (aIndex != null) return new int[] {aIndex, i};

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
