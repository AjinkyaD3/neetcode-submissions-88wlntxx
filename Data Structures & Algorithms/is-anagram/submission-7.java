class Solution {
    public boolean isAnagram(String s1, String t) {
        if(s1.length() != t.length())return false;
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i = 0; i<s1.length();i++){
            map1.put(
                s1.charAt(i),
                map1.getOrDefault(s1.charAt(i),0)+1 
            );
            map2.put(
                t.charAt(i),
                map2.getOrDefault(t.charAt(i),0)+1 
            );
        }

        // for(char k: map1.keySet()){
        //     if(!(map1.containsKey(k)&&map2.containsKey(k)))return false;
            
        //     if(map1.get(k) != map2.get(k)){
        //         return false;
        //     }
        // }


        return map1.equals(map2);


    }

    
}
