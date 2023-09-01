public class QueueArray{
    private int [] values;
    private int head;
    private int tail;
    private int size;

    public QueueArray(int capacity){
        this.values = new int [capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public void enqueue(Integer value){
        if(size == values.length){
            throw new IllegalStateException("Queue is Full"); 
        }
        this.values[this.tail] = value;
        this.tail = (tail + 1) % values.length;
        this.size++;
    }

    public Integer dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is Empty");
        }
            int dequeuedValue = values[head];
            this.head = (head + 1) % values.length;
            this.size--;

            return dequeuedValue;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == values.length;
    }



}