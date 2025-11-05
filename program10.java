public class program10 {
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public static Node mergeSortedLists(Node list1, Node list2) {
        // base cases
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        // recursively merge
        if (list1.data <= list2.data) {
            list1.next = mergeSortedLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeSortedLists(list1, list2.next);
            return list2;
        }
    }
    
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // Create first sorted list: 1->3->5->7
        Node list1 = new Node(1);
        list1.next = new Node(3);
        list1.next.next = new Node(5);
        list1.next.next.next = new Node(7);
        
        // Create second sorted list: 2->4->6->8
        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(6);
        list2.next.next.next = new Node(8);
        
        System.out.print("First List:  ");
        printList(list1);
        System.out.print("Second List: ");
        printList(list2);
        
        Node mergedList = mergeSortedLists(list1, list2);
        
        System.out.print("Merged List: ");
        printList(mergedList);
    }
}
