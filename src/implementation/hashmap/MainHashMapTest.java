package implementation.hashmap;

public class MainHashMapTest {

    public static void main(String[] args) {
        var start = System.currentTimeMillis();
        HashMapStudy<Integer, String> map = new HashMapStudy<>();

        map.put(1, "first value");
        map.put(2, "asdf");
        map.put(1, "updated value");
        map.put(3, "131f1");
        map.put(4, "fasdf");
        map.put(1, "asdfd");
        System.out.println(map);
//        map.show();
//
//        String valueRemoved = map.remove(5);
//        System.out.println("Value removed: " + valueRemoved);
//        map.show();
//
//        var end = System.currentTimeMillis() - start;
//        System.out.println("Took " + end + "ms");
    }
}
