/*
 * 283.Missing Number
 * Array
 * Level: Easy
 * Runtime: 0 ms | Beats: 100% (May vary)
 * Memory: 45 MB | Beats: (May vary)
 *
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the
 * range that is missing from the array.
 *
 * Example 1:
 * Input: nums = [3,0,1]
 * Output: 2
 *
 * Explanation:
 * Numbers from 0 to 3 are [0,1,2,3].
 * The missing number is 2.
 *
 * Example 2:
 * Input: nums = [0,1]
 * Output: 2
 *
 * Explanation:
 * Numbers from 0 to 2 are [0,1,2].
 * The missing number is 2.
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 10^4
 * 0 <= nums[i] <= n
 * All numbers are unique.
 */

//Code:Better Approach

import java.util.HashSet;
class missing{
    public int MissingNumber(int[] nums){

        HashSet<Integer> set=new HashSet<>();
        int n=nums.length;

        for(int num:nums){
            set.add(num);
        }

        for(int i=0;i<=nums.length;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        missing m=new missing();
        int[] nums={3,0,1};

        int ans=m.MissingNumber(nums);
            System.out.println(ans);
        
    }
}
//Explanation:

/*
 * The missingNumber() method finds the missing number from the range [0, n].
 * This solution uses a HashSet.
 *
 * HashSet<Integer> set = new HashSet<>();
 * - Create an empty HashSet.
 * - Store every element of the array.
 *
 * for(int num : nums)
 * - Traverse the array.
 * - Insert every element into the HashSet.
 *
 * for(int i=0; i<=nums.length; i++)
 * - Check every number from 0 to n.
 *
 * if(!set.contains(i))
 *
 * - If a number is not present in the HashSet, it is the missing number.
 *
 * Return that number.
 * 
 * Time Complexity:
 * 0(n)
 * 
 * Space COmplexity:
 * 0(n)
 */

//Code:Brute Force Approach
class missing{
    public int MissingNumber(int[] nums){

        int n=nums.length;

        for(int i=0;i<n;i++){

            boolean found=false;

            for(int j=0;j<n;j++){
                if(nums[j] ==i){
                    found=true;
                    break;
                }
            }
        if(!found){
            return i;
        }
        }
        return -1;
    }
    public static void main(String[] args){
        missing m=new missing();
        int[] nums={3,0,1};

        int ans=m.MissingNumber(nums);
        System.out.println(ans);
        
    }
}

// EXPLANATION

/*
 * The missingNumber() method finds the missing number from the range [0, n].
 * This solution uses the Brute Force approach.
 *
 * int n = nums.length;
 * - Store the size of the array.
 *
 * Outer Loop
 *
 * for(int i = 0; i <= n; i++)
 * - Check every number from 0 to n.
 * - Assume that the current number is missing.
 * boolean found = false;
 *
 * Inner Loop
 *
 * for(int j = 0; j < n; j++)
 * - Traverse the entire array.
 * - Compare nums[j] with the current number i.
 *
 * if(nums[j] == i)
 * - If the current number exists in the array,set found = true and stop searching by using break.
 *
 * if(!found)
 * - After checking the complete array, if the number is still not found return that number because it is missing.
 *
 * Time Complexity:
 * 0(n^2)
 * 
 * Space Complexity:
 * 0(1)
 */
