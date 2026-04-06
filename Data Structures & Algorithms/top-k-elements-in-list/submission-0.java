class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // key = num, value = frequency
        for (int num: nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        // list of a pairs (frequency, number)
        List<int[]> list = new ArrayList<>(map.size());
        map.forEach((key, value) -> {
            list.add(new int[] {value, key});
        });

        // sort
        Collections.sort(list, (a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        // iterate list, fill out and return int[k]
        for (int i = 0; i < k; ++i) res[i] = list.get(i)[1];

        return res; 
    }
}
