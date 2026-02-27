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

        public MyNode() {
        }

        public MyNode(T val) {
            this.val = val;
        }
    }

    public class MyLinkedListImpl<T> implements MyLinkedList<T> {
        MyNode<T> head;
        MyNode<T> tail;
        int size;

        public MyLinkedListImpl(T val) {
            this.head = new MyNode<>(val);
            this.size = 1;
        }

        @Override
        public void add(T val) {
            MyNode<T> newNode = new MyNode<>(val);
            if (tail == null) {
                tail = newNode;
                head.next = tail;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
            size++;
        }

        @Override
        public T get(int index) {
            return getNode(index).val;
        }

        @Override
        public boolean contains(T val) {
            var result = head;
            while (result != null && result.next != null) {
                if (result.val.equals(val)) return true;
                result = result.next;
            }
            return false;
        }

        @Override
        public void remove(int index) {
            size--;
            var idx = Math.min(index, size) - 1;
            var node = getNode(idx);
            if (node != null && node.next != null) {
                node.next = node.next.next;
            } else {
                node.next = null;
            }
        }

        @Override
        public void removeLast() {
            remove(size - 1);
        }

        @Override
        public int size() {
            return size;
        }

        private MyNode<T> getNode(int index) {
            if (head == null) return null;
            var result = head;
            int i = 0;
            while (i < index && result.next != null) {
                result = result.next;
                i++;
            }
            return result;
        }
    }

    void main() {
        MyLinkedListImpl<Integer> linked = new MyLinkedListImpl<>(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.add(5);
        IO.println(linked.get(10)); // return 5
        IO.println(linked.contains(6)); // return false
        IO.println(linked.contains(4)); // return true

        linked.remove(1); // remove value 2
        IO.println(linked.get(1)); //should return 3
        IO.println(linked.get(2)); //should return 4

        linked.remove(10);
        IO.println(linked.get(10)); //should return 4

        IO.println(linked.size()); // should return 3
    }

}
