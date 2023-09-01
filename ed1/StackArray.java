public class StackArray {
    private int capacity;
    private int[] values;
    private int top;

    public StackArray(int capacity){
        this.capacity = capacity;
        this.values = new int[capacity];
        this.top = 0;
     }
     public boolean isEmpty(){
        return this.top == 0;
     }

     public void push(int value) throws IllegalStateException {

        if(top == capacity){
            throw new IllegalStateException("Stack is full");
        }
        
        this.values[this.top] = value;
        this.top++;
        
     }

     public Integer pop() throws IllegalStateException{ 
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        this.top--;
        Integer value = this.values[this.top];
        return value;
    }
    public int peek() {
        return 0;   // utilizou no StackSequences
    }
}
