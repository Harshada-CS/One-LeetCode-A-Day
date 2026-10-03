/*
143 .Reorder List
Problem:
Given the head of a singly linked list:
L0 → L1 → L2 → ... → Ln
Reorder the list into:
L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → ...
the nodes should be reordered wihtout chnaging their values.
Ex:
1 2 3 4 5
output:
1 5 2 4 3

Approach:
1.Find the middle of the linked List using slow and fast pointer.
2.reverse the second half of the linked lIst.
3.merge the two halves of the linked list.

*/
public class ReorderList{
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
    }
    public void recorderList(ListNode head){
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode second=slow.next;
        slow.next=null;
        ListNode prev=null;

        while(second!=null){
            ListNode temp=second.next;
            second.next=prev;
            prev=second;
            second=temp;
        }
        second=prev;
        ListNode first=head;
        while(second!=null){
            ListNode temp1=first.next;
            ListNode temp2=second.next;
            first.next=second;
            second.next=temp1;
            first=temp1;
            second=temp2;
        }

    }
    public static void main(String[] args){
     ReorderList R=new ReorderList();
     ListNode head=new ListNode(1);
     head.next=new ListNode(2);
     head.next.next=new ListNode(3);
     head.next.next.next=new ListNode(4);
     head.next.next.next.next=new ListNode(5);
     R.recorderList(head);
     ListNode temp=head;
     
     while(temp!=null){
        System.out.print(temp.val+" ");
        temp=temp.next;
     };  
    }
}
/*
Time Complexity:0(n)

Space Complexity::0(1)
*/