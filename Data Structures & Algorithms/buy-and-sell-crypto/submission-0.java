class Solution {
    public int maxProfit(int[] prices) {
        int profit =0;
        int l= prices[0];
        int h= prices[0];
        for(int i :prices){
            if(i<=l){
                l=h=i;

            }else if(i>=h){
                h=i;
                profit = Math.max(profit,h-l);
            }
        }
        return profit;
    }
}
