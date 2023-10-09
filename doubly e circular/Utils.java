public class Utils {

    public static boolean isPalindrome(DoublyLinkedList list) {

        Integer[] listArray = list.toArray();
        list.reverse();
        Integer[] listReversedArray = list.toArray();

        for (int i = 0; i < listReversedArray.length; i++) {
            if(!listArray[i].equals(listReversedArray[i])){
                return false;
            }   
        }
        
        return true;
    }

}
