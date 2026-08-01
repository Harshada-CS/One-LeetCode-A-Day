/*
 * 560.Subarray Sum Equals K
 * Array, Prefix Sum
 * Level: Medium
 * Approach: Brute Force
 * Runtime: O(n²)
 * Memory: O(1)
 *
 * Given an integer array nums and an integer k,return the total number of continuous subarrays whose sum equals k.
 *
 * Example 1:
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 *
 * Explanation:
 * The subarrays are:
 * [1,1] (index 0 to 1)
 * [1,1] (index 1 to 2)
 * Therefore, the answer is 2.
 *
 * Example 2:
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 * Explanation:
 * [1,2]
 * [3]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 × 10⁴
 * -1000 <= nums[i] <= 1000
 * -10⁷ <= k <= 10⁷
 */

//Code:Brute force Appraoch
class SubArraySum {
    public int SubArraySumEqual(int[] nums,int k){
        int count =0;
        for(int i=0;i<nums.length;i++){
             int sum=0;
             for(int j=i;j<nums.length;j++){
                sum=sum+nums[j];
                if(sum==k){
                    count++;
                }
             }
        }
        return count;
    }
    public static void main(String[] args){
        SubArraySum S=new SubArraySum();
        int[] nums={1,1,1};

        int ans=S.SubArraySumEqual(nums,2);
        System.out.println(ans);
    }
}
// EXPLANATION

/*
 * The SubArraySumEqual() method counts the number of continuous subarrays whose sum is equal to k.
 * This solution uses the Brute Force approach.
 *
 * int count = 0;
 * - Stores the total number of subarrays whose sum equals k.
 *
 * Outer Loop
 * for(int i = 0; i < nums.length; i++)
 * - Selects the starting index of each possible subarray.
 * 
 * int sum = 0;
 * - Initialize the sum for the current starting index.
 *
 * Inner Loop
 * for(int j = i; j < nums.length; j++)
 * - Extends the subarray one element at a time.
 *
 * sum = sum + nums[j];
 * - Add the current element to the running sum.
 *
 * if(sum == k)
 * - If the running sum equals k,increment the count.
 * count++;
 *
 * After checking every possible subarray, return count.
 * */

//code:Optimal Approach
import java.util.HashMap;
class Solution{
    public int SunArraySumEqual(int[] nums,int k){
        HashMap<Integer,Integer> map=new HashMap<>();

        map.put(0,1);
        int sum=0;
        int count=0;

        for(int num:nums){
            sum+=num;

            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
    public static void main(String[] arsg){
        Solution S=new Solution();
        int[] nums={1,1,1};
        int  ans=S.SunArraySumEqual(nums, 2);
        System.out.println(ans);
    }
}
// EXPLANATION

/*
 * The SubArraySumEqual() method counts the number of continuous subarrays whose sum equals k.
 * This solution uses Prefix Sum with a HashMap.
 *
 * HashMap<Integer, Integer> map = new HashMap<>();
 *
 * - The HashMap stores:
 *   Key   -> Prefix Sum
 *   Value -> Number of times that prefix sum has occurred.
 *
 * map.put(0,1);
 * - Initially store prefix sum 0 with frequency 1.
 *
 * Why?
 *
 * If the prefix sum itself becomes equal to k,then (sum - k) = 0.
 *
 * This correctly counts subarrays starting from index 0.
 *
 * int sum = 0;
 * - Stores the running prefix sum.
 *
 * int count = 0;
 * - Stores the total number of valid subarrays.
 *
 * for(int num : nums)
 * - Traverse every element once.
 *
 * sum += num;
 * - Update the current prefix sum.
 *
 * if(map.containsKey(sum - k))
 * - Check whether a previous prefix sum equal to (sum - k) exists.
 *
 * If it exists,
 * Current Prefix Sum - Previous Prefix Sum = k
 *
 * Therefore,
 * a valid subarray is found.
 *
 * count += map.get(sum - k);
 *
 * - Add the frequency of (sum - k) because multiple previous prefix sums may produce valid subarrays.
 *
 * map.put(sum, map.getOrDefault(sum,0) + 1);
 *
 * - Store the current prefix sum or increase its frequency.
 *
 * Return count.
 * 
 * TIme COmplexity:
 * 0(n)
 * 
 * Space COmplexity:
 * 0(n)
 */
