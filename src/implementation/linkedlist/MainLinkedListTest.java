package implementation.linkedlist;

public class MainLinkedListTest {

    public static void main(String[] args) {

        DoublyLinkedListStudy<Integer> doublyLinkedListStudy = new DoublyLinkedListStudy<>();
        doublyLinkedListStudy.addLast(2);
        doublyLinkedListStudy.addFirst(1);
        doublyLinkedListStudy.add(3);

        // 1, 2, 3 sequence
        System.out.println(doublyLinkedListStudy.get(1)); // 2
        System.out.println(doublyLinkedListStudy.getFirst()); // 1
        System.out.println(doublyLinkedListStudy.getLast()); // 3
        System.out.println(doublyLinkedListStudy);

        doublyLinkedListStudy.remove();
        doublyLinkedListStudy.removeFirst();
        doublyLinkedListStudy.removeLast();
        
        // should be empty
        System.out.println(doublyLinkedListStudy);

    }

}

