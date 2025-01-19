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

class SolutionX {
    // Function to rotate the linked list by k positions
    public Node rotate(Node head, int k) {
        if (head == null || k == 0) {
            return head; // Return the head as is if the list is empty or no rotation is needed
        }

        // Calculate the length of the linked list
        int len = 1;
        Node temp = head;

        while (temp.next != null) {
            len++;
            temp = temp.next;
        }

        // Connect the last node to the head, making it a circular list
        temp.next = head;

        // Calculate the effective number of rotations needed
        k = k % len;
        if (k == 0) {
            temp.next = null; // Break the circular list
            return head;      // Return the original head
        }

        // Traverse to the node before the new head
        Node temp2 = head;
        for (int i = 1; i < k; ++i) {
            temp2 = temp2.next;
        }

        // Update the head and break the circular link
        head = temp2.next;
        temp2.next = null;

        return head;
    }
}

// Helper class to test the rotate function
public class RotateALinkedList {
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

        int k = 2; // Rotate the list by k positions
        SolutionX solution = new SolutionX();
        Node rotatedHead = solution.rotate(head, k);

        System.out.println("Rotated Linked List:");
        printList(rotatedHead);
    }
}
