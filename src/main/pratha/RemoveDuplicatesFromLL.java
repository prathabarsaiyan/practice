package main.pratha;

// Remove duplicate values from a linked list
//
// Implement the function removeDuplicates so that it returns the head to a linked
// list with the duplicate values removed.
//
// example: { 5, 6, 1, 5, 1 } -> { 5, 6, 1 }

import java.util.HashSet;

public class RemoveDuplicatesFromLL {
    public static void main(String[] args) {
        LinkedListNode head = createLinkedListFromArray(new int[]{0, 1, 2, 3, 3, 4, 0, 1, 0, 10, 10, 3});
        System.out.println(head);
        head = removeDuplicates(head);
        System.out.println(head);


        LinkedListNode head1 = createLinkedListFromArray(new int[]{0, 1, 2, 3, 3, 4, 0, 1, 0, 10, 10, 3});
        System.out.println(head1);
        head = removeDuplicatesWithoutSpace(head1);
        System.out.println(head1);
    }

    private static LinkedListNode removeDuplicates(LinkedListNode node) {
        if(node == null){
            return node;
        }
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode head = node;
        while(node.next != null){
            set.add(node.data);
            if(set.contains(node.next.data)){
                node.next = node.next.next;
            }
            node = node.next;
        }
        return head;
    }


    private static LinkedListNode removeDuplicatesWithoutSpace(LinkedListNode node) {
        if(node == null){
            return node;
        }

        LinkedListNode temp = node;
        while(temp.next != null){
            LinkedListNode curr = temp;
            while(curr.next != null){
                if(temp.data == curr.next.data){
                    curr.next = curr.next.next;
                }
                curr = curr.next;
            }
            temp = temp.next;
        }

        return node;

    }


    public static class LinkedListNode {
        public LinkedListNode next;
        public int data;

        public LinkedListNode(int data, LinkedListNode next) {
            this.next = next;
            this.data = data;
        }

        public LinkedListNode(int data) {
            this.data = data;
        }

        public void setNext(LinkedListNode n) {
            next = n;
        }

        @Override
        public String toString() {
            return "" + data + (next != null ? " " + next.toString() : "");
        }
    }

    public static LinkedListNode createLinkedListFromArray(int[] values) {
        LinkedListNode head = new LinkedListNode(values[0]);
        LinkedListNode prev = head;
        LinkedListNode current = null;
        for (int i = 1; i < values.length; i++) {
            current = new LinkedListNode(values[i], null);
            prev.setNext(current);
            prev = current;
        }
        return head;
    }
}