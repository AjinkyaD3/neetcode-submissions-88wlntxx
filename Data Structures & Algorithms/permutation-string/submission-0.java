class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] counts=new int[26];
        int l =0;
        int[] arr1 = new int[26];
        for(char c : s1.toCharArray()){
            arr1[c - 'a'] ++;
        }

        for(int r =0;r<s2.length();r++){
            counts[s2.charAt(r) - 'a']++;

            if(r - l + 1 > s1.length()){
                counts[s2.charAt(l) - 'a']--;
                l++;
            }
            if(r - l + 1 == s1.length()){
                if(check(arr1,counts)) return true;
            }


        }
        return false;
        
    }
    public boolean check(int[] arr1, int[] arr2){
        for(int i = 0; i<26;i++){
            if(arr1[i]!=arr2[i]) return false;
        }      
        return true; 

    }
}
