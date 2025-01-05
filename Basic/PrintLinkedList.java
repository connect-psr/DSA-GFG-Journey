class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

class Solution{
    void display(Node head){
        while(head != null){
            System.out.print(head.data+" "); // Print current node's data
            head = head.next; // Move to the next node
        }
    }
}

public class PrintLinkedList{
    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        
        new Solution().display(head); // Output: 1 2 3
    }
}

