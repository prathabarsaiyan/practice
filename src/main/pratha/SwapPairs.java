package main.pratha;

/**
 * Swap the elements by pair in a linked list
 *
 *
 * input : 1-2-3-4-5
 * output: 2-1-4-3-5
 */


public class SwapPairs {

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = head;

        while(temp.next != null){
            int k = temp.val;
            temp.val = temp.next.val;
            temp.next.val = k;
            temp = temp.next.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1_1 = new ListNode(3);
        ListNode l1_2 = new ListNode(4,l1_1);
        ListNode l1 = new ListNode(2,l1_2);

        System.out.println("Before:: "+l1);
        System.out.println("After:: "+swapPairs(l1));
    }
}
