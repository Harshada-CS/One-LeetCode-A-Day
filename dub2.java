/*
219.Contains Dublicates II
Array,HahMap
Level:Easy
Runtime:27ms | Beats 20.91%
Memory: 111.11MB | Beates 5.10%

Given an integer array nums and an integer k,
return true if there are two distinct indices i and j
such that nums[i] == nums[j]
and the absolute difference between i and j is at most k.

Example 1:
Input:
nums = [1,2,3,1]
k = 3

Output:True;
Explanation:
nums[0] = nums[3] = 1
|3 - 0| = 3 ≤ k

Example 3:
Input:
nums = [1,2,3,1,2,3]
k = 2
Output:false

Explanation:
Duplicate elements exist,
but their index difference is greater than k.

Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105

*/

//Code:Optimal Approach

import java.util.HashMap;

 class dub2 {
    public boolean ContainDublicate2(int[] nums,int k){
    HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){

            if(map.containsKey(nums[i])){

                if(i-map.get(nums[i]) <= i){
                    return true;
                }
            }
            map.put(nums[i],i);
        }
        return false;
    }
    public static void main(String[] args){
        dub2 d=new dub2();
        int[] nums={1,2,3,1};
        int k=3;

        boolean ans=d.ContainDublicate2(nums, k);
        System.out.println(ans);
    }
    
}
// EXPLANATION

/*
The containsNearbyDuplicate() method checks whether
the array contains duplicate elements whose indices
differ by at most k.
 
The solution uses a HashMap.

HashMap<Integer, Integer> map = new HashMap<>();
 - The HashMap stores:
   Key   -> Array Element
   Value -> Latest Index of that Element

 for (int i = 0; i < nums.length; i++)
  - Traverse the array from left to right.

if(map.containsKey(nums[i]))
  - Check whether the current number has 
    already appeared.

if(i - map.get(nums[i]) <= k)
  - Calculate the distance between
    the current index and the previous index.
 
  - If the distance is less than or equal to k,
    return true immediately.

 map.put(nums[i], i);
   - Store or update the latest index
     of the current element.

return false;
  - If the traversal finishes without finding
    any valid duplicate,
    return false.

Time Complexity:
0(n)

Space Complexity:
0(n);

Why HashMap?
 
  Brute Force Approach:
  Time Complexity = O(n²)
 
  HashMap Approach:
  Time Complexity = O(n)
 
  The HashMap stores the latest index of each element,
  allowing us to calculate the index difference in
  constant time.
*/

//code:Brute Force Approach

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length && j <= i + k; j++) {

                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}

//Time Complexity:0(n^2)

 
