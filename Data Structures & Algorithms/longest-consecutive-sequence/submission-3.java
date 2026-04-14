class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();

        for (int num: nums) set.add(num);

        for (int num: nums) {
            if (!set.contains(num - 1)) {
                int count = 1, next = num + 1;
                while (set.contains(next)) {
                    count++;
                    next++;
                }
                res = Math.max(res, count);
            }
        }

        return res;
    }
}
