public class StackSequences {
    public static boolean validate(int[] pushed, int[] popped) {
        StackArray transitionArray = new StackArray(pushed.length);
        int actualIndex = 0;

        for (int value : pushed) {
            transitionArray.push(value);

            while(!transitionArray.isEmpty() && actualIndex < pushed.length && transitionArray.peek() == popped[actualIndex]){
                transitionArray.pop();
                actualIndex++;
            }
        }

        return transitionArray.isEmpty();
    }

}