class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // n1 + n2 = target => target - n2 = n1
        map.put(numbers[0], 0);
        for (int index2 = 1; index2 < numbers.length; ++index2) {
            Integer index1 = map.get(target - numbers[index2]);
            if (index1 != null) {
                return new int[]{index1 + 1, index2 + 1};
            }
            map.put(numbers[index2], index2);
        }
        return new int[]{};
    }
}
