class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left =1;
        int right = 0;
        for (int p : piles) {
            right = Math.max(right, p);
        }
        int ans = right;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int totalHour = 0;

            for (int p : piles) {
                totalHour += Math.ceil((double)p / mid);
            }

            if(totalHour <= h){
                ans = mid;
                right = mid-1;
            }
            else {
                left = mid + 1;   
            }

            

        }
        return ans;
    }
}
