public class LinkList {
	public static void main(String[] args) {
		Node node;
		LinkedList list = new LinkedList();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		list.head = n1;
		n1.next = n2;
		n2.next = n3;

		// Insert 6.  So linked list becomes 6->NUllist 
        list.insertAtTail(6); 
  
        // Insert 7 at the beginning. So linked list becomes 
        // 7->6->NUllist 
        list.insertAtHead(7); 
  
        // Insert 1 at the beginning. So linked list becomes 
        // 1->7->6->NUllist 
        list.insertAtHead(1); 
  
        // Insert 4 at the end. So linked list becomes 
        // 1->7->6->4->NUllist 
        list.insertAtTail(4); 
  
        // Insert 8, after 7. So linked list becomes 
        // 1->7->8->6->4->NUllist 
        list.insertAfter(list.head.next, 8);

        list.deleteNode(8);
        list.deleteNodeByPosition(4);
        // list.swapNodes(6,7);
        // list.swapNodes(2,4);
        // list.swapNodes(2,8);
        // list.deleteNodeByPosition(2);
        // list.swapNodes(4,7);
        // list.swapNodes(1,6);
        // list.swapNodes(7,6);

        list.reverse();
        list.reverseGroup(3);
        list.sort();

		node = list.head;
		while(node != null) {
			System.out.println(node.data);
			node = node.next;
		}	
		System.out.println("-------------------------------------");
		DoubleLinkedList dlist = new DoubleLinkedList();
		Node d1 = new Node(1);
		Node d2 = new Node(2);
		Node d3 = new Node(3);
		dlist.head = d1;
		d1.next = d2;
		d2.previous = d1;
		d2.next = d3;
		d3.previous = d2;

		// Insert 6.  So linked list becomes 6->NUllist 
        dlist.insertAtTail(6); 
  
        // Insert 7 at the beginning. So linked list becomes 
        // 7->6->NUllist 
        dlist.insertAtHead(7); 
  
        // Insert 1 at the beginning. So linked list becomes 
        // 1->7->6->NUllist 
        dlist.insertAtHead(1); 
  
        // Insert 4 at the end. So linked list becomes 
        // 1->7->6->4->NUllist 
        dlist.insertAtTail(4); 
  
        // Insert 8, after 7. So linked list becomes 
        // 1->7->8->6->4->NUllist 
        dlist.insertAfter(dlist.head.next, 8);
        
        dlist.deleteNode(8);
        dlist.deleteNodeByPosition(4);

        dlist.reverse();
        dlist.reverseGroup(3);
        dlist.sort();

        node = dlist.head;
        Node node2 = null;
		while(node != null) {
			System.out.println(node.data);
			node2=node;
			node = node.next;
		}
		System.out.println("-------------------------------------");
		while(node2 != null) {
			System.out.println(node2.data);
			node2 = node2.previous;
		}
	}
}