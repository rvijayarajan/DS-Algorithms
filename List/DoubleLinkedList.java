public class DoubleLinkedList { 
    Node head;

    public void insertAtHead(int data) {
        Node node = new Node(data);
        node.next = this.head;
        node.next.previous = node;
        node.previous = null;
        this.head = node;
    } 

    public void insertBefore(Node node, int data) {
        if(node == null) {
            return;
        }
        Node newNode = new Node(data);
        newNode.previous = node.previous;
        newNode.previous.next = newNode;
        newNode.next = node;
        newNode.next.previous = newNode;
    } 

    public void insertAfter(Node node, int data) {
        if(node == null) {
            return;
        }
        Node newNode = new Node(data);
        newNode.next = node.next;
        newNode.next.previous = newNode;
        newNode.previous = node;
        newNode.previous.next = newNode;
    } 

    public void insertAtTail(int data) {
        Node node = new Node(data);
        if(head == null) {
            this.head = node;
            return;
        } 
        Node lastNode = this.head;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = node;
        node.previous = lastNode;
    } 

    public void deleteNode(int data) {
        Node node = this.head;
        if(node == null) {
            return;
        }
        if(node.data == data) {
            this.head = node.next;
            this.head.previous = null;
            node = null;
            return;
        }
        while(node != null && node.data != data) {
            node = node.next;
        }
        if(node != null) {
            if(node.next != null) {
                node.previous.next = node.next;
                node.next.previous = node.previous;    
            } else {
                node.previous.next = null;
            }
            node = null;
        }
    }

    public void deleteNodeByPosition(int pos) {
        Node node = this.head;
        if(node == null) {
            return;
        }
        if(pos == 0) {
            this.head = node.next;
            this.head.previous = null;
            node = null;
            return;
        }
        int i=0;
        while(i < pos && node != null) {
            node = node.next;
            i++;
        }
        if(node != null) {
            if(node.next != null) {
                node.previous.next = node.next;
                node.next.previous = node.previous;    
            } else {
                node.previous.next = null;
            }
            node = null;
        }
    }

    public void reverse() {
        if(this.head == null || this.head.next == null) {
            return;
        }
        Node leftNode = this.head;
        while(leftNode.next != null) {
            Node newHead = leftNode.next;
            if(leftNode.next.next != null) {
                leftNode.next.next.previous = leftNode;
                leftNode.next = leftNode.next.next;
            } else {
                leftNode.next = null;
            }
            newHead.next = this.head;
            newHead.previous = null;
            newHead.next.previous = newHead;
            this.head = newHead;
        }
    }

    public void reverseGroup(int group) {
        Node start = null;
        do {
            start = this.reverse(start,group);
        } while(start != null);
    }

    public Node reverse(Node start, int group) {
        Node headNode = start == null ? this.head : start.next;
        Node leftNode = start == null ? this.head : start.next;
        int i = 1;
        while(i<group && leftNode!=null && leftNode.next!=null) {
            i++;
            Node newHead = leftNode.next;
            if(leftNode.next.next != null) {
                leftNode.next.next.previous = leftNode;
                leftNode.next = leftNode.next.next;
            } else {
                leftNode.next = null;
            }
            newHead.next = headNode;
            newHead.next.previous = newHead;
            headNode = newHead;
            
            if(start == null) {
                newHead.previous = null;
                this.head = headNode;
            } else {
                newHead.previous = start;
                start.next = headNode;
            }
        }
        return leftNode;
    }

    public void swapNodes(int k1, int k2) {
        Node prev = this.head;
        Node firstNode = null;
        Node firstNodeNext = null;
        // If keys are same
        if(k1 == k2) {
            return;
        }
        // If 0 or 1 node in total 
        if(prev == null || prev.next == null) {
            return;
        }
        // A check to find whether one of the key is in head
        if(prev.data == k1 || prev.data == k2) {
            firstNode = null;
            firstNodeNext = prev;
        }
        while(prev.next != null) {
            if(prev.next.data == k1 || prev.next.data == k2) {
                if(firstNode==null && firstNodeNext == null) {
                    firstNode = prev;
                    firstNodeNext = prev.next;
                } else {
                    if(firstNodeNext == prev) {
                        // Swapping adjacent nodes
                        Node secondNode = prev;
                        Node secondNodeNext = prev.next;
                        if(firstNode == null) {
                            firstNodeNext.next = secondNodeNext.next;
                            this.head = secondNodeNext;
                            secondNodeNext.next = firstNodeNext;
                        } else {
                            firstNode.next = secondNodeNext;
                            firstNodeNext.next = secondNodeNext.next;
                            firstNode.next.next = secondNode;    
                        }
                    } else {
                        // Non adjacent nodes
                        Node secondNode = prev.next;
                        Node secondNodeNext = prev.next.next;
                        if(firstNode == null) {
                            prev.next.next = firstNodeNext.next;
                            firstNodeNext.next = secondNodeNext;
                            prev.next = firstNodeNext;
                            this.head = secondNode;
                        } else {
                            prev.next.next = firstNodeNext.next;
                            firstNode.next.next = secondNodeNext;
                            prev.next = firstNodeNext;
                            firstNode.next = secondNode;        
                        }
                        
                    }
                    return;
                }
            }
            prev = prev.next;
        }
    }
}