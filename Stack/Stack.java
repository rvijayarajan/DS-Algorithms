public class Stack {
	public static void main(String[] args) {
        	Node node;
        	StackAsLinkedList stack = new StackAsLinkedList();
        	stack.push(10); 
                stack.push(20); 
                stack.push(30); 

                System.out.println("-------------------------------------");
                node = stack.head;
                while(node != null) {
                        System.out.println(node.data);
                        node = node.next;
                }
                System.out.println("-------------------------------------");
                System.out.println("Minimum Element "+stack.min()); 
                System.out.println(stack.pop() + " popped from stack"); 
  
                System.out.println("Top element is " + stack.peek());

		
                System.out.println("-------------------------------------");
                node = stack.head;
		while(node != null) {
			System.out.println(node.data);
			node = node.next;
		}
		System.out.println("-------------------------------------");
                System.out.println("Minimum Element "+stack.min()); 
	}
}