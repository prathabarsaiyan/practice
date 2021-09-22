package main;

public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next== null){
            return null;
        }

        ListNode temp1 = head;

        int count = 1;

        while(temp1.next!= null){
            temp1 = temp1.next;
            count++;
        }

        int i = count-n;
        if(i < 1){
            head = head.next;
            return head;
        }

        temp1 = head;

        while(i > 1){
            temp1 = temp1.next;
            i--;
        }

        if(temp1.next != null){
            temp1.next = temp1.next.next;
       }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1_1 = new ListNode(2);
        ListNode l1_2 = new ListNode(1,l1_1);
//        ListNode l1_3 = new ListNode(5,l1_2);
//        ListNode l1 = new ListNode(2,l1_3);

        System.out.println("Before:: "+l1_2);
        System.out.println("After:: "+removeNthFromEnd(l1_2,2));
    }
}
