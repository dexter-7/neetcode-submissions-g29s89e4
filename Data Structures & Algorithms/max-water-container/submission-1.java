class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length, l = 0, r = n - 1, res = 0;
        while (l < r) {
            int water = (r - l) * Math.min(heights[l], heights[r]);
            res = Math.max(res, water);
            if (heights[l] < heights[r]) ++l;
            else --r; 
        }
        return res;
    }
}
