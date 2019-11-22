package collections.ArrayListTest;

import collections.impl.BinarySearchTree;
import collections.impl.HashMap;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class HashMapTast {
    private HashMap<String, Integer> mapStringKey;
    private HashMap<Integer, Integer> mapIntegerKey;

    @Before
    public void init(){
        mapStringKey = new HashMap();
        mapIntegerKey = new HashMap<>();
    }

    @Test
    public void insertTreeStringKeyElementTest(){
        mapStringKey.insert("abc", 1);
        mapStringKey.insert("def", 2);
        mapStringKey.insert("egk", 3);

        assertEquals(java.util.Optional.of(1), java.util.Optional.of(mapStringKey.get("abc")));
        assertEquals(java.util.Optional.of(2), java.util.Optional.of(mapStringKey.get("def")));
        assertEquals(java.util.Optional.of(3), java.util.Optional.of(mapStringKey.get("egk")));
        assertEquals(java.util.Optional.of(3), java.util.Optional.of(mapStringKey.getSize()));
    }

    @Test
    public void insertTreeIntegerKeyElementTest(){
        mapIntegerKey.insert(1, 1);
        mapIntegerKey.insert(2, 2);
        mapIntegerKey.insert(3, 3);

        assertEquals(java.util.Optional.of(1), java.util.Optional.of(mapIntegerKey.get(1)));
        assertEquals(java.util.Optional.of(2), java.util.Optional.of(mapIntegerKey.get(2)));
        assertEquals(java.util.Optional.of(3), java.util.Optional.of(mapIntegerKey.get(3)));
        assertEquals(java.util.Optional.of(3), java.util.Optional.of(mapIntegerKey.getSize()));
    }

    @Test
    public void insertSeventeenStringKeyElementTest(){
        /*
        * Если довавляется новое значение хэш ключа которого (hash & capacity - 1)
        * равно хэшу ключа другого значения, которое уже было добавлено в словарь,
        * то старое значение перезатирается новым. (Не смог придумать, как реализовать
        * иначе без рассмотрения случаев, когда происходят коллизии.)
        */
        mapStringKey.insert("q", 10);
        mapStringKey.insert("w", 11);
        mapStringKey.insert("e", 12);
        mapStringKey.insert("r", 13);
        mapStringKey.insert("t", 14);
        mapStringKey.insert("y", 15);
        mapStringKey.insert("u", 16);
        mapStringKey.insert("i", 17);
        mapStringKey.insert("o", 18);
        mapStringKey.insert("p", 19);
        mapStringKey.insert("a", 20);
        mapStringKey.insert("s", 21);
        mapStringKey.insert("d", 22);
        mapStringKey.insert("f", 23);
        mapStringKey.insert("g", 24);
        mapStringKey.insert("h", 25);
        mapStringKey.insert("j", 26);
        assertEquals(java.util.Optional.of(26), java.util.Optional.of((mapStringKey.get("j"))));
        assertEquals(java.util.Optional.of(25), java.util.Optional.of((mapStringKey.get("h"))));
        assertEquals(java.util.Optional.of(24), java.util.Optional.of((mapStringKey.get("g"))));
        assertEquals(java.util.Optional.of(23), java.util.Optional.of((mapStringKey.get("f"))));
        assertEquals(java.util.Optional.of(22), java.util.Optional.of((mapStringKey.get("d"))));
        assertEquals(java.util.Optional.of(21), java.util.Optional.of((mapStringKey.get("s"))));
        assertEquals(java.util.Optional.of(20), java.util.Optional.of((mapStringKey.get("a"))));
        assertEquals(java.util.Optional.of(19), java.util.Optional.of((mapStringKey.get("p"))));
        assertEquals(java.util.Optional.of(18), java.util.Optional.of((mapStringKey.get("o"))));
        assertEquals(java.util.Optional.of(17), java.util.Optional.of((mapStringKey.get("i"))));
        assertEquals(java.util.Optional.of(16), java.util.Optional.of((mapStringKey.get("u"))));

        assertEquals(java.util.Optional.of(12), java.util.Optional.of((mapStringKey.getSize())));
        //Значения ключей y - q были перезатерты.
    }

    @Test
    public void deleteTest(){
        mapStringKey.insert("q", 10);
        mapStringKey.insert("w", 11);
        mapStringKey.insert("e", 12);
        mapStringKey.insert("r", 13);
        mapStringKey.insert("t", 14);
        mapStringKey.insert("y", 15);
        mapStringKey.insert("u", 16);
        mapStringKey.insert("i", 17);
        mapStringKey.insert("o", 18);
        mapStringKey.insert("p", 19);
        mapStringKey.insert("a", 20);
        mapStringKey.insert("s", 21);
        mapStringKey.insert("d", 22);
        mapStringKey.insert("f", 23);
        mapStringKey.insert("g", 24);
        mapStringKey.insert("h", 25);
        mapStringKey.insert("j", 26);

        mapStringKey.delete("q");
        assertEquals(java.util.Optional.of(11), java.util.Optional.of((mapStringKey.getSize())));
        mapStringKey.delete("w");
        assertEquals(java.util.Optional.of(10), java.util.Optional.of((mapStringKey.getSize())));
        mapStringKey.delete("e");
        assertEquals(java.util.Optional.of(9), java.util.Optional.of((mapStringKey.getSize())));
        mapStringKey.delete("r");
        assertEquals(java.util.Optional.of(8), java.util.Optional.of((mapStringKey.getSize())));
        mapStringKey.delete("t");
        assertEquals(java.util.Optional.of(7), java.util.Optional.of((mapStringKey.getSize())));
        mapStringKey.delete("y");
        assertEquals(java.util.Optional.of(6), java.util.Optional.of((mapStringKey.getSize())));
        mapStringKey.delete("o");
        assertEquals(java.util.Optional.of(5), java.util.Optional.of((mapStringKey.getSize())));
        mapStringKey.delete("f");
        assertEquals(java.util.Optional.of(4), java.util.Optional.of((mapStringKey.getSize())));
        mapStringKey.delete("h");
        assertEquals(java.util.Optional.of(3), java.util.Optional.of((mapStringKey.getSize())));
        mapStringKey.delete("j");
        assertEquals(java.util.Optional.of(2), java.util.Optional.of((mapStringKey.getSize())));
        mapStringKey.delete("p");
        assertEquals(java.util.Optional.of(1), java.util.Optional.of((mapStringKey.getSize())));
        mapStringKey.delete("s");
        assertEquals(java.util.Optional.of(0), java.util.Optional.of((mapStringKey.getSize())));


        mapStringKey.delete("s");
        assertEquals(java.util.Optional.of(0), java.util.Optional.of((mapStringKey.getSize())));
    }
}
