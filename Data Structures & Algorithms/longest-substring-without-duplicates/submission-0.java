class Solution {
    public int lengthOfLongestSubstring(String s) {
        // time O(n^2)
        int maxLen = 0;
        int n = s.length();
    
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[256];  // para ASCII
            int len = 0;
        
            for (int j = i; j < n; j++) {
                if (visited[s.charAt(j)]) {
                    break;
                }
                visited[s.charAt(j)] = true;
                len++;
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
