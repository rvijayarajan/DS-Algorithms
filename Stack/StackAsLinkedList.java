public class StackAsLinkedList { 
    Node head;
    int min;

    public boolean isEmpty() {
        return this.head == null;
    } 

    public void push(int data) {
        if(this.head == null) {
            this.min = data;
            this.head = new Node(data);
            return;
        }
        if(data < this.min) {
            int tempMin = this.min;
            this.min = data;
            data = (2*data) - tempMin;
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
        if(this.head.data < this.min) {
            int tempData = this.min;
            this.min = (2*min) - this.head.data;
            this.head.data = tempData;
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

    public int min() {
        if(!this.isEmpty()) {
            return this.min;
        }
        return -9999;
    }
}