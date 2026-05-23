package org.review.seven;

public class ReverseLinkedListK {
    static class Node{
        int value;
        Node next;
        Node(int value){
            this.value=value;
            this.next=null;
        }
    }
    public static void main(String[] args){
        Node head = new Node(1);
        head.next=new Node(2);
        head.next.next= new Node(3);
        head.next.next.next= new Node(4);
        head.next.next.next.next= new Node(5);

        int k=2;
        Node result = reverseKGroup(head, k);
        while(result!=null){
            System.out.print(result.value+" ");
            result=result.next;
        }
    }
    public static Node reverseKGroup(Node head,int k){
            if(head==null || head.next==null || k<=1) return head;
            Node dummy = new Node(0);
            dummy.next=head;
            Node prev=dummy, curr=head, next=null;
            int count=0;
            while(curr!=null){
                count++;
                curr=curr.next;
            }
            while(count>=k){
                curr=prev.next;
                next=curr.next;
                for(int i=1; i<k; i++){
                    curr.next=next.next;
                    next.next=prev.next;
                    prev.next=next;
                    next=curr.next;
                }
                prev=curr;
                count-=k;
            }
            return dummy.next;

    }

}
