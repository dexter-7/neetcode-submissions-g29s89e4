class Solution {
    public int search(int[] nums, int target) {
        /*
            one half if sorted, if we are in the sorted half, check if target
            is there. Otherwise move to other half.
        */
        int l = 0, r = nums.length - 1;
        // the equals is becaise if we have only one element, m could be target
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return m;

            if (nums[l] <= nums[m]) { // left side is sorted [3,4,5,m=6,1,2]
                if (nums[l] <= target && target < nums[m]) {
                    // target is in this side
                    r = m - 1;
                } else {
                    // it may be in the other side
                    l = m + 1; 
                }
            } else { // right side sorted [8, 9, m = 5, 6, 7]
                if (nums[m] < target && target <= nums[r]) {
                    // target is in this side
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
