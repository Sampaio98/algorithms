package implementation;

public class MainTest {

    public static void main(String[] args) {
        var start = System.currentTimeMillis();
        HashMapImpl<Integer, String> map = new HashMapImpl<>();

        map.put(1, "teste");
        map.put(2, "asdf");
        map.put(1, "fre23");
        map.put(4, "131f1");
        map.put(5, "fasdf");
        map.put(6, "asdfd");
        map.show();

        String valueRemoved = map.remove(5);
        System.out.println("Value removed: " + valueRemoved);
        map.show();

        var end = System.currentTimeMillis() - start;
        System.out.println("Took " + end + "ms");
    }
}
