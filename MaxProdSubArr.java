/*
 * 152.Maximum Product Subarray

 * Array, Dynamic Programming
 * Level: Medium
 * Runtime: 1 ms | Beats: 71.25%(May vary)
 * Memory: 45 MB | Beats: 73.38%(May vary)
 *
 * Given an integer array nums,find a contiguous non-empty subarray that has the largest product,
 * and return the product.
 *
 * Example 1:
 * Input: nums = [2,3,-2,4]
 * Output: 6
 *
 * Explanation:
 * The subarray [2,3] has the largest product = 6.
 *
 * Example 2:
 * Input: nums = [-2,0,-1]
 * Output: 0
 *
 * Explanation:
 * The result cannot be 2 because [-2,-1]
 * is not a contiguous subarray.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 10^4
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix
 * fits in a 32-bit integer.
 */

//Code : Optimal Approach
class MaxProdSubArr{
    public int MaximumProdSubArray(int[] nums){
        int max=nums[0];
        int min=nums[0];
        int ans=nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i] < 0){
                int temp=max;
                max=min;
                min=temp;
            }
            max=Math.max(nums[i],max*nums[i]);
            min=Math.min(nums[i],min*nums[i]);

            ans=Math.max(ans,max);
        }
        return ans;
    }
    public static void main(String[] args){
        MaxProdSubArr s=new MaxProdSubArr();
        int[] nums={2,3,-2,4};

        int ans=s.MaximumProdSubArray(nums);
        System.out.println(ans);
    }
}
// EXPLANATION

/*
 * The MaximumProdSubArray() method finds the maximum product of any contiguous subarray.
 * This solution uses Dynamic Programming.
 *
 * int max = nums[0];
 * int min = nums[0];
 * int ans = nums[0];
 *
 * - max stores the maximum product ending at the current index.
 * - min stores the minimum product ending at the current index.
 * - ans stores the overall maximum product.
 *
 * Why do we need min?
 * Multiplying two negative numbers produces a positive number.
 *
 * Example:
 *
 * (-2) × (-3) = 6
 *
 * Therefore,the smallest product can become the largest product later.
 *
 * for(int i = 1; i < nums.length; i++)
 * - Traverse the array from the second element.
 *
 * if(nums[i] < 0)
 * - If the current number is negative, swap max and min.
 *
 * This is because:
 * Positive × Negative = Negative
 * Negative × Negative = Positive
 *
 * int temp = max;
 * max = min;
 * min = temp;
 * - Swap both values.
 *
 * max = Math.max(nums[i], max * nums[i]);
 * - Choose between:
 * 1. Start a new subarray from nums[i].
 * 2. Extend the previous maximum product.
 *
 * min = Math.min(nums[i], min * nums[i]);
 * - Update the minimum product for future calculations.
 *
 * ans = Math.max(ans, max);
 * - Update the global maximum product.
 * 
 * return ans;
 * 
 * Time Complexity:
 * 0(n)
 * 
 * Space Complexity:
 * 0(1)
 * 
 * //Code : Brute Force
 * 
 * Time Complexity:
 * 0(n^2)
 * 
 * Space Complexity:
 * 0(1)
 * 
 * Thanku
 */