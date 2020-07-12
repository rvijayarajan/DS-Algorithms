public class StackAsLinkedList { 
    Node head;

    public boolean isEmpty() {
        return this.head == null;
    } 

    public void push(int data) {
        if(this.head == null) {
            this.head = new Node(data);
            return;
        }
        Node node = new Node(data);
        Node temp = this.head;
        this.head = node;
        node.next = temp;
    }

    public int pop() {
        if(head == null) {
            return -9999;
        } 
        Node temp = this.head;
        this.head = this.head.next;
        return temp.data;
    } 

    public int peek() {
        if(head == null) {
            return -9999;
        }
        return this.head.data;
    }
}