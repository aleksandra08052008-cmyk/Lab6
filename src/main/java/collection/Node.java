package collection;

/**
 * Вузол двозв'язного списку.
 *
 * @param <T> тип елементу
 */
class Node<T> {

    T data;
    Node<T> next;
    Node<T> previous;

    /**
     * Конструктор вузла.
     *
     * @param data значення вузла
     */
    Node(T data) {
        this.data = data;
    }
}
