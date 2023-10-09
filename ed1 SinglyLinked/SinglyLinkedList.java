import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedList {
      public SinglyListNode head;

    public boolean isEmpty() {
        return head == null;
    }
    
    public void addFirst(Integer value) {
        SinglyListNode newNode = new SinglyListNode(value);
        newNode.setNext(head);
        head = newNode;
    }
    
    public SinglyListNode search(Integer value) {
        SinglyListNode current = head;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
    
    public int size() {
        int count = 0;
        SinglyListNode current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }
    
    public boolean isOrdered(boolean ascending) {
        if (head == null) {
            return true;
        }
        SinglyListNode current = head;
        Integer prevValue = current.getValue();
        current = current.getNext();
        while (current != null) {
            if (ascending) {
                if (current.getValue() < prevValue) {
                    return false;
                }
            } else {
                if (current.getValue() > prevValue) {
                    return false;
                }
            }
            prevValue = current.getValue();
            current = current.getNext();
        }
        return true;
    }
    
    public void addLast(Integer value) {
        SinglyListNode newNode = new SinglyListNode(value);
        if (head == null) {
            head = newNode;
        } else {
            SinglyListNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }  
    
    public void reverse() {
        SinglyListNode prev = null;
        SinglyListNode current = head;
        SinglyListNode next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
    }  
    
    public void delete(SinglyListNode node) {
        if (node == null || head == null) {
            return;
        }
        if (head == node) {
            head = head.getNext();
            return;
        }
        SinglyListNode current = head;
        while (current != null && current.getNext() != node) {
            current = current.getNext();
        }
        if (current != null) {
            current.setNext(node.getNext());
        }
    }
    
    public SinglyListNode getHead() {
        return head;
    }

    public Integer[] toArray() {
        List<Integer> list = new ArrayList<>();
        SinglyListNode current = head;
        while (current != null) {
            list.add(current.getValue());
            current = current.getNext();
        }
        return list.toArray(new Integer[0]);
    }
}
