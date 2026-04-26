class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int l = 0;
        int maxFreq = 0;
        int result = 0;

        for (int r = 0; r < s.length(); r++) {
            count[s.charAt(r) - 'A']++;
            System.out.println("count of " + s.charAt(r) + " # " + count[s.charAt(r) - 'A']);
            // maxFreq we have seen so far, used during all the algorithm
            maxFreq = Math.max(maxFreq, count[s.charAt(r) - 'A']);
            /*
            System.out.println("maxFreq = " + maxFreq);
            System.out.println("r = " + r);
            System.out.println("l = " + l);
            System.out.println("(r - l + 1) - maxFreq = " + ((r - l + 1) - maxFreq));
            System.out.println("(r - l + 1) - maxFreq > k = " + ((r - l + 1) - maxFreq > k));
            */
            // Window is invalid: need more than k replacements
            // Number of charactheres of the window - maxFreq
            while ((r - l + 1) - maxFreq > k) {
                /*
                System.out.println("l = " + l);
                System.out.println("(r - l + 1) = " + (r - l + 1));
                System.out.println("(r - l + 1) - maxFreq = " + ((r - l + 1) - maxFreq));
                System.out.println("*count of " + s.charAt(l) + " # " + count[s.charAt(l) - 'A']);
                */
                // reduce the count of the character will be kit off the window
                count[s.charAt(l) - 'A']--;
                System.out.println("-count of " + s.charAt(l) + " # " + count[s.charAt(l) - 'A']);
                // move the window to the left
                l++;
            }

            result = Math.max(result, r - l + 1);
            /*
            System.out.println("r - l + 1 = " + (r - l + 1));
            System.out.println("result = " + result);
            System.out.println("========= " + s + " =========");
            */
        }

        return result;
    }
}
