/*
 * 283. Move Zeros

 * Array
 * Level: Easy
 * Runtime: 1 ms | Beats: (May vary)
 * Memory: 44 MB | Beats: (May vary)
 *
 * Given an integer array nums, move all 0's to the end
 * while maintaining the relative order of the non-zero elements.
 *
 * Note:
 * You must perform this operation in-place.
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Explanation:
 * The non-zero elements are moved to the beginning,
 * while all zeroes are placed at the end.
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 *
 * Constraints:
 * 1 <= nums.length <= 104
 *-231 <= nums[i] <= 231 - 1
 * 
 */

//code: Brute froce approach
import java.util.Arrays;
class Solution{
    public int[] MoveZeros(int[] nums){

        int[] temp=new int[nums.length];
        int index=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                temp[index]=nums[i];
                index++;
            }
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=temp[i];
        }
        return nums;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int[] nums={0,1,0,3,12};

        int[] ans=s.MoveZeros(nums);
        System.out.println(Arrays.toString(ans));
    }
}

// EXPLANATION

/*
 * The MoveZeros() method moves all zeroes to the end of the array while maintaining the relative order
 * of the non-zero elements.
 *
 * This solution uses an extra temporary array.
 *
 * int[] temp = new int[nums.length];
 * - Create a temporary array of the same size as nums, Initially, every element in temp is 0.
 *
 * int index = 0;
 * - The variable 'index' keeps track of the next position where a non-zero element should be placed.
 * 
 * First Loop
 * for(int i = 0; i < nums.length; i++)
 * - Traverse the original array.
 * - If nums[i] is not equal to 0, copy it into temp[index].
 * - Increment index.
 *
 * Second Loop
 * for(int i = 0; i < nums.length; i++)
 * - Copy every element from temp back into the original array nums.
 * 
 * Time Complexity:
 * 0(n)
 * 
 * Space Complexity:
 * 0(n)
 *  */

//code : Optimal (two pointer appraoch)

/*Level: Easy
 * Runtime: 0 ms | Beats: 100% (May vary)
 * Memory: 43 MB | Beats: 38.44%(May vary)
 */
import java.util.Arrays;
class Solution{
    public int[] MoveZeros(int[] nums){

        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] !=0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;

                j++;
            }
        }
        return nums;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        int[] nums={0,1,0,3,12};

        int[] ans=s.MoveZeros(nums);
        System.out.println(Arrays.toString(ans));
    }
}
/*
 * The moveZeros() method moves all zeroes to the end of the array while maintaining the relative order
 * of the non-zero elements.
 *
 * This solution uses the Two Pointer + Swapping Technique.
 *
 * int j = 0;
 * - Pointer 'j' keeps track of the position where the next non-zero element should be placed.
 *
 * for(int i = 0; i < nums.length; i++)
 * - Traverse the array using pointer 'i'.
 * - Whenever a non-zero element is found,swap it with the element at index 'j'.
 * 
 *  if(nums[i] != 0)
 * - Check whether the current element is non-zero.
 * - If yes, perform a swap.
 *
 * Swapping Method
 * int temp = nums[i];
 * nums[i] = nums[j];
 * nums[j] = temp;
 *
 * - Swap the current non-zero element with the element at index j.
 *- If i == j, the swap has no effect, but the logic remains simple.
 *
 * j++;
 * - Increment j so that it always points to the next available position for a non-zero element.
 * 
 * TIme Complexity:
 * 0(n)
 * 
 * Space Complexity:
 * 0(1)*/

