/* 1.Two Sum 
ARRAY
level:Easy
runtime:44 ms | Beats:40.20%
given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
you may assume that each input will have exactly one solution, and you may not use the same element twice.

Example 1:
Input: nums = [2,7,11,13], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]
Explanation: Because nums[1] + nums[2] == 6, we return [1, 2].

Constraint:
- 2 <= nums.length <= 10^4
- -10^9 <= nums[i] <= 10^9
- -10^9 <= target <= 10^9
- Only one valid answer exists.

Follow up : Can you come up with an algorithm that is less than O(n^2) time complexity? 
*/

//Ans: Brute Force

import java.util.Arrays;
class Solution {
    public int[] twoSum (int[] nums,int target){
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]== target){
                    int[] arr={i,j};
                    return arr;
                }
            }
        }
        return null;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int[] nums={2,7,11,13};
        int target=13;

        int[] answer=s.twoSum(nums,target);
        System.out.println(Arrays.toString(answer));
    } 
}

/* Explanation :

Name:twoSum(Using Array)
find the indices of two numbers in the array that add up to the target value.
@params nums: Array of integers
@params target: Integer value to find the sum of two numbers
@return: Array containing the indices of the two numbers that add up to the target value,or null if no such pair exists;

For Loop:
Outer loop iterates over the array with the first pointer(i).
Inner loop iterates over the array with the second pointer(j),starting from the next element (i + 1).

Conditional check:
If the sum of the elements at indices i and j equals the target, return the array containing these indices.

Return Statement:
Returns the indices in an array if a valid pair is found.
Returns null if no such pair found.

Main Method:
Defines an example array and target value, 
then calls the twoSum method and prints the result.
print the result as a string representation of the array.

The Array.toString(answer) method is used to convert the integer array answer into a human-readable string format.
This allows you to print the array in a readable form, displaying the elements enclosed in square brackets, separated by commas.
  
In this repository, we focus on solving selected DSA problems and providing clear explanations for each solution. As we progress, we will delve into more advanced features and concepts, including analyzing the time complexity of our solutions, optimizing performance, and exploring alternative algorithms. Stay tuned for upcoming series where we will discuss these advanced topics in detail, offering insights into improving efficiency and understanding the underlying principles of algorithm design.
 
THANKS
*/