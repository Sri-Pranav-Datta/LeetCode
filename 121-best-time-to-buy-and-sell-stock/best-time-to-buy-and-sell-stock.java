class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int n = prices.length;
        int maxProfit=0;

        for(int i=1; i<n; i++){
            if(prices[i]<min){
                min=prices[i];
            }
            else{
                if(prices[i]-min > maxProfit){
                    maxProfit=prices[i]-min;
                }
            }
        }

        return maxProfit;
    }
    
}