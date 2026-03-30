class Solution {

    public String encode(List<String> strs) {
        StringBuilder en = new StringBuilder();
        for (String s : strs) {
            en.append(s).append('`');
        }
        return en.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        StringBuilder res = new StringBuilder();

        for (char s : str.toCharArray()) {
            if (s == '`') {
                list.add(res.toString());
                res.setLength(0);
            } else {
                res.append(s);
            }
        }
        return list;
    }
}
