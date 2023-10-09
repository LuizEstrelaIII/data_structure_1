
public class CircularListNode<T> {
    private T value;
    private CircularListNode<T> prev;
    private CircularListNode<T> next;
    
    public CircularListNode(T value, CircularListNode<T> previous, CircularListNode<T> next) {
        this.value = value;
        this.prev = previous;
        this.next = next;
    }
        
    public void setValue(T value) {
        this.value = value;
    }
    
    public CircularListNode<T> getNext() {
        return next;
    }
    
    public void setNext(CircularListNode<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public CircularListNode<T> getPrevious(){
        return prev;
    }

    public void setPrevious(CircularListNode<T> prev) {
        this.prev = prev;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        if(obj instanceof CircularListNode<?>){
            CircularListNode<?> anotherObj = (CircularListNode<?>) obj;
            return this.value.equals(anotherObj.value);
        }

        return false;
    }
}
