/*
 * 448.Find All Numbers Disappeared in an Array
 * Array
 * Level: Easy
 * Runtime: 2 ms | Beats:82.64% (May vary)
 * Memory: 50 MB | Beats: 55.22%(May vary)
 *
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear in nums.
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 *
 * Explanation:
 * The numbers 5 and 6 are missing from the array.
 *
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [2]
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 10^5
 * 1 <= nums[i] <= n
 *
 */
//code:

import java.util.*;
class Number{
    public List<Integer> findDisappearedNumbers(int[] nums){

        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i])-1;

            if(nums[index] > 0){
                nums[index]=-nums[index];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                ans.add(i+1);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Number n= new Number();
        int[] arr={4,3,2,7,8,2,3,1};

        List<Integer> answer= n.findDisappearedNumbers(arr);
        System.out.println(answer);
    }
}
// EXPLANATION

/*
 * The findDisappearedNumbers() method finds all the missing numbers in the range [1, n].
 * This solution uses the Negative Marking Technique.
 *
 * List<Integer> ans = new ArrayList<>();
 * - Create an ArrayList to store
 *   all missing numbers.
 *
 * First Loop
 * for(int i = 0; i < nums.length; i++)
 * - Traverse every element in the array.
 *
 * int index = Math.abs(nums[i]) - 1;
 * - Convert the current value into an index.
 * Since numbers are from 1 to n,subtract 1 to get the correct index.
 *
 * if(nums[index] > 0)
 * - If the value at that index is positive, make it negative.
 *
 * nums[index] = -nums[index];
 * - Negative values indicate that the corresponding number exists.
 *
 * Second Loop
 * for(int i = 0; i < nums.length; i++)
 * - Traverse the modified array again.
 *
 * if(nums[i] > 0)
 * - If a value is still positive,its index was never visited.
 *
 * Therefore,
 * Missing Number = i + 1, Add it to the answer list.
 * 
 * TIme COmplexity:
 * 0(n)
 * 
 * Space COmplexity:
 * 0(1)
 */
