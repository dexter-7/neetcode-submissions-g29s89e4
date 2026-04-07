class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // key = num, value = frequency
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        map.forEach((key, value) -> {
            pq.add(new int[] {value, key});
            if (pq.size() > k) pq.poll();
        });

        int[] res = new int[k];
        // iterate list, fill out and return int[k]
        for (int i = 0; i < k; ++i) res[i] = pq.poll()[1];

        return res; 
    }
}
