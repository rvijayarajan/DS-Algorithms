public class Queue {
	public static void main(String[] args) {
        	Node node;
        	QueueAsLinkedList queue = new QueueAsLinkedList();
        	queue.enqueue(10); 
                queue.enqueue(20); 
                queue.dequeue(); 
                queue.dequeue(); 
                queue.enqueue(30); 
                queue.enqueue(40); 
                queue.enqueue(50); 
                queue.enqueue(60);
                queue.dequeue(); 

                System.out.println("-------------------------------------");
                node = queue.front;
                while(node != null) {
                        System.out.println(node.data);
                        node = node.next;
                }
                System.out.println("-------------------------------------");

                System.out.println("Queue Front : " + queue.front.data); 
                System.out.println("Queue Rear : " + queue.rear.data);

		
                System.out.println("-------------------------------------");
                node = queue.front;
                while(node != null) {
                        System.out.println(node.data);
                        node = node.next;
                }
		System.out.println("-------------------------------------");
	}
}