/*
 * 229.Majority Element II
 * Array
 * Level: Medium
 * Approach: Brute Force
 * Runtime: O(n²)
 * Memory: O(1) (Ignoring output list)
 *
 * Given an integer array nums of size n, return all elements that appear more than ⌊n / 3⌋ times.
 *
 * Since an element can appear more than ⌊n / 3⌋ times, there can be at most two such elements.
 *
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: [3]
 *
 * Example 2:
 * Input: nums = [1]
 * Output: [1]
 *
 * Example 3:
 * Input: nums = [1,2]
 * Output: [1,2]
 *
 * Constraints:
 * 1 <= nums.length <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 */
//Code Brute Force Approach

import java.util.ArrayList;
import java.util.List;
class MajorityEle {
    public List<Integer> MajorityElement(int[] nums){
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
            if(count > nums.length/3 && !ans.contains(nums[i])){
                ans.add(nums[i]);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        MajorityEle M=new MajorityEle();
        int[] nums={3,2,3};
        List<Integer> ans=M.MajorityElement(nums);
        System.out.println(ans);
    }
}
/* 
Explanation:
 * The MajorityElement() method finds all elements that appear more than ⌊n/3⌋ times using the Brute Force approach.
 *
 * List<Integer> ans = new ArrayList<>();
 * - Create an ArrayList to store the majority elements.
 *
 * for(int i = 0; i < nums.length; i++)
 * - The outer loop selects one element at a time.
 *
 * int count = 0;
 * - Initialize a counter to count the occurrences of nums[i].
 *
 * for(int j = 0; j < nums.length; j++)
 * - Compare nums[i] with every element in the array.
 *
 * if(nums[i] == nums[j])
 * - If both elements are equal, increment the counter.
 * count++;
 *
 * if(count > nums.length / 3 && !ans.contains(nums[i]))
 *
 * - Check whether the frequency of nums[i] is greater than ⌊n/3⌋.
 * - Also ensure that the element is not already present in the answer list.
 *
 * ans.add(nums[i]);
 *
 * Return ans.
 * 
 * Time Complexity:
 * 0(n^2)
 * 
 * Space Complexity:
 * 0(1)
 */

//Code :Optimal Approach(HashSet)
//Runtime :16ms | Beats 21.48
//memory:53.04MB | Beats 16.93

import java.util.*;
class MajorityEle{
    public List<Integer> MajorityElement(int[] nums){
        List<Integer> ans=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num, 0)+1);
        }
        for(int key:map.keySet()){
          if(map.get(key) > nums.length/3){
            ans.add(key);
          }
        }
        return ans;
    }
    public static void main(String[] args){
        MajorityEle M=new MajorityEle();
        int[] nums={3,2,3};
        List<Integer>ans=M.MajorityElement(nums);
        System.out.println(ans);
    }
}
/*
 *Explanation:
 * The MajorityElement() method finds all elements that appear more than ⌊n/3⌋ times using a HashMap.
 *
 * List<Integer> ans = new ArrayList<>();
 * - Create an ArrayList to store the majority elements.
 *
 * HashMap<Integer, Integer> map = new HashMap<>();
 * - Create a HashMap where:
 *   Key   -> Array element
 *   Value -> Frequency of that element
 *
 * for(int num : nums)
 * - Traverse the array.
 *
 * map.put(num, map.getOrDefault(num, 0) + 1);
 * - If the element already exists, increase its frequency by 1.
 * - Otherwise, insert it with frequency 1.
 *
 * for(int key : map.keySet())
 * - Traverse every unique element stored in the HashMap.
 *
 * if(map.get(key) > nums.length / 3)
 *
 * - Check whether the frequency of the current element is greater than ⌊n/3⌋.
 *
 * ans.add(key);
 * - Add the majority element to the answer list.
 *
 * Return ans.
 * 
 * Time Complexity:
 * 0(n)
 * 
 * Space Complexity:
 * 0(n)
 * */
