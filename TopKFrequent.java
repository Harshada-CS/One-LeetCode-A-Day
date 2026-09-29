/* 347. Top K Frequent Elements.
level :Medium leval

Runtime:15ms||Beats 55.52%
Memory:47.67MB || Beats:48.77%

problem:
GIven an Integer Array 'nums' and an integer 'k',return the 'k' most frequent elements.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

#Approach:
1.use a HashMap to count the frequnecy of each number in the give input array.
2.use a PriorityQueue as a min heap.
3.Add each number to the Min Heap.
4.if the heap size of  beacomes greater than 'k' , remove the elements with the smallest frequency.
5.The Heap finally contains the 'k' most frequent elements.
6.Store them in the result array and return it.

#TIme Complexity:
-HashMap frequnecy counting:0(n)
-Heap operations:0(n log k)
-Overall: O(n log k)

#Space Complexity:0(n)

 */
//Java Code:

import java.util.HashMap;
import java.util.PriorityQueue;

class TopKFrequent {
    public int[] topKFrequent(int[] nums,int k){
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> pq =new PriorityQueue<>((a,b)->Integer.compare(map.get(a),map.get(b)));
        for(int val:map.keySet()){
            pq.add(val);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] result=new int[k];
        for(int i=k-1;i>=0;i--){
            result[i]=pq.poll();
        }
        return result;
    }
    public static void main(String[] args){
        TopKFrequent t=new TopKFrequent();
        int[] nums={1,1,1,2,2,3};
        int k=2;

        int[] ans=t.topKFrequent(nums, k);
        System.out.println("top k frequnet elements:");
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]+" ");
        }
    }
}
