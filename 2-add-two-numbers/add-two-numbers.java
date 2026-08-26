/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { 
 *         this.val = val; 
 *         this.next = next; 
 *     }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0); // dummy head node
        ListNode current = dummy;         // pointer for building result list
        int carry = 0;

        // loop until both lists and carry are processed
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;

            carry = sum / 10;                 // update carry
            current.next = new ListNode(sum % 10); // create new node for current digit
            current = current.next;

            if (l1 != null) l1 = l1.next;     // move ahead in l1
            if (l2 != null) l2 = l2.next;     // move ahead in l2
        }

        return dummy.next; // skip dummy and return real head
    }
}