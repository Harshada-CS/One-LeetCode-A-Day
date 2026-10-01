/*
 *19. Remove Nth Node From End of List

Level:medium
Runtime:0 ms||Beats:100.00%
Memory:43.53MB || Beats:39.54%

problem:Given the head of a Linked list, remove the nth node from the end of the list 
and return its head.

Example
Input:
1 → 2 → 3 → 4 → 5
n = 2
Output
1 → 2 → 3 → 5

 */
//code:Two Pointer Approach
class RemoveNthNodeFromEnd {

    // ListNode class
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removenthnode(ListNode head, int n) {

        // decalre dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        // move fast pointer with n spaces n=2
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {

        RemoveNthNodeFromEnd R = new RemoveNthNodeFromEnd();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;

        ListNode ans = R.removenthnode(head, n);

        // print linked list
        ListNode temp = ans;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
/*
Approach:

1.We use the Two Pointer Approach to remove the end of the linked list.
Slow and fast pinter
2. We create a dummy node and point it to the head of the linked list.
3. We move the fast pointer n steps ahead of the slow pointer.
4. We move both pointers until the fast pointer reached the end of the linked list.
5. slow.next will be the node that we want to remove.then we set slow.next to slow.next.next to remove the node.
6.finally , we return dummy.next as the new head of the linked list.

TIme Complexity: 0(n);
Space COmplexity:0(1);
 */