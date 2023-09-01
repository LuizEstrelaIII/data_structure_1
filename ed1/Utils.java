public class Utils {
    public static void reverse(QueueArray queueToBeReversed, StackArray stackAuxiliary){

        while(queueToBeReversed.isEmpty() == false){
            stackAuxiliary.push(queueToBeReversed.dequeue());
        }
        while(stackAuxiliary.isEmpty() == false){
            queueToBeReversed.enqueue(stackAuxiliary.pop());
        }
    }
}
