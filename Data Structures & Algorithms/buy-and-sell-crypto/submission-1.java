class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, minPrice = prices[0];
        int res = 0;
        for (int i = 1; i < n; ++i) {
            res = Math.max(res, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return res;
    }
}
