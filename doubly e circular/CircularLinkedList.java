

public class CircularLinkedList<T> {
    private CircularListNode<T> sentinel;
    private int size;

    public CircularLinkedList() {
        this.sentinel = new CircularListNode<T>(null, null, null);
        this.sentinel.setNext(sentinel);
        this.sentinel.setPrevious(sentinel);
        this.size = 0;
    }

    public boolean isEmpty() {
        return sentinel.getNext().equals(sentinel) && sentinel.getPrevious().equals(sentinel);
    }

    public void addFirst(T value) {
        CircularListNode<T> newNode = new CircularListNode<T>(value, this.sentinel, this.sentinel.getNext());

        if (isEmpty()) {
            this.sentinel.setPrevious(newNode);
        }else{
            this.sentinel.getNext().setPrevious(newNode);
        }

        this.sentinel.setNext(newNode);
        this.size++;
    }

    public void addLast(T value) {
        CircularListNode<T> newNode = new CircularListNode<T>(value, this.sentinel.getPrevious(), this.sentinel);

        if (isEmpty()) {
            this.sentinel.setNext(newNode);
        }else{
            this.sentinel.getPrevious().setNext(newNode);
        }

        this.sentinel.setPrevious(newNode);
        this.size++;
    }

    public int size() {
        return size;
    }

    public CircularListNode<T> search(int value){
        CircularListNode<T> currentNode = this.sentinel.getNext();

        while(!currentNode.equals(this.sentinel)){
            if(currentNode.getValue().equals(value)){
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }

        return null;
    }

    public void reverse() {
        CircularListNode<T> temp = null;
        CircularListNode<T> current = this.sentinel.getNext();
    
        while (!current.equals(sentinel)) {
            temp = current.getPrevious();
            current.setPrevious(current.getNext());
            current.setNext(temp);
            current = current.getPrevious();
        }
    
        temp = this.sentinel.getNext();
        this.sentinel.setNext(this.sentinel.getPrevious());
        this.sentinel.setPrevious(temp);
    }


    public void delete(CircularListNode<T> node) {
        if (node == null) {
            return;
        }
        
        if (node.equals(this.sentinel.getNext())) {
            this.sentinel.setNext(node.getNext());
        }
        if (node.equals(this.sentinel.getPrevious()) ) {
            this.sentinel.setPrevious(node.getPrevious());
        }
    
        if (!node.getPrevious().equals(sentinel)) {
            node.getPrevious().setNext(node.getNext());
        }
        if (!node.getNext().equals(sentinel)) {
            node.getNext().setPrevious(node.getPrevious());
        }
    
        size--;
    }

    public CircularLinkedList<T> copy(){
        CircularLinkedList<T> returnCircularLinkedList = new CircularLinkedList<>();
        CircularListNode<T> currentNode = this.sentinel.getNext();
        while(!currentNode.equals(sentinel)){
            returnCircularLinkedList.addLast(currentNode.getValue());
            currentNode = currentNode.getNext();
        }

        return returnCircularLinkedList;
    }

    public boolean isEquals(CircularLinkedList<T> otherList){
        CircularListNode<T> thisCurrentNode = this.sentinel.getNext();
        CircularListNode<T> otherListCurrentNode = otherList.getSentinel().getNext();

        while (!thisCurrentNode.equals(this.sentinel) && !otherListCurrentNode.equals(otherList.getSentinel())) {
            if(thisCurrentNode.getValue() != otherListCurrentNode.getValue()){
                return false;
            }

            thisCurrentNode = thisCurrentNode.getNext();
            otherListCurrentNode = otherListCurrentNode.getNext();
        }

        if(thisCurrentNode.equals(this.sentinel) && otherListCurrentNode.equals(otherList.getSentinel())){
            return true;
        }

        return false;
    }

    public T get(int index) throws Exception{
        if(isEmpty()){
            throw new Exception("List is empty");
        }

        int count = 0;
        CircularListNode<T> currentNode = this.sentinel.getNext();

        while(count < index){
            currentNode = currentNode.getNext();

            if(currentNode.equals(this.sentinel)){
                currentNode = currentNode.getNext();
            }

            count++;
        }

        return currentNode.getValue();
    }

    public CircularListNode<T> getSentinel() {
        return sentinel;
    }

    public CircularListNode<T> getTail(){
        return this.sentinel.getPrevious();
    }

    public CircularListNode<T> getHead(){
        return this.sentinel.getNext();
    }

    public CircularListNode<T> getSuccessor(CircularListNode<T> anyNode) throws Exception {

        if(isEmpty()){
            throw new Exception("Circular list is empty");
        }

        anyNode = anyNode.getNext();

        if(anyNode.equals(sentinel)){
            anyNode = anyNode.getNext();
        }

        return anyNode;
    }

    public CircularListNode<T> get(CircularListNode<T> start, int index){
        int count = 1;

        try {
            while(count < index){
                start = getSuccessor(start);
                count++;
            }
        } catch (Exception e) {
            
        }

        return start;
    }
}
