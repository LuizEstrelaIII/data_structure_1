public class Utils {
    public static SinglyLinkedList sum(SinglyLinkedList listAddendOne, SinglyLinkedList listAddendTwo) {
        SinglyLinkedList sumList = new SinglyLinkedList();
        SinglyListNode currentOne = listAddendOne.getHead();
        SinglyListNode currentTwo = listAddendTwo.getHead();
        int carry = 0;
        while (currentOne != null || currentTwo != null) {
            int digitOne = (currentOne != null) ? currentOne.getValue() : 0;
            int digitTwo = (currentTwo != null) ? currentTwo.getValue() : 0;
            int digitSum = digitOne + digitTwo + carry;
            carry = digitSum / 10;
            digitSum %= 10;
            sumList.addLast(digitSum);
            if (currentOne != null) {
                currentOne = currentOne.getNext();
            }
            if (currentTwo != null) {
                currentTwo = currentTwo.getNext();
            }
        }
        if (carry > 0) {
            sumList.addLast(carry);
        }
        return sumList;
    }
}
