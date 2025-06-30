package LinkedList;
/**
 * Definition for singly-linked list.
 */

class rotateList61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0) return head;
        int n = 1;
        ListNode dummy = head;
        while(dummy.next != null) {
            dummy = dummy.next;
            n++;
        }
        int position = k % n;
        if (position == 0) return head;
        int m = n - position - 1;
        ListNode current = head;
        while(m-- > 0){
            current = current.next;
        }
        ListNode newHead = current.next;
        current.next = null;
        dummy.next = head;
        return newHead;
    }
    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        rotateList61 solution = new rotateList61();
        ListNode rotatedHead = solution.rotateRight(head, 2);
        
        // Print the rotated list
        while(rotatedHead != null) {
            System.out.print(rotatedHead.val + " ");
            rotatedHead = rotatedHead.next;
        }
    }
}