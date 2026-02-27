package interview;

public class MyLinkedListChallenge {

    public interface MyLinkedList<T> {
        void add(T val);
        T get(int index);
        boolean contains(T val);
        void remove(int index);
        void removeLast();
        int size();
    }

    public class MyNode<T> {
        T val;
        MyNode<T> next;

        MyNode(T val) {
            this.val = val;
        }
    }

    public class MyLinkedListImpl<T> implements MyLinkedList<T> {
        MyNode<T> head;
        MyNode<T> tail;
        int size;

        public MyLinkedListImpl() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        @Override
        public void add(T val) {
            var newNode = new MyNode<>(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        @Override
        public T get(int index) {
            validateIndex(index);
            return getNode(index).val;
        }

        @Override
        public boolean contains(T val) {
            var current = head;
            while (current != null) {
                if ((val == null && current.val == null) || (val != null && val.equals(current.val))) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        @Override
        public void remove(int index) {
            validateIndex(index);

            if (index == 0) {
                head = head.next;
                if (head == null) {
                    tail = null;
                }
            } else {
                var prev = getNode(index - 1);
                prev.next = prev.next.next;
                if (index == size - 1) {
                    tail = prev;
                }
            }
            size--;
        }

        @Override
        public void removeLast() {
            if (size == 0) {
                throw new IndexOutOfBoundsException("List is empty");
            }
            remove(size - 1);
        }

        @Override
        public int size() {
            return size;
        }

        private MyNode<T> getNode(int index) {
            var current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }

        private void validateIndex(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    void main() {
        MyLinkedListImpl<Integer> linked = new MyLinkedListImpl<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.add(5);
        IO.println(linked.get(0)); // return 1
        IO.println(linked.contains(6)); // return false
        IO.println(linked.contains(5)); // return true

        linked.remove(1); // remove value 2
        IO.println(linked.get(1)); //should return 3
        IO.println(linked.get(2)); //should return 4

        linked.remove(2);
        IO.println(linked.get(1)); //should return 3
        IO.println(linked.size()); // should return 3
    }
}
