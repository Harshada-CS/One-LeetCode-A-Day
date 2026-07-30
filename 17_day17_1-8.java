 /*
 * 54.Sort Colors
 * Array
 * Level: Medium
 * Runtime: 2 ms | Beats:14.92% (May vary)
 * Memory: 44 MB | Beats: 11.42%(May vary)
 *
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects
 * of the same color are adjacent.
 *
 * We use the integers:
 *
 * 0 -> Red
 * 1 -> White
 * 2 -> Blue
 *
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 300
 * nums[i] is either 0, 1, or 2.
 *
 */
//Code:Brute force
 import java.util.Arrays;
 class SortColors {
    public int[] SortColrs(int[] nums){
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j] > nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        return nums;
    }
    public static void main(String[] args){
        SortColors S=new SortColors();
        int[] nums={2,0,2,1,1,0};

        int[] ans=S.SortColrs(nums);
        System.out.println(Arrays.toString(ans));
    }  
}
// EXPLANATION

/*
 * The SortColors() method sorts the array containing only 0, 1, and 2.
 * This solution uses the Bubble Sort algorithm.
 *
 * Outer Loop
 *
 * for(int i = 0; i < nums.length; i++)
 * - Controls the number of passes.
 * - After every pass, the largest element moves to its correct position.
 *
 * Inner Loop
 *
 * for(int j = 0; j < nums.length - i - 1; j++)
 * - Compare adjacent elements.
 * - The loop size decreases after every pass because the last elements are already sorted.
 *
 * if(nums[j] > nums[j + 1])
 * - If the current element is greater than the next element,swap them.
 *
 * int temp = nums[j];
 * nums[j] = nums[j + 1];
 * nums[j + 1] = temp;
 *
 * - Exchange both elements.
 * 
 * TIme Complexity:
 * 0(n^2)
 * 
 * Space Complexity:
 * 0(1)
 * 
 */
//Code:Better Approach
class Solution {
    public void sortColors(int[] nums) {
        int low=0;
        int mid=0;
        int high=nums.length-1;

        while(mid <= high){
            if(nums[mid]==0){
                swap(nums,low,mid);
                low++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                swap(nums,mid,high);
                high--;
            }
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
//Time Complexity = O(n)
//Space Complexity = O(1)


