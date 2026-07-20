/* 
217.Contains Dublicate

Array
Level:Easy
Runtime: 24 ms (May vary)
Memory: 81.30 MB (May vary)

Given an integer array nums,
return true if any value appears at least twice in the array,
and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true
Explanation:
The element 1 appears twice.

Example 2:
Input: nums = [1,2,3,4]
Output: false
Explanation:
All elements are distinct.

Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109

*/

//Code:Better Approach

import java.util.Arrays;
class Solution{
    public boolean ContainDublicate(int[] nums){
        Arrays.sort(nums);

        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int[] nums={1,2,3,5,6,7};

        boolean ans=s.ContainDublicate(nums);
        System.out.println(ans);
    }
}

/*Explanation:
The containsDuplicate() method checks whether the array
contains any duplicate element. 

Arrays.sort(nums);
  - First, the array is sorted in ascending order.
  - After sorting, duplicate elements become adjacent.

for(int i=0; i<nums.length-1; i++)
 - Traverse the sorted array.

if(nums[i] == nums[i+1])
  - Compare the current element with the next element.
  - If both are equal, a duplicate exists.
  - Return true immediately.

return false;
 -if no dublicate is found after checking the entire array,
 return false;

Time Complexity:
0(n log n)

Space Complexity:
0(1)
*/

//Code: Optimal Arroach

import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}

/*
Explanation:
The containsDuplicate() method checks whether an array
contains any duplicate element using a HashSet.

A HashSet stores only unique elements.

If we try to add an element that already exists,
we know a duplicate has been found.

HashSet<Integer> set = new HashSet<>();
  - Create an empty HashSet.
  - The HashSet stores every unique number encountered.
  
for (int num : nums)
 - Traverse each element of the array one by one.

if (set.contains(num))
  - Check whether the current element already exists
    in the HashSet.
  - If it exists,
   return true immediately because a duplicate
   has been found.
   
 set.add(num);
  - If the current element is not present,
   insert it into the HashSet.

 return false;
  - If the entire array is traversed and no duplicate
    is found, return false.

Time Complexity:
0(n)

Space Complexity:
0(n)
*/

//THANKS

