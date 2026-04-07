class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            sb.append(String.format("%03d",str.length())).append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        System.out.println(str);
        for (int i = 0; i < str.length();) {
            String ncs = str.substring(i, i + 3);
            System.out.println("ncs = " + ncs);
            int noc = Integer.parseInt(ncs);
            System.out.println("noc = " + noc);
            String word = str.substring(i + 3, i + 3 + noc);
            System.out.println("word = " + word);
            res.add(word);
            i = i + 3 + word.length();
            System.out.println("i = " + i);
        }
        return res;
    }
}
