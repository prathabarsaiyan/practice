package main;

public class SumOfLinkedList {

    static ListNode res = null;
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        addLinkList(l1,l2,0);
        System.out.println(l1+"+ "+l2+" = "+res);
        return res;
    }

    public static int addLinkList(ListNode l1, ListNode l2, int carry){

        if(l1.next != null && l2.next != null){
            carry = addLinkList(l1.next, l2.next, carry);
        }else if(l1.next != null){
            carry = addLinkList(l1.next, l2, carry);
        }else if(l2.next != null){
            carry = addLinkList(l1, l2.next, carry);
        }

        int result = l1.val + l2.val + carry;

        carry = result/10;
        if (res == null)
        {
            res = new ListNode(result%10);
        } else {
            res = new ListNode(result%10,res);
        }

        return carry;
    }

    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass()
    {
        boolean result = true;
        ListNode l1_1 = new ListNode(3);
        ListNode l1_2 = new ListNode(4,l1_1);
        ListNode l1 = new ListNode(2,l1_2);

        ListNode l2_1 = new ListNode(4);
        ListNode l2_2 = new ListNode(6,l2_1);
        ListNode l2 = new ListNode(5,l2_2);

        // Base test case
        result &= addTwoNumbers(l1,l2).toString().equals("708");
        return result;
    }

    public static void main(String[] args) {
        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("Tests fail.");
        }
    }
}
