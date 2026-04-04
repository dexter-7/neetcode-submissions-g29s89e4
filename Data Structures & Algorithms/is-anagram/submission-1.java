class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] sa = new int[26];
        // because both s and t have the same length
        for (int i = 0; i < s.length(); ++i) {
            ++sa[s.charAt(i) - 'a'];
            --sa[t.charAt(i) - 'a'];
        }

        for (int i = 0; i < 26; ++i) if (sa[i] != 0) return false;

        return true;
    }
}
