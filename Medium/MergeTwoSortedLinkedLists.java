// Definition for a linked list node
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    // Function to merge two sorted linked lists
    Node sortedMerge(Node head1, Node head2) {
        // If one of the lists is empty, return the other list
        if (head2 == null) {
            return head1;
        } else if (head1 == null) {
            return head2;
        }

        // Initialize the result list
        Node result;

        // Determine the first node of the merged list
        if (head1.data < head2.data) {
            result = head1;
            head1 = head1.next;
        } else {
            result = head2;
            head2 = head2.next;
        }

        // Pointer to traverse the merged list
        Node curr = result;

        // Merge the lists by comparing nodes
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next; // Move to the next node in the merged list
        }

        // Append the remaining nodes from either list
        if (head1 != null) {
            curr.next = head1;
        } else {
            curr.next = head2;
        }

        return result; // Return result
    }
}

// Helper class to test the merge function
public class MergeTwoSortedLinkedLists {
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
        // Create the first sorted linked list: 1 -> 3 -> 5 -> null
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);

        // Create the second sorted linked list: 2 -> 4 -> 6 -> null
        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);

        System.out.println("First Sorted Linked List:");
        printList(head1);

        System.out.println("Second Sorted Linked List:");
        printList(head2);

        // Merge the two sorted linked lists
        Solution solution = new Solution();
        Node mergedHead = solution.sortedMerge(head1, head2);

        System.out.println("Merged Sorted Linked List:");
        printList(mergedHead);
    }
}
