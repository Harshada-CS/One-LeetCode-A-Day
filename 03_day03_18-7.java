/* 
121.Best Time to Buy and Sell Stock
Array
level:Easy
Rumtime: 2ms | Beats:42.30%
Memory :94.42 MB| Beats:51.69%

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock
and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction.
if no profit can be achived,return 0.

Example:
Input: prices ={7,1,5,3,6,4}
output: 5
Buy on day 2 (prices=1) and cell on day 5 (prices=6).
Profit = 6-1=5.

Input: prices = [7,6,4,3,1]
Output: 0
Explanation:
In this case, no transaction can generate a positive profit.

Contraints:
1 <= prices.length <= 105
0 <= prices[i] <= 104
*/

//Code:
class profit {
    public int maxProfit(int[] prices){
        int minPrice=prices[0];
        int maxProfit=0;

        for(int i=1;i<prices.length;i++){
            if(prices[i] < minPrice){
                minPrice= prices[i];
            }else{
                int profit=prices[i]-minPrice;

                if(profit > maxProfit){
                    maxProfit=profit;
                }
            }
        }
        return maxProfit;
    }
    public static void main(String[] args){
        profit p=new profit();
        int[] prices={7,1,5,3,6,4};
        int ans=p.maxProfit(prices);
        System.out.println("Maximum profit:" + ans);   
    } 
}

/*
EXPLANATION

The `maxProfit` method finds the maximum profit that can be earned
by buying and selling a stock only once.
 *
int minPrice = prices[0];
  - `minPrice` stores the minimum stock price encountered so far.
  - Initially, the first day's price is considered the minimum.

int maxProfit = 0;
   - `maxProfit` stores the highest profit found during traversal.
   - Initially, no profit is possible, so it is set to 0.
 
for (int i = 1; i < prices.length; i++) {
  - Traverse the array starting from the second day.

 if (prices[i] < minPrice) {
  - If the current stock price is smaller than the minimum price,
     update `minPrice`.
  - This means we found a better day to buy the stock.

else {
  - Otherwise, calculate the profit by selling on the current day.
 
int profit = prices[i] - minPrice;
   - Calculate the profit obtained by selling today
    after buying at the minimum price.
 
if (profit > maxProfit) {
   - Compare the current profit with the maximum profit.
   - If it is greater, update `maxProfit`.
 
return maxProfit;
   - After traversing the array, return the maximum profit.
   
Time Complexity:
0(n)

Space Compleexity:
0(1)
-only two extra variables (minPrice and maxProfit) are used.

THANKS

*/
