/*141. Linked List Cycle
level:Easy
Runtime:0 ms || Beats:100.00%
Memory:46.99 MB|Beats:16.44%

Problem:
Given the head of a linked list,determine if the linked list contains a cycle in it.
A cycle exists when a node's next pointer back to the a previous node instead of pointing to null.

ex:
Input: head = [3,2,0,-4], pos = 1
Output: true

 */
//code:Two pointer Approach
public class LinkedListCycle{
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
    }
    public boolean hasCycle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        LinkedListCycle L=new LinkedListCycle();
        ListNode head=new ListNode(3);
        head.next=new ListNode(2);
        head.next.next=new ListNode(0);
        head.next.next.next=new ListNode(-4);
        head.next.next.next.next=head.next;

        boolean ans=L.hasCycle(head);
        System.out.println("chycle present:"+ans);
    }
}
/*
Approach:
when we use fast and slow pointer also called Floyd's cycle detection Algorithm,
we can detect cycle in linked list.

1.slow moves 1 step at a time .
2.fast moves 2 steps at a time.
3.if there is a cycle , slow and fast will eventually meet.
4.if there is no cycle ,fast will reach null and we willl return null.

Time Complexity:0(n)

Space Complexity:0(1)
 */