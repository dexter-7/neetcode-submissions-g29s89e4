class Solution {
    public int characterReplacement(String s, int k) {
        // O(n^2) it is hard to understand the logic as the optimal solution
        int result = 0;

        for (int l = 0; l < s.length(); l++) {
            int[] count = new int[26];
            int maxFreq = 0;

            for (int r = l; r < s.length(); r++) {
                count[s.charAt(r) - 'A']++;
                maxFreq = Math.max(maxFreq, count[s.charAt(r) - 'A']);

                int windowSize = r - l + 1;
                if (windowSize - maxFreq <= k) {
                    result = Math.max(result, windowSize);
                }
            }
        }

        return result;
    }
}
