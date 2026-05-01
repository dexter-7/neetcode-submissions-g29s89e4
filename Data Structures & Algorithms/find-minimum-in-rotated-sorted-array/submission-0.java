class Solution {
    public int findMin(int[] nums) {
        /*
        case 1:
            3,4,5,6,1,2
                  ^[m], 6 > 2, answer is at the right, move l = m + 1,
                  note: m cannot be the answer but m + 1, may it is,
                  let say nums[m] = 5 and we have [..5,1,2]
        case 2:
            4,5,6,1,2,3
                  ^[m], 1 < 3, l and m are in the sorted segment, answer is
                               at the left, note that the min could be m,
                               hence r = m instead of r = m - 1
        */
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            /*
            System.out.println("l = " + l);
            System.out.println("r = " + r);
            System.out.println("m = " + m);
            System.out.println("nums[m] = " + nums[m] + ", nums[r] = " + nums[r]);
            */
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        System.out.println("answer = " + nums[l] + ", l = " + l);
        return nums[l];
    }
}
