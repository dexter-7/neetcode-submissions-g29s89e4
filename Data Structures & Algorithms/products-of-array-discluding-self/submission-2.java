class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; ++i) {
            product = nums[i] * product;
            left[i] = product;
        }
        product = 1;
        int[] right = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; --i) {
            product = nums[i] * product;
            right[i] = product;
        }

        System.out.println("left = " + Arrays.toString(left));
        System.out.println("right = " + Arrays.toString(right));

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0) res[i] = left[i - 1]; else res[0] = 1;
            if (i != nums.length -1) res[i] *= right[i + 1];
        }

        return res;
    }
}  
