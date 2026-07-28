/*
 *189. Rotate Array
 * Array
 * Level: Medium
 * Runtime: 0 ms | Beats: 100% (May vary)
 * Memory: 45 MB | Beats: (May vary)
 *
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 *
 * Explanation:
 * Rotate 1 step : [7,1,2,3,4,5,6]
 * Rotate 2 steps: [6,7,1,2,3,4,5]
 * Rotate 3 steps: [5,6,7,1,2,3,4]
 *
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^5
 */

//Code:

import java.util.Arrays;

class Rotate{
    public int[] RoatateArray(int[] nums,int k){

        int n=nums.length;

        k= k %n;

        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);

        return nums;
    }
    private void reverse(int[] nums,int left,int right){
        while(left < right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;

            left++;
            right--;
        }
    }
    public static void main(String[] args){
        Rotate r=new Rotate();
        int[] nums={1,2,3,4,5,6};
        int k=2;

        int[] ans = r.RoatateArray(nums, k);
        System.out.println(Arrays.toString(ans));
    }
}
// EXPLANATION

/*
 * The RotateArray() method rotates the array to the right by k positions.
 *
 * This solution uses the Reversal Algorithm.
 *
 * int n = nums.length;
 * - Store the length of the array.
 *
 * k = k % n;
 * - If k is greater than the array length, rotating more than n times produces the same result as rotating by k % n positions.
 * 
 *  Step 1
 * reverse(nums, 0, n - 1);
 * - Reverse the entire array.
 * 
 * Step 2
 * reverse(nums, 0, k - 1);
 * - Reverse the first k elements.
 * 
 * Step 3
 * reverse(nums, k, n - 1);
 * - Reverse the remaining elements.
 * 
 * reverse() Method
 * 
 * while(left < right)
 * - Swap the left and right elements.
 * temp = nums[left]
 * nums[left] = nums[right]
 * nums[right] = temp
 *
 * - Move left forward.
 * - Move right backward.
 *
 * Continue until both pointers meet.
 * 
 * TIme Complecity:
 * 0(n)
 * 
 * Space Complecity:
 * 0(1)
 */
