// Definition for a linked list node
class Node {
    int data;
    Node next;

    // Constructor to initialize the node
    Node(int value) {
        this.data = value;
        this.next = null;
    }
}

class Solution {
    // Function to reverse the linked list
    Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head; // Return the head as is if the list has 0 or 1 node
        }

        Node curr = head; // Pointer to the current node
        Node prev = null; // Pointer to the previous node

        // Traverse and reverse the list
        while (curr != null) {
            Node nextNode = curr.next; // Store the next node
            curr.next = prev;         // Reverse the current node's pointer
            prev = curr;              // Move prev to the current node
            curr = nextNode;          // Move curr to the next node
        }

        return prev; // New head of the reversed list
    }
}

public class ReverseALinkedList{
    // Utility function to print a linked list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Driver code
    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        printList(head);

        Solution solution = new Solution();
        Node reversedHead = solution.reverseList(head);

        System.out.println("Reversed Linked List:");
        printList(reversedHead);
    }
}
