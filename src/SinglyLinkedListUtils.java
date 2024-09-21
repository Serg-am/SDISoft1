import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SinglyLinkedListUtils {

    // Находит N наибольших элементов в списке
    public static <E extends Comparable<E>> List<E> findTopNElements(SinglyLinkedList<E> list, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N must be a positive integer");
        }
        if (n > list.size()) {
            throw new IllegalArgumentException("N cannot be greater than the list size");
        }

        return list.stream()
                .sorted(Comparator.reverseOrder())
                .limit(n)
                .collect(Collectors.toList());
    }

    // Выводит в консоль список элементов
    public static <E extends Comparable<E>> void printList(SinglyLinkedList<E> list) {
        for (E element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}