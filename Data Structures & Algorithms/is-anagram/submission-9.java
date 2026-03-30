class Solution {
    public boolean isAnagram(String s1, String t) {
        if(s1.length() != t.length())return false;
        int[] arr = new int[26];
        // HashMap<Character,Integer> map1 = new HashMap<>();
        // HashMap<Character,Integer> map2 = new HashMap<>();

        for(int i = 0; i<s1.length();i++){
            // map1.put(
            //     s1.charAt(i),
            //     map1.getOrDefault(s1.charAt(i),0)+1 
            // );
            // map2.put(
            //     t.charAt(i),
            //     map2.getOrDefault(t.charAt(i),0)+1 
            // );
            arr[s1.charAt(i) - 'a'] ++;
            arr[t.charAt(i) - 'a'] --;
        }
        
        for(int i :arr){
            if(i!= 0)return false;
        }
       return true;
        // return map1.equals(map2);



    }

    
}
