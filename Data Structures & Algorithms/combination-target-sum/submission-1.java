class Solution {
    /*
        Time Complexity: O(2^(t/m))
        The recursion forms a binary tree — at each node you make 2 choices: include or skip.
        How deep can the tree get?
        The longest possible combination is when you repeatedly pick the smallest number m. To reach target t, you'd pick it t/m times. So the maximum depth is t/m.
        How many nodes total?
        A binary tree of depth t/m has at most 2^(t/m) nodes, and we do O(1) work at each node — so time is O(2^(t/m)).
        nums = [2, 5, 6, 9], target = 9, m = 2
        max depth = 9/2 ≈ 4   →   at most 2^4 = 16 nodes
        The real tree is smaller because we prune early when total > target, but 2^(t/m) is the worst-case upper bound.

        Space Complexity: O(t/m)
        There are two things using space:
        1. Recursion call stack
        We go at most t/m levels deep, so the stack holds at most t/m frames at once.
        2. The current list
        At any point in the recursion, current holds the numbers on the current path — also at most t/m elements long.
        Both are O(t/m), so overall space is O(t/m).

        Note: the res output list isn't counted in space complexity — by convention we don't count the space needed to store the answer.

        Intuition check
        target = 9, min = 2  →  worst case path: [2, 2, 2, 2] (depth 4)
        target = 30, min = 2 →  worst case path: [2, 2, 2, ..., 2] (depth 15)

        For nums = [2, 5, 6, 9], target = 9:
                         []  sum=0
                        /         \
                pick 2              skip 2
                [2] sum=2           ...
                /       \
            pick 2    skip 2
            [2,2] 4    [2,5] 7
            /    \        \
        pick 2  skip 2   pick 5→[2,5,5]=12>9 ✗
        [2,2,2]  [2,2,5]       skip 5→[2,6]...
        6        9 ✓
    */
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dp(nums, target, 0, res, new ArrayList<>(), 0);
        return res;
    }

    private void dp(int[] nums, int target, int index, List<List<Integer>> res, List<Integer> chain, int sum) {
        if (index == nums.length || sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(chain));
            return;
        }
        chain.add(nums[index]);
        // try adding ourself again
        dp(nums, target, index, res, chain, sum + nums[index]);

        chain.remove(chain.size() - 1);
        // try adding the next index but ourself
        dp(nums, target, index + 1, res, chain, sum);
    }
}
