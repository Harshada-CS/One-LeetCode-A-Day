/*
 *287.Find the Duplicate Number
 * Array
 * Level: Medium
 * Approach: Brute Force
 * Runtime: O(n²)
 * Memory: O(1)
 *
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array and using only constant extra space.
 *
 * Example 1:
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 *
 * Example 2:
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 *
 * Example 3:
 * Input: nums = [3,3,3,3,3]
 * Output: 3
 *
 * Constraints:
 *
 * 1 <= n <= 10^5
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * There is only one repeated number.
 */
//Code :Brute Force
class DuplicateNum{
    public int FindDuplicate(int[] nums){
       for(int i=0;i<nums.length;i++){
        for(int j=i+1;j<nums.length;j++){
            if(nums[i]==nums[j]){
                return nums[i];
            }
        }
       }
       return -1;
    }
    public static void main(String[] args){
        DuplicateNum D=new DuplicateNum();
        int[] nums={1,3,4,2,2};
        int ans=D.FindDuplicate(nums);
        System.out.println(ans);
    }
}
/* Explantion:

 * The FindDuplicate() method returns the duplicate number present in the array.
 * This solution uses the Brute Force approach.
 *
 * Outer Loop
 * for(int i = 0; i < nums.length; i++)
 * - Select one element at a time.
 *
 * Inner Loop
 * for(int j = i + 1; j < nums.length; j++)
 * - Compare the current element with every remaining element.
 *
 * if(nums[i] == nums[j])
 * - If both elements are equal, a duplicate has been found.
 *
 * return nums[i];
 * - Return the duplicate number immediately.
 *
 * If no duplicate is found,
 * return -1;
 *
 * TIme COmplexity:
 * 0(n^2)
 * 
 * Space COmplexity:
 * 0(1)
 * 
 * (According to the problem constraints, this case will never occur because one duplicate always exists.)
 */

//using Sorting:Better Appraoch

import java.util.Arrays;
class DuplicateNum{
    public int findDuplicate(int[] nums){
      Arrays.sort(nums);
      for(int i=1;i<nums.length;i++){
        if(nums[i]==nums[i-1]){
            return nums[i];
        }
      }
      return -1;
    }
    public static void main(String[] args){
        DuplicateNum D=new DuplicateNum();
        int[] nums={1,3,4,2,2};
        int ans=D.findDuplicate(nums);
        System.out.println(ans);
    }
}
 /* 
 * The findDuplicate() method returns the duplicate number using the Sorting approach.
 *
 * Arrays.sort(nums);
 * - First, sort the array in ascending order.
 *
 * Example:
 * Before Sorting:
 * [1,3,4,2,2]
 *
 * After Sorting:
 * [1,2,2,3,4]
 *
 * for(int i = 1; i < nums.length; i++)
 * - Traverse the sorted array starting from index 1.
 *
 * if(nums[i] == nums[i - 1])
 * - Compare the current element with the previous element.
 *
 * - If both are equal, then a duplicate has been found.
 *
 * return nums[i];
 * - Return the duplicate number.
 *
 * If no duplicate is found,
 * return -1;
 *
 *Time COmplexity:
 *0(n log n)
 *
 *Space COmplexity:
 *0(1)
 *
 */

//code HashMap:Better Approach
import java.util.HashSet;
class DuplicateNum{
    public int findDuplicate(int[] nums){
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            if(set.contains(num)){
                return num;
            }
            set.add(num);
        }
        return -1;
    }
    public static void main(String[] args){
        DuplicateNum D=new DuplicateNum();
        int[] nums={1,3,4,2,2};
        int ans=D.findDuplicate(nums);
        System.out.println(ans);
    }
 }

 /*
 * The findDuplicate() method finds the duplicate number using a HashSet.
 * A HashSet stores only unique elements.
 *
 * HashSet<Integer> set = new HashSet<>();
 * - Create an empty HashSet.
 *
 * - The HashSet stores every element that has already been visited.
 *
 * for(int num : nums)
 * - Traverse each element of the array.
 *
 * if(set.contains(num))
 * - Check whether the current element already exists in the HashSet.
 *
 * - If it exists, then it is the duplicate number.
 * return num;
 *
 * set.add(num);
 *
 * - If the element is not present, add it to the HashSet.
 *
 * If no duplicate is found,
 * return -1;
 * 
 * TIme COmplexity:
 * 0(n)
 * 
 * Space Complexity:
 * 0(n)
 * 
 * Thanku
 * */
