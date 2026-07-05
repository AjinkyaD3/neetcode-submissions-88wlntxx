class Solution {
    String[] map = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

    public List<String> letterCombinations(String digits) {
        
        List<String> ans = new ArrayList<>();

        if(digits == null || digits.length() == 0) return ans;


        backtrack(ans ,digits , "",0);

        return ans;
        
    }


     public void backtrack(List<String> ans , String  digits , String curr ,  int index){


       if(index == digits.length() ){
        ans.add(curr);
        return ;
       }
       
       String letters = map[digits.charAt(index) - '0'];
       for(char c : letters.toCharArray()){
        backtrack(ans,digits,curr+c , index+1);
       }

    }
}













   

