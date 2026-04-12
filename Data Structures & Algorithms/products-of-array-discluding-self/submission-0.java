class Solution {
    public int[] productExceptSelf(int[] nums) {
        int nzs = 0;
        int product = 1;
        for (int num: nums) {
            if (num == 0) nzs++;
            else product *= num;
        } 
        System.out.println("product = " + product);
        System.out.println("nzs = " + nzs);
        int[] res = new int[nums.length];

        if (nzs > 1) { // case 1. two zeros or more
            for (int i = 0; i < nums.length; ++i) {
                res[i] = 0;
            }
        } else if (nzs == 1) { // case 2, one zero
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] == 0) res[i] = product;
            }
        } else { // case 3, no zeros
            System.out.println("case 3");
            for (int i = 0; i < nums.length; ++i) {
                res[i] = product / nums[i];
            }
        }

        return res;
    }
}  
