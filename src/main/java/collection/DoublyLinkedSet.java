package collection;

import java.util.*;

/**
 * Реалізація колекції Set на основі двозв'язного списку.
 *
 * @param <T> тип елементів колекції
 */
public class DoublyLinkedSet<T> implements Set<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Порожній конструктор.
     */
    public DoublyLinkedSet() {
    }

    /**
     * Конструктор з одним елементом.
     *
     * @param element елемент колекції
     */
    public DoublyLinkedSet(T element) {
        add(element);
    }

    /**
     * Конструктор зі стандартної колекції.
     *
     * @param collection колекція елементів
     */
    public DoublyLinkedSet(Collection<T> collection) {
        addAll(collection);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {

        Node<T> current = head;

        while (current != null) {

            if (Objects.equals(current.data, o)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<>() {

            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {

                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                T data = current.data;
                current = current.next;

                return data;
            }
        };
    }

    @Override
    public Object[] toArray() {

        Object[] array = new Object[size];

        int index = 0;

        for (T element : this) {
            array[index++] = element;
        }

        return array;
    }

    @Override
    public <E> E[] toArray(E[] array) {

        if (array.length < size) {
            array = Arrays.copyOf(array, size);
        }

        int index = 0;

        for (T element : this) {
            array[index++] = (E) element;
        }

        return array;
    }

    @Override
    public boolean add(T element) {

        if (contains(element)) {
            return false;
        }

        Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }

        size++;

        return true;
    }

    @Override
    public boolean remove(Object object) {

        Node<T> current = head;

        while (current != null) {

            if (Objects.equals(current.data, object)) {

                if (current.previous != null) {
                    current.previous.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.previous = current.previous;
                } else {
                    tail = current.previous;
                }

                size--;

                return true;
            }

            current = current.next;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {

        for (Object obj : collection) {

            if (!contains(obj)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {

        boolean modified = false;

        for (T element : collection) {

            if (add(element)) {
                modified = true;
            }
        }

        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {

        boolean modified = false;

        Iterator<T> iterator = iterator();

        while (iterator.hasNext()) {

            T element = iterator.next();

            if (!collection.contains(element)) {
                remove(element);
                modified = true;
            }
        }

        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {

        boolean modified = false;

        for (Object obj : collection) {

            if (remove(obj)) {
                modified = true;
            }
        }

        return modified;
    }

    @Override
    public void clear() {

        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder("[");
        Node<T> current = head;

        while (current != null) {

            builder.append(current.data);

            if (current.next != null) {
                builder.append(", ");
            }

            current = current.next;
        }

        builder.append("]");

        return builder.toString();
    }
}
