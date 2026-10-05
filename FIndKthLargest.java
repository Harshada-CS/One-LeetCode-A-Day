 /*
 215.Find Kth Largest Element in an Array
 level:Medium
 
 Problem:
 Given an integer Array nums and an integer k,return the kth largest element in the array.
 the answer is based on the sorted order,not the distinct elements.
 
Example
Input:
nums = [3, 2, 1, 5, 6, 4]
k = 2
Output: 5

#Approach:
We use a Min Heap using java's priorityQueue.

Alogorithm:
1.Create a min heap of size k.
2.Traverse the every element of the array and add it to the min heap.
3.if the size of heap is greater than k,remove the top element from the heap.
4.After traversing the entire array,return the top element of the heap.
 */
 import java.util.*;

 class  FIndKthLargest{
    public int findKthLargest(int[] nums,int k){
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            minHeap.offer(nums[i]);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
    public static void main(String[] args){
        FIndKthLargest F=new FIndKthLargest();
        int[] nums={3,2,1,5,6,4};
        int k=2;
        System.out.println(F.findKthLargest(nums, k));

    }
}
/*
Time Complexity: O(n log k)
Space Complexity: O(k).
*/