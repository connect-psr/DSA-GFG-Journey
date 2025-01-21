// Definition for a linked list node
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SolutionX {
    public static Node reverseKGroup(Node head, int k) {
        if (head == null) {
            return head; // If the list is empty, return null
        }

        Node current = head;  // Pointer to traverse the list
        Node newHead = null;  // New head of the reversed list
        Node previousGroupTail = null;  // Tail of the previous group

        while (current != null) {
            Node groupHead = current;  // Start of the current group
            Node previous = null;
            Node nextNode = null;
            int count = 0;

            // Reverse the current group of size k
            while (current != null && count < k) {
                nextNode = current.next;
                current.next = previous;
                previous = current;
                current = nextNode;
                count++;
            }

            // Update the new head after reversing the first group
            if (newHead == null) {
                newHead = previous;
            }

            // Connect the tail of the previous group to the head of the current group
            if (previousGroupTail != null) {
                previousGroupTail.next = previous;
            }

            // Update the tail of the current group
            previousGroupTail = groupHead;
        }

        return newHead; // Return the head of the reversed list
    }
}

public class LinkedListGroupReverse {
    // Helper method to print the linked list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Helper method to create a linked list from an array
    static Node createList(int[] arr) {
        Node head = null, tail = null;
        for (int value : arr) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;

        // Create a linked list from the array
        Node head = createList(arr);

        System.out.println("Original Linked List:");
        printList(head);

        // Reverse the list in groups of k
        Node reversedHead = SolutionX.reverseKGroup(head, k);

        System.out.println("Linked List After Group Reversal:");
        printList(reversedHead);
    }
}
