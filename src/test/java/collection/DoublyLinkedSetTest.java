package collection;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class DoublyLinkedSetTest {

    @Test
    void testAdd() {

        DoublyLinkedSet<Integer> set =
                new DoublyLinkedSet<>();

        assertTrue(set.add(1));
        assertFalse(set.add(1));

        assertEquals(1, set.size());
    }

    @Test
    void testRemove() {

        DoublyLinkedSet<Integer> set =
                new DoublyLinkedSet<>();

        set.add(10);

        assertTrue(set.remove(10));
        assertFalse(set.contains(10));
    }

    @Test
    void testContains() {

        DoublyLinkedSet<String> set =
                new DoublyLinkedSet<>();

        set.add("Java");

        assertTrue(set.contains("Java"));
    }

    @Test
    void testConstructorCollection() {

        DoublyLinkedSet<Integer> set =
                new DoublyLinkedSet<>(List.of(1, 2, 2, 3));

        assertEquals(3, set.size());
    }

    @Test
    void testClear() {

        DoublyLinkedSet<Integer> set =
                new DoublyLinkedSet<>();

        set.add(1);
        set.add(2);

        set.clear();

        assertTrue(set.isEmpty());
    }
}
