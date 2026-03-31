// class Solution {
//     public int maxProfit(int[] prices) {
//         int profit =0;
//         int l= prices[0];
//         int h= prices[0];
//         for(int i :prices){
//             if(i<=l){
//                 l=h=i;

//             }else if(i>=h){
//                 h=i;
//                 profit = Math.max(profit,h-l);
//             }
//         }
//         return profit;
//     }
// }
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }
}