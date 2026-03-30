class Solution {

    public String encode(List<String> strs) {
        StringBuilder enc = new StringBuilder();
        for(String s : strs){
            enc.append(s).append("`");
        }
        return enc.toString();

    }

    public List<String> decode(String str) {
        StringBuilder s = new StringBuilder();
        List<String> res = new ArrayList<>();

        for(char c : str.toCharArray()){
            if(c == '`'){
                res.add(s.toString());
                s.setLength(0);
                continue;
            }
            s.append(c);
        }
        return res;
    }
}
