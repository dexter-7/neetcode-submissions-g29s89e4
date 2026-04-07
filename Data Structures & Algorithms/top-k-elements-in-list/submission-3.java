class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // key = num, value = frequency
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // each idx is a frequency [nums.size() + 1], each element is a list of nums
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; ++i) list.add(new ArrayList<>());
        map.forEach((key, value) -> {
            list.get(value).add(key);
        });

        int[] res = new int[k];
        int idx = 0;
        // iterate list, fill out and return int[k]
        for (int i = list.size() - 1; i >= 0; --i) {
            for (int num: list.get(i)) {
                res[idx++] = num;
                if (idx == k) return res;
            }
        }

        return new int[] {};
        // time O(n), space O(n)
    }
}
