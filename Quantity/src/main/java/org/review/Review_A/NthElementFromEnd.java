package org.review.Review_A;

import java.util.*;
class node{
    char v;
    node next;
    node(char v){
        this.v=v;
        next=null;
    }
}
public class NthElementFromEnd {
    public static void main(String[] args){
        LinkedList<Character> list = new LinkedList<>();
        node head = new node('A');
        head.next = new node('B');
        head.next.next = new node('C');
        head.next.next.next = new node('D');
        head.next.next.next.next = new node('E');

        int n = 2;
        node fast = head;
        node slow = head;

        for (int i = 0; i < n; i++) {
            if (fast == null) {
                System.out.println("Invalid n");
                return;
            }
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        System.out.println("Nth element from end: " + slow.v);

    }
}
