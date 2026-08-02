 /*
 *523. Continuous Subarray Sum
 * Array, Prefix Sum, HashMap
 * Level: Medium
 * Approach: Optimal (Prefix Sum + HashMap)
 * Runtime: O(n)
 * Memory: O(n)
 *
 * Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose elements sum up
 * to a multiple of k.
 *
 * A subarray is a contiguous part of an array.
 *
 * An integer x is a multiple of k if there exists an integer n such that:
 *
 * x = n * k
 * Example 1:
 * Input: nums = [23,2,4,6,7], k = 6
 * Output: true
 *
 * Explanation:
 * [2,4] has sum = 6, which is a multiple of 6.
 *
 * Example 2:
 * Input: nums = [23,2,6,4,7], k = 6
 * Output: true
 *
 * Explanation:
 * The entire array sums to 42, which is a multiple of 6.
 *
 * Example 3:
 *
 * Input: nums = [23,2,6,4,7], k = 13
 * Output: false
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 * 1 <= k <= 2^31 - 1
 */

 import java.util.HashMap;
 class Solutions {
    public boolean cotinuousSubArraySum(int[] nums,int k){
        HashMap<Integer,Integer> map=new HashMap<>();

        map.put(0,-1);
        int sum=0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

            int rem=sum% k;

            if(map.containsKey(rem)){
                if(i-map.get(rem) >=2){
                    return true;
                }
            }else{
                map.put(rem,i);
            }
        }
        return false;
    }
    public static void main(String[] args){
        Solutions S=new Solutions();
        int[] nums={23,2,4,6,7};

        boolean ans=S.cotinuousSubArraySum(nums, 6);
        System.out.println(ans);
    }
}
// EXPLANATION

/*
 * The continuousSubArraySum() method checks whether there exists a continuous subarray of length at least 2 whose sum is a
 * multiple of k.
 *
 * This solution uses Prefix Sum with a HashMap.
 *
 * HashMap<Integer, Integer> map = new HashMap<>();
 * - Key   -> Prefix Sum Remainder
 * - Value -> First Index where the remainder occurs.
 *
 * map.put(0, -1);
 * - Store remainder 0 at index -1.
 *
 * Why?
 * If the prefix sum itself becomes divisible by k, then the subarray starts from index 0.
 *
 * int sum = 0;
 * - Stores the running prefix sum.
 *
 * for(int i = 0; i < nums.length; i++)
 * - Traverse every element.
 *
 * sum += nums[i];
 * - Update the prefix sum.
 *
 * int rem = sum % k;
 * - Calculate the remainder of the prefix sum.
 *
 * Why compare remainders?
 * Suppose:
 *
 * prefixSum1 % k = r
 * prefixSum2 % k = r
 *
 * Then,
 *
 * (prefixSum2 - prefixSum1) % k = 0
 *
 * Therefore,
 * the subarray between those two indices has a sum that is divisible by k.
 *
 * if(map.containsKey(rem))
 * - The same remainder has already appeared.
 *
 * if(i - map.get(rem) >= 2)
 * - Ensure the subarray length is at least two.
 *
 * If true, return true.
 *
 * else
 * map.put(rem, i);
 * - Store the first occurrence of each remainder.
 *
 * We keep only the first occurrence because it gives the longest possible valid subarray.
 *
 * If no valid subarray is found,
 * return false.
 *
 *Time Complexity:
 * 0(n)
 *Space Complexity:
 * 0(n)
 * 
 */
