class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            char[] cstr = str.toCharArray();
            Arrays.sort(cstr);
            String anagram = new String(cstr);

            map.putIfAbsent(anagram, new ArrayList<>());
            map.get(anagram).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
