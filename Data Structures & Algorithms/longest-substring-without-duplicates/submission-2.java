class Solution {
    public int lengthOfLongestSubstring(String s) {
Map<Character, Integer> charIndex = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            /*
            System.out.println("left = " + left);
            System.out.println("right = " + right);
            System.out.println("map size = " + charIndex.size());
            */
            char c = s.charAt(right);
            System.out.println("c = " + c);

            // If character is already in the current window, move left pointer
            if (charIndex.containsKey(c) && charIndex.get(c) >= left) {
                // System.out.println("got in, map cotains = " + c);
                left = charIndex.get(c) + 1;
                // System.out.println("left = " + left);
            }

            // Update the last seen index of this character
            // System.out.println("map put = " + c + " , " + right);
            charIndex.put(c, right);
            
            // Update maximum length
            // System.out.println("maxLen = " + maxLen);
            maxLen = Math.max(maxLen, right - left + 1);
            // System.out.println("maxLen = " + maxLen);
            // System.out.println("=============" + s + "=====================");
        }
        
        return maxLen;
    }
}
