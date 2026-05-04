class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int l = 0, mf = 0, res = 0;
        for (int r = 0; r < s.length();  ++r) {
            count[s.charAt(r) - 'A']++;
            mf = Math.max(mf, count[s.charAt(r) - 'A']);

            /*
                if we are in a invalid window, move left to the right until
                the window become valid again
            */
            while((r - l + 1) - mf > k) {
                count[s.charAt(l) - 'A']--;
                ++l;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
