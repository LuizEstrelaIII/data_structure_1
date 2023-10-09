public class DoublyListNode {
    private Integer value;
    private DoublyListNode previous;
    private DoublyListNode next;
    
    public DoublyListNode(DoublyListNode previous,int value, DoublyListNode next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }
     public DoublyListNode(int value,DoublyListNode next,DoublyListNode previous ) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public DoublyListNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyListNode previous) {
        this.previous = previous;
    }

    public DoublyListNode getNext() {
        return next;
    }

    public void setNext(DoublyListNode next) {
        this.next = next;
    }
    
}

