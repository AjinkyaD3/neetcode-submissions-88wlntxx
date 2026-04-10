class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        // Step 1: Check if at least k nodes exist
        ListNode temp = head;
        int count = 0;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        // If fewer than k nodes, return head as-is
        if (count < k) return head;

        // Step 2: Reverse k nodes
        ListNode prev = null;
        ListNode curr = head;
        int c = k;

        while (curr != null && c > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            c--;
        }

        // Step 3: Recursive call for remaining list
        head.next = reverseKGroup(curr, k);

        return prev;
    }
}