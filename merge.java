/*
88.Merge Sorted Array
Array
level:Easy

Runtime:0ms | Beats:100.00%
Memory:43.93MB | Beats:29.31%

You are given two integer arrays nums1 and nums2 sorted in non-decreasing order,
and two integers m and n representing the number of elements in nums1 and nums2 respectively.

Merge nums2 into nums1 as one sorted array.

The final sorted array should not be returned by the function,
but instead be stored inside the array nums1.

Example 1:
Input:
nums1 = [1,2,3,0,0,0]
m = 3
nums2 = [2,5,6]
n = 3
Output:
[1,2,2,3,5,6]

Example 2:
Input:
nums1 = [1]
m = 1
nums2 = []
n = 0
Output:
[1]

Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109

*/
//code:

import java.util.Arrays;
 class merge{
    public int[] merge(int[] nums1,int m,int[] nums2,int n){

        int i=m-1;
        int j=n-1;
        int k=m+n-1;

        while(i>=0 && j>=0){
            if(nums1[i] > nums2[j]){
               nums1[k]=nums1[i];
               i--;
            }else{
                nums1[k]=nums2[j];
                j--;
            }
            k--;
    }
    while(j>=0){
      nums1[i]=nums2[j];
      j--;
      k--;  
    }
        return nums1;
}
    public static void main(String[] args){
     merge m=new merge();
     int[] nums1={1,2,3,0,0,0};
     int[] nums2={2,5,6};

     int[] ans=m.merge(nums1,3,nums2,3);
     System.out.println(Arrays.toString(ans));
    }
 }

/*Explanation:

The goal is to merge two sorted arrays into nums1 without
using any extra array.

Step 1:
int i = m - 1;
- i points to the last valid element of nums1.

Step 2:
int j = n - 1;
- j points to the last element of nums2.

Step 3:
int k = m + n - 1;
- k points to the last index of nums1.
nums1 = [1,2,3,0,0,0]
                   k

Step 4:
Compare nums1[i] and nums2[j].

If nums1[i] is greater,
copy nums1[i] into nums1[k].
Otherwise,
copy nums2[j] into nums1[k].
After copying,
move the corresponding pointer backward.

Step 5:
Continue until either array is exhausted.

Step 6:
If nums2 still contains elements,
copy the remaining elements into nums1.
No need to copy remaining elements from nums1 because
they are already in their correct position.

Time Complexity:
0(m+n)

Space Complexity:
0(1)

Only three extra variables (i, j, k) are used.

THANKS
*/

