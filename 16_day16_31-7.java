/*
 * 53.Maximum Subarray
 * Array, Dynamic Programming
 * Level: Medium
 * Runtime: 1 ms | Beats:99.95% (May vary)
 * Memory: 45 MB | Beats:48.81% (May vary)
 *
 * Given an integer array nums,find the contiguous subarray(containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 *
 * Explanation:
 * The subarray [4,-1,2,1]
 * has the largest sum = 6.
 *
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 */

//Code: Optimal Approach
class MaxSubArray {
    public int MaxSubArray(int[] nums){
        int maxSum=Integer.MIN_VALUE;
        int currentSum=0;

        for(int i=0;i<nums.length;i++){
            currentSum+=nums[i];

            if(currentSum > maxSum){
                maxSum=currentSum;
            }
            if(currentSum < 0){
                currentSum=0;
            }
        }
        return maxSum;
    }
    public static void main(String[] args){
        MaxSubArray m=new MaxSubArray();
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};

        int ans=m.MaxSubArray(nums);
        System.out.println(ans);
    } 
}
// EXPLANATION

/*
 * The MaxSubArray() method finds the maximum sum of any contiguous subarray.
 * This solution uses Kadane's Algorithm.
 *
 * int maxSum = Integer.MIN_VALUE;
 * - Stores the maximum subarray sum found so far.
 *
 * int currentSum = 0;
 * - Stores the sum of the current subarray.
 *
 * for(int i = 0; i < nums.length; i++)
 * - Traverse every element of the array.
 *
 * currentSum += nums[i];
 * - Add the current element to the running subarray sum.
 *
 * if(currentSum > maxSum)
 * - Update maxSum if the current subarray has a larger sum.-
 *
 * if(currentSum < 0)
 * - If the running sum becomes negative,discard it.
 * - A negative sum can only decrease the sum of any future subarray.
 *
 * currentSum = 0;
 * 
 * return maxSum;
 * 
 * Time Complexity:
 * 0(n)
 * 
 * Space COmplexity:
 * 0(1)
 * 
 * //code:Brute Force:
 * 
 *  Time Complexity = O(n²)
 * 
 * Space Complexity = O(1)
 * 
 */
