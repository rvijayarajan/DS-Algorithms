public class StackObject<T> { 
    NodeObj<T> head;

    public boolean isEmpty() {
        return this.head == null;
    } 

    public void push(T data) {
        if(this.head == null) {
            this.head = new NodeObj<T>(data);
            return;
        }
        NodeObj node = new NodeObj<T>(data);
        NodeObj temp = this.head;
        this.head = node;
        node.next = temp;
    }

    public T pop() {
        if(head == null) {
            return null;
        } 
        NodeObj<T> temp = this.head;
        this.head = this.head.next;
        return temp.data;
    } 

    public T peek() {
        if(head == null) {
            return null;
        }
        return this.head.data;
    }

    public void sort() {
        T temp = this.pop();
        if(temp!=null && !this.isEmpty()) {
            this.sort();
        }
        if(temp!=null) {
            this.ascendingSort(temp);
        }
    }

    public void reverse() {
        T temp = this.pop();
        if(temp!=null && !this.isEmpty()) {
            this.reverse();
        }
        if(temp!=null) {
            this.insertAtBottom(temp);
        }
    }

    private void ascendingSort(T data) {
        if(this.isEmpty()) {
            this.push(data);
            return;
        }
        if(!this.isEmpty()) {
            T tempData = this.peek();
            int recent = Integer.parseInt((String)tempData);
            int actual = Integer.parseInt((String)data);
            if(recent > actual) {
                this.pop();
                this.ascendingSort(data);
                this.push(tempData);
            } else {
                this.push(data);    
            }
        }
    }

    private void insertAtBottom(T data) {
        if(this.isEmpty()) {
            this.push(data);
            return;
        }
        if(!this.isEmpty()) {
            T temp = this.pop();
            this.insertAtBottom(data);
            this.push(temp);
        }
    }
}