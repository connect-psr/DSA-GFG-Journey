/* Node is defined as
class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
}
*/

/*
    Print elements of a linked list on console
    Head pointer input could be NULL as well for empty list
*/

class Solution {
    void display(Node head) {
        while(head != null){
            System.out.print(head.data+" "); // Print current node's data
            head = head.next; // Move to the next node
        }
    }
}

public class PrintLinkedList {
    public static void main(String[] args) {
        // Test the solution
    }
}
