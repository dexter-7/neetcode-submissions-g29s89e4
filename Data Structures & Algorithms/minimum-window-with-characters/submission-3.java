class Solution {
    public String minWindow(String s, String t) {
        int l = 0;
        Map<Character, Integer> wc = new HashMap<>();
        Map<Character, Integer> tc = new HashMap<>();

        for (char c: t.toCharArray()) tc.put(c, tc.getOrDefault(c, 0) + 1);

        int need = tc.size(), have = 0, start = 0, resLen = Integer.MAX_VALUE;

        for (int r = 0; r < s.length(); ++r){
            char c = s.charAt(r);
            // increase count of characters in the window
            wc.put(c, wc.getOrDefault(c, 0) + 1);

            // if the count of a particular character match t
            if (tc.containsKey(c) && wc.get(c).equals(tc.get(c))) {
                ++have;
            }

            /*
                if we have t in the window, shrink the window
            */
            while (have == need) {
                if (r - l + 1 < resLen) {
                    resLen = r - l + 1;
                    start = l;
                }

                wc.put(s.charAt(l), wc.getOrDefault(s.charAt(l), 0) - 1);

                if (tc.containsKey(s.charAt(l)) && wc.get(s.charAt(l)) < tc.get(s.charAt(l))) --have;

                ++l;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(start, start + resLen);
    }
}
