class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character,Integer> map = new HashMap<>();

        int l = 0;
        int ans = 0;
        int maxFre = 0;

        for(int r = 0; r < s.length(); r++){

            char current = s.charAt(r);

            map.put(current, map.getOrDefault(current, 0) + 1);

            maxFre = Math.max(maxFre, map.get(current));

            while((r - l + 1) - maxFre > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}