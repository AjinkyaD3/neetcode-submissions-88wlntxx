class Solution {
    public String minWindow(String s, String t) {
       
        int c1[] = new int[128];
        int c2[] = new int[128];

        for(char c : t.toCharArray()){
            c1[c]++;
        }
        int left=0;
        int min=Integer.MAX_VALUE;
        String minString = "";

        for(int right =0; right<s.length();right++){
            c2[s.charAt(right)]++;

            while(check(c1,c2)){
                
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    minString = s.substring(left, right + 1);
                }

                c2[s.charAt(left)] -- ;
                left++;
            }
        }

        return minString;
    }

    boolean check(int arr1[] , int arr2[] ){
        for(int i=0;i<128;i++){
            if(arr1[i] > arr2[i]){
                return false;
            }
        }
        return true;
    }
}