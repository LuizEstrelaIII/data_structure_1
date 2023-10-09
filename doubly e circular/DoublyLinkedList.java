public class DoublyLinkedList {
    private DoublyListNode head;
    private DoublyListNode tail;
    private int size;
    
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return head == null && tail == null;
    }

    public int size(){
        return this.size;
    }

    public void addFirst(Integer value){
        DoublyListNode newHead = new DoublyListNode(value, null, this.head);
        
        if(isEmpty()){
            this.tail = newHead;    
        }else{
            this.head.setPrevious(newHead);
        }

        this.head = newHead;
        size++;
    }

    public DoublyListNode search(Integer value) {
        DoublyListNode current = head;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void addLast(Integer value) {
        DoublyListNode newTail = new DoublyListNode(value, this.tail, null);

        if(isEmpty()){
            this.head = newTail;
        }else{
            this.tail.setNext(newTail);
        }

        this.tail = newTail;
        size++;
    }

    public void reverse() {
        DoublyListNode temp = null;
        DoublyListNode current = head;
    
        while (current != null) {
            temp = current.getPrevious();
            current.setPrevious(current.getNext());
            current.setNext(temp);
            current = current.getPrevious();
        }
    
        temp = head;
        head = tail;
        tail = temp;
    }

    public void delete(DoublyListNode node) {
        if (node == null) {
            return;
        }
        
        if (node.equals(head)) {
            head = node.getNext();
        }
        if (node.equals(tail) ) {
            tail = node.getPrevious();
        }
    
        if (node.getPrevious() != null) {
            node.getPrevious().setNext(node.getNext());
        }
    
        size--;
    }
    public boolean isOrdered(boolean ascending) {
        DoublyListNode currentNode = this.head;
        
        if(currentNode == null){
            return true;
        }

        while(currentNode.getNext() != null){
            if(ascending){
                if(currentNode.getValue() > currentNode.getNext().getValue()){
                    return false;
                }
            }else{
                if(currentNode.getValue() < currentNode.getNext().getValue()){
                    return false;
                }
            }

            currentNode = currentNode.getNext();
        }

        return true;
    }

    public Integer[] toArray() {
        Integer[] arrayToReturn = new Integer[this.size()];
        DoublyListNode currentNode = this.head;
        int count = 0;


        while(currentNode != null){
            arrayToReturn[count] = currentNode.getValue();
            currentNode = currentNode.getNext();
            count++;
        }
        
        return arrayToReturn;
    }

    public DoublyListNode getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public DoublyListNode getTail() {
        return tail;
    }
    
}
