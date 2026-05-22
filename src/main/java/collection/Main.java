package collection;

import java.util.List;


public class Main {

    public static void main(String[] args) {

        DoublyLinkedSet<Integer> set1 = new DoublyLinkedSet<>();

        set1.add(10);
        set1.add(20);
        set1.add(10);

        System.out.println("Set1: " + set1);

        DoublyLinkedSet<String> set2 =
                new DoublyLinkedSet<>("Java");

        System.out.println("Set2: " + set2);

        DoublyLinkedSet<Integer> set3 =
                new DoublyLinkedSet<>(List.of(1, 2, 3, 4, 4));

        System.out.println("Set3: " + set3);

        set3.remove(2);

        System.out.println("After remove: " + set3);

        System.out.println("Contains 3: " + set3.contains(3));

        System.out.println("Size: " + set3.size());
    }
}
