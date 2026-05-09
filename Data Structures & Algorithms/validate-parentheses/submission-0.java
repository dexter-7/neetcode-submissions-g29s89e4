class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        // close -> open
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (char c:  s.toCharArray()) {
            if (map.get(c) != null) { // close character
                if (stack.isEmpty() || map.get(c) != stack.pop()) {
                    return false;
                }
            } else { // open character
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
