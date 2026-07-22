/* 
 *169.Majority Element
 *
 *Array, HashMap
 *Level: Easy
 *Runtime: 13 ms | Beats:31.63%
 *Memory: 52.67MB | Beats:80.72% 
 *
 * Given an array nums of size n,
 * return the majority element.
 *
 * The majority element is the element that appears
 * more than ⌊n / 2⌋ times.
 *
 * You may assume that the majority element always exists.
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Explanation:
 * The element 3 appears 2 times, which is more than ⌊3/2⌋ = 1.
 *
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * Explanation:
 * The element 2 appears 4 times, which is more than ⌊7/2⌋ = 3.
 *
 * Constraints:
 * 
 * n == nums.length
 *1 <= n <= 5 * 104
 *-109 <= nums[i] <= 109
 * 
 */

 //code:Better Approach

import java.util.HashMap;

class Solution{
    public int MajorityElement(int[] nums){
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:nums){
            if(map.get(num) > nums.length/2){
                return num;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int[] nums={2,2,1,1,2,2};

        int ans=s.MajorityElement(nums);
        System.out.println(ans);
    }
}

// EXPLANATION

/* 
 * The majorityElement() method finds the element
 * that appears more than n/2 times in the array.
 *
 * This solution uses a HashMap to store the frequency of every element.
 *
 * HashMap<Integer, Integer> map = new HashMap<>();
 *- Create an empty HashMap.
 *- Key   -> Array Element
 * - Value -> Frequency of that Element
 * 
 * for(int num : nums)
 * - Traverse every element in the array.
 *
 * map.put(num, map.getOrDefault(num, 0) + 1);
 * - If the element already exists increase its frequency by 1.
 *
 * - Otherwise,
 *   insert the element with frequency 1.
 *
 * for(int num : nums)
 * - Traverse the array again.
 *
 * if(map.get(num) > nums.length / 2);
 * - Check whether the frequency of the currentelement is greater than n/2.
 *
 * - If yes,return that element.
 *
 * return -1;
 * - This line is never reached for the given constraints because a majority element always exists.
 *
 * TIme Complexity:
 * 0(n)
 * 
 * Space Complexity
 * 0(n)
 */

 //code : Brute Force

class Solution {
    public int majorityElement(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int count = 0;

            for (int j = 0; j < n; j++) {

                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count > n / 2) {
                return nums[i];
            }
        }

        return -1;
    }
}
/*
this code on the leedcode running time is very large so limit is exceed.

Time Complexity:
0(n^2)

Space Complexity:
0(1)
*/
