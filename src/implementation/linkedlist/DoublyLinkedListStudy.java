package implementation.linkedlist;

public class DoublyLinkedListStudy<E> {
    private ListNode<E> first;
    private ListNode<E> last;
    private int size;

    public void addFirst(E e) {
        ListNode<E> newNode = new ListNode<>(e);
        newNode.next = first;
        if (first == null) {
            this.last = newNode;
        } else {
            first.prev = newNode;
        }
        first = newNode;
        size++;
    }

    public void addLast(E e) {
        ListNode<E> newNode = new ListNode<>(e);
        newNode.prev = last;
        if (last == null) {
            this.first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public void add(E e) {
        addLast(e);
    }

    public E removeFirst() {
        var next = this.first.next;
        var item = this.first.item;
        // help garbage collector
        this.first.item = null;
        this.first.next = null;
        this.first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;
        return item;
    }

    public void removeLast() {

    }

    public void remove() {
        removeFirst();
    }

    public E get(int index) {
        // bit shift -> equal to size / 2
        if (index < (size >> 1)) {
            var curr = this.first;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            return curr.item;
        } else {
            var curr = this.last;
            for (int i = size - 1; i > index; i--) {
                curr = curr.prev;
            }
            return curr.item;
        }
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        var actual = this.first;
        if (actual == null) {
            return "[]";
        }
        for (int i = 0; i < size; i++) {
            assert actual != null;
            sb.append("[ index: ").append(i).append(" value: ").append(actual.item).append(" ]");
            actual = actual.next;
            if (actual != null) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }


    private static class ListNode<E> {
        E item;
        ListNode<E> next;
        ListNode<E> prev;

        public ListNode(E item) {
            this.item = item;
        }
    }


}
