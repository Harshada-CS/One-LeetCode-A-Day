/*
 * 162.Find Peak Element
 * Binary Search
 * Level: Medium
 * Runtime: 0 ms | Beats: 100% (May vary)
 * Memory: 44 MB | Beats: (May vary)
 *
 * A peak element is an element that is strictly greater than its neighboring elements.
 *
 * Given a 0-indexed integer array nums, find a peak element and return its index.
 *
 * If the array contains multiple peaks,return the index of any one of them.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 2
 *
 * Explanation:
 * 3 is a peak element, so return index 2.
 *
 * Example 2:
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 *
 * Explanation:
 * Both 2 and 6 are peak elements. Returning either index 1 or 5 is correct.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 * Follow-up:
 * Can you solve it in O(log n) time?
 */
//Code:Optimal Approach

class PeakEle{
    public int PeakElement(int[] nums){
        int left=0;
        int right=nums.length-1;

        while(left < right){
            int mid=left + (right-left)/2;

            if(nums[mid] > nums[mid+1]){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    public static void main(String[] args){
        PeakEle P=new PeakEle();
        int[] nums={1,2,3,1};
        int ans=P.PeakElement(nums);
        System.out.println(ans);
    }
}
// EXPLANATION

/*
 * The PeakElement() method finds the index of any peak element using Binary Search.
 *
 * A peak element is greater than both of its neighboring elements.
 *
 * int left = 0;
 * int right = nums.length - 1;
 * - Initialize two pointers representing the search space.
 *
 * while(left < right)
 *
 * - Continue searching until both pointers point to the same index.
 *
 * int mid = left + (right - left) / 2;
 * - Calculate the middle index.
 * This avoids integer overflow.
 *
 * if(nums[mid] > nums[mid + 1])
 *
 * - We are on the descending slope.
 * - A peak lies at mid or somewhere to the left.
 *
 * right = mid;
 *
 * else
 *
 * - nums[mid] < nums[mid + 1]
 *
 * - We are on the ascending slope.
 * - A peak must exist on the right side.
 * left = mid + 1;
 *
 *
 * When the loop ends:
 *
 * left == right
 *
 * This index represents a peak element.
 *
 * Return left.
 * 
 * TIme Complexity:
 * 0(log n)
 * 
 * Space Complexity:
 * 0(1)
 * */