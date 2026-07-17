/*
26.Remove Duplicates from Sorted Array 
ARRAY
Difficulty:Easy

Runtime:0ms | Beats:100.00%
Memory:46.45MB | Beats:92.27%

Given an sorted inetger array nums , remove the duplicates **in-place** such that each unique element appears only once.
return the number of unique elements(ans).
the relative order of the elements should remain the same.

Example 1:
Input: nums = [1,1,2]
Output: 2

Example 2:
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5

Constraints:
1 <= nums.length <= 3*10^4
-100 <= nums[i] <=100
nums is sorted in non-decresing order.
*/
//code:
 
 class Dublicate {
    public int removeDublicates(int[] nums){
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j] !=nums[i]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
    public static void main(String[] args){
        Dublicate d=new Dublicate();
        int nums[]={1,1,2};
        int ans=d.removeDublicates(nums);
        System.out.println("number of unique elements:" + ans);
        System.out.println("unique elements:");

        for(int i=0;i<ans;i++){
            System.out.print(nums[i] + " ");
        }
    }

}

/*Explanation:

The first `ans` elements of the array contain the unique elements.

Approach:

This solution uses the **Two Pointer** technique.
-Pointer `i` keeps track of the last unique element.
-Pointer `j` traverses the array.
-Whenever `nums[j]` is different from `nums[i]`,
-increment 'i'
-copy `nums[j]` to `nums[i]`,
-FInally, return `i+1`, which represents the number of nuique elements.

Algorithm:
1.intialize i=0.
2.traverse the array using j from 1 to n-1.
3.if nums[j] != nums[i]
    -Increment i
    -Assign nums[i]=nums[j]
4.return i+1

Output:
Number of unique elements :2
Unique elements:1,2

Time Complexity:
0(n)

Space Complexity
0(1)

Thanks
 */
    
