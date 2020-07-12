public class QueueAsLinkedList { 
    Node front;
    Node rear;

    public void enqueue(int data) {
        if(this.rear == null) {
            this.rear = this.front = new Node(data);
            return;
        }
        Node node = new Node(data);
        Node temp = this.rear;
        this.rear = node;
        temp.next = this.rear;
    }

    public void dequeue() {
        if(this.front == null) {
            return;
        } 
        Node temp = this.front;
        this.front = this.front.next;
        temp = null;
        if(this.front == null) {
            this.rear = null;
        }
    }
}