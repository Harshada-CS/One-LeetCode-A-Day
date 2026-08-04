/*
* 442.Find All Duplicates in an Array
 * Array
 * Level: Medium
 * Approach: Brute Force
 * Runtime: O(n²)
 * Memory: O(1) (Ignoring output list)
 *
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n]
 * and each integer appears once or twice.
 *
 * Return an array of all the integers that appear twice.
 *
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 *
 * Example 2:
 * Input: nums = [1,1,2]
 * Output: [1]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10⁵
 * 1 <= nums[i] <= nums.length
 * Each element appears once or twice.
 */
//Code:Brute Force Appraoch

import java.util.ArrayList;
import java.util.List;

class AllDuplicate{
    public List<Integer> FindAllDuplicates(int[] nums){
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] ==nums[j]){
                    ans.add(nums[i]);
                    break;
                }
            }
        }
        return ans;
    }
    public static void main(String[] atgs){
        AllDuplicate ad=new AllDuplicate();
        int[] nums={4,3,2,7,8,2,3,1};
        List<Integer> ans=ad.FindAllDuplicates(nums);
        System.out.println(ans);
    }
}
/*
 * The FindAllDuplicates() method finds all duplicate elements using the Brute Force approach.
 *
 * List<Integer> ans = new ArrayList<>();
 * - Create an ArrayList to store all duplicate numbers.
 *
 * for(int i = 0; i < nums.length; i++)
 * - The outer loop selects one element at a time.
 *
 * for(int j = i + 1; j < nums.length; j++)
 * - The inner loop compares the current element with every remaining element.
 *
 * if(nums[i] == nums[j])
 * - If both elements are equal, a duplicate is found.
 *
 * ans.add(nums[i]);
 * - Add the duplicate element to the answer list.
 *
 * break;
 * - Stop checking further because each number appears at most twice.
 *
 * Return ans.
 * 
 * Time Complexity:
 * 0(n^2)
 * 
 * Space Complexity:
 * 0(1)
 */

//Code:Optimized Approach

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
class AllDuplicate{
    public List<Integer> FindAllDuplicates(int[] nums){
        HashSet<Integer> set=new HashSet<>();
        List<Integer> ans=new ArrayList<>();

        for(int num:nums){
            if(set.contains(num)){
                ans.add(num);
            }else{
                set.add(num);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        AllDuplicate ad=new AllDuplicate();
        int[] nums={4,3,2,7,8,2,3,1};
        List<Integer> ans=ad.FindAllDuplicates(nums);
        System.out.println(ans);
    }
}
/*
Explanation:
 *
 * The FindAllDuplicates() method finds all duplicate elements using a HashSet.
 *
 * HashSet<Integer> set = new HashSet<>();
 * - Create a HashSet to store the elements that have already been seen.
 *
 * List<Integer> ans = new ArrayList<>();
 * - Create an ArrayList to store duplicate elements.
 *
 * for(int num : nums)
 * - Traverse each element of the array.
 *
 * if(set.contains(num))
 * - Check whether the current element already exists in the HashSet.
 *
 * - If it exists, then it is a duplicate.
 *
 * ans.add(num);
 * - Add the duplicate number to the answer list.
 *
 * else
 * set.add(num);
 * - If the element has not been seen before,  add it to the HashSet.
 * 
 * Return ans;
 * 
 * Time Complexity:
 * 0(n)
 * 
 * Space Complexity:
 * 0(n)
 * 
 * THANKS
*/
