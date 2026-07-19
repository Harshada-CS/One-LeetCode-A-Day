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

//Code:Opitmal Approach

import java.util.Arrays;
class dub{
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
        dub d=new dub();
        int[] nums={1,2,3,5,6,7};

        boolean ans=d.ContainDublicate(nums);
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

THANKS
*/