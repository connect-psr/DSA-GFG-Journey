/* Node of a linked list
 class Node{
   int data;
   Node next;
   Node(int d){
        data = d;  next = null;
   }
}
*/

class Solution{
    int getMiddle(Node head){
        
        Node slow = head; // Slow pointer moves one step at a time
        Node fast = head; // Fast pointer moves two steps at a time
        
        while(fast != null && fast.next != null){
            slow = slow.next;      
            fast = fast.next.next;  
        }
        
        return slow.data; // Slow pointer at the middle
    }
}

public class MiddleOfaLinkedList{
    public static void main(String[] args){
        // Test the solution
    }
}