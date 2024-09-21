import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class SinglyLinkedListTest {

    private final SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

    @Test
    void testAddSize() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        list.add(1);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());

        list.add(2);
        assertEquals(2, list.size());
    }

    @Test
    void testAddFirst() {
        list.addFirst(1);
        assertEquals(1, list.get(0));

        list.addFirst(2);
        assertEquals(2, list.get(0));
        assertEquals(1, list.get(1));
    }

    @Test
    void testGet() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(1);
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(2));
    }

    @Test
    void testRemoveAll() {
        list.add(1);
        list.add(2);

        list.removeAll();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void testToArray() {
        list.add(1);
        list.add(2);
        list.add(3);

        Object[] array = list.toArray();
        assertEquals(3, array.length);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
    }

    @Test
    void testAddNull() {
        assertThrows(IllegalArgumentException.class, () -> list.add(null));
        assertEquals(0, list.size());
    }

}