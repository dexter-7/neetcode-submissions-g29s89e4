class Solution {
    public String minWindow(String s, String t) {
        /*
        Approach

        Sliding Window + Frequency Maps
        The key insight is to use two pointers (left, right) to maintain
        a window, expanding it until it's valid, then shrinking it to
        minimize the length.

        Algorithm

        Build a frequency map for t.
        Expand the right pointer, adding characters to the window.
        Track have (chars satisfied) vs need (distinct chars in t).
        Once have == need, try shrinking from the left to minimize
        the window.
        Update the result whenever a valid, smaller window is found.

        Key Pitfalls to Avoid

        Duplicates in t: Use frequency counts, not just sets.
        have tracking: Only increment have when window[c] == need[c]
        exactly (not >=), to avoid double-counting.
        Shrinking condition: Only decrement have when the window count drops
        below the needed count.
        */
        if (s.isEmpty() || t.isEmpty()) return "";

        // it is going to tell us the count in t characters
        Map<Character, Integer> need = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // store the number of each character in the current window
        Map<Character, Integer> window = new HashMap<Character, Integer>();
        int have = 0, totalNeed = need.size();
        int left = 0;
        int resStart = 0, resLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            System.out.println("c = " + c);
            window.put(c, window.getOrDefault(c, 0) + 1);
            /*
            System.out.println("left = " + left);
            System.out.println("right = " + right);
            System.out.println("need = " + need);
            System.out.println("window = " + window);
            */
            // check if this char's frequency satisfies t's requirement
            // count how many characters of t we have in window, because
            // the get will bring the count, it handle duplicated characters
            if (need.containsKey(c) && window.get(c).equals(need.get(c))) {
                have++;
            }
            System.out.println("have = " + have);
            System.out.println("totalNeed = " + totalNeed);
            System.out.println("have == totalNeed = " + (have == totalNeed));
            // Shrink from the left while the window is valid
            while (have == totalNeed) {
                /*
                System.out.println("Shrink from the left while the window is valid");
                System.out.println(">right = " + right);
                System.out.println(">resLen = " + resLen);
                System.out.println(">resStart = " + resStart);
                System.out.println(">right - left + 1 < resLen = " + (right - left + 1 < resLen));
                */
                // if the current window size is lower than so far resLes,
                // update resLen (better len that meet expectation)
                if (right - left + 1 < resLen) {
                    resLen = right - left + 1;
                    resStart = left;
                }
                // System.out.println(">resLen = " + resLen);
                // System.out.println(">resStart = " + resStart);
                // Remove leftmost character
                char leftChar = s.charAt(left);
                // System.out.println(">leftChar = " + leftChar);
                window.put(leftChar, window.get(leftChar) - 1);
                // System.out.println(">window = " + window);
                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    have--;
                    System.out.println(">have = " + have);
                }
                left++;
                System.out.println(">>>left = " + left);
            }
            // System.out.println("=== resLen =" + resLen + ", s = " + s + ", t = " + t);
        }
        // when resLen = Integer.MAX_VALUE, it means we didn't find a case that
        // meet expectations. Otherwise, resStart is the start of the string that
        // meet the expectation, and resStart is the min len found that meet
        // the expectations.
        return resLen == Integer.MAX_VALUE ? "" : s.substring(resStart, resStart + resLen);
    }
}
