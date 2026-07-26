/*
 * 414.Third Maximum Number
 * Array
 * Level: Easy
 * Runtime: 1 ms | Beats: 98.86%(May vary)
 * Memory: 45 MB | Beats: 59.10%(May vary)
 *
 * Given an integer array nums, return the third distinct maximum number in the array.
 *
 * If the third distinct maximum does not exist,return the maximum number.
 *
 * Example 1:
 * Input: nums = [3,2,1]
 * Output: 1
 *
 * Explanation:
 * The first maximum is 3.
 * The second maximum is 2.
 * The third maximum is 1.
 *
 * Example 2:
 *
 * Input: nums = [1,2]
 * Output: 2
 *
 * Explanation:
 * The third maximum does not exist,
 * so return the maximum number 2.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 */

//Code:
class Thirdmaximum{
    public int ThirdMaximum(int[] nums){

        long first=Long.MIN_VALUE;
        long second=Long.MIN_VALUE;
        long third=Long.MIN_VALUE;

        for(int num:nums){
            if(num== first || num==second || num==third){
                continue;
            }
            if(num > first){
                third=second;
                second=first;
                first=num;
            }else if(num > second){
                third=second;
                second=num;
            }else if(num > third){
                third=num;
            }
        }
        return third==Long.MIN_VALUE? (int) first:(int) third;
    }
    public static void main(String[] args){
        Thirdmaximum t=new Thirdmaximum();
        int[] nums={3,2,1};

        int ans=t.ThirdMaximum(nums);
        System.out.println(ans);
    }
}
// EXPLANATION

/*
 * The ThirdMaximum() method returns the third distinct maximum number in the array.
 *
 * If there are fewer than three distinct numbers,it returns the maximum number.
 *
 * This solution maintains the three largest distinct numbers while traversing the array only once.
 *
 * long first = Long.MIN_VALUE;
 * long second = Long.MIN_VALUE;
 * long third = Long.MIN_VALUE;
 *
 * - Store the first, second and third maximum values.
 *
 * - Long.MIN_VALUE is used instead of Integer.MIN_VALUE
 *   because the array itself may contain Integer.MIN_VALUE.
 *
 * for(int num : nums)
 * - Traverse every element in the array.
 *
 * if(num == first || num == second || num == third)
 * - Ignore duplicate values.
 * - Only distinct numbers should be considered.
 *
 * if(num > first)
 * - A new largest element is found.
 *
 * Shift:
 * third = second
 * second = first
 * first = num
 *
 * else if(num > second)
 * - The number is smaller than first but larger than second.
 *
 * Shift:
 * third = second
 * second = num
 * 
 * else if(num > third)
 * - Update the third maximum.
 *   third = num;
 * 
 * return third == Long.MIN_VALUE ?
 *        (int) first : (int) third;
 *
 * - If the third maximum was never updated,return the largest element.
 *- Otherwise return the third maximum.
 *
 *Time Complecity:
 *0(n)
 *
 * Space Complexity:
 * 0(1)
 * 
 * THANKS
 */
