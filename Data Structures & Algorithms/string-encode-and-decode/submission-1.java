class Solution {

    public String encode(List<String> strs) {
        String en="";
        for(String s :strs ){
            en+=s+"`";
        }
        return en;
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        String res ="";

        for(char s : str.toCharArray()){
            if(s == '`'){
                list.add(res);
                res="";
            }else{
                res+=s;
            }


        }
        return list;
    }
}
