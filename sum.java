/*
 *724. Find Pivot Index

 * Array, Prefix Sum
 * Level: Easy
 * Runtime: 1 ms | Beats: 97.99%
 * Memory: 45 MB | Beats: 88.88%
 *
 * Given an integer array nums,calculate the pivot index of this array.
 *
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index is
 * equal to the sum of all the numbers strictly to the right of the index.
 *
 * If the pivot index does not exist,
 * return -1.
 *
 * If there are multiple pivot indices,return the leftmost pivot index.
 *
 * Example 1:
 * Input: nums = [1,7,3,6,5,6]
 * Output: 3
 *
 * Explanation:
 * Left Sum  = 1 + 7 + 3 = 11
 * Right Sum = 5 + 6 = 11
 *
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: -1
 *
 * Explanation:
 * No pivot index exists.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^4
 * -1000 <= nums[i] <= 1000
 */
//Code:Better Approach

class sum{
    public int FindPivotIndex(int[] nums){
        int totalSum=0;

//vclaculaye total sum
        for(int num:nums){
            totalSum+=num;
        }

        int leftSum=0;
        for(int i=0;i<nums.length;i++){

            //rightSum
            int rightSum=totalSum - leftSum-nums[i];

            if(leftSum == rightSum){
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }

    public static void main(String[] args){
        sum s=new sum();
        int[] nums={1,7,3,6,5,6};

        int ans=s.FindPivotIndex(nums);
        System.out.println(ans);
    }
}
// EXPLANATION

/*
 * The FindPivotIndex() method finds the pivot index ,where the sum of elements on the left side
 * equals the sum of elements on the right side.
 *
 * This solution uses the Prefix Sum technique.
 *
 * int totalSum = 0;
 * - Store the sum of all elements in the array.
 *
 * First Loop
 * for(int num : nums)
 * - Traverse the array.
 * - Calculate the total sum of all elements.
 * 
 * int leftSum = 0;
 * - leftSum stores the sum of elements
 *   before the current index.
 *
 * Second Loop
 * for(int i = 0; i < nums.length; i++)
 * - Traverse the array again.
 * 
 * Calculate Right Sum
 * rightSum = totalSum - leftSum - nums[i]
 * 
 * - totalSum contains the sum of all elements.
 * - Subtract leftSum.
 * - Subtract the current element.
 * - The remaining value is the right sum.
 *
 * if(leftSum == rightSum)
 * - If both sums are equal,the current index is the pivot index.
 * - Return the current index.
 *
 * leftSum += nums[i];
 * - Update leftSum before moving to the next index.
 *
 * return -1;
 * - If no pivot index is found,return -1.
 *
 * Time COmplexity:
 * 0(n)
 * 
 * Space COmplexity:
 * 0(1)
 * 
 * THANKS
 * */