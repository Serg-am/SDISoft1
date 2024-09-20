import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


public class SinglyLinkedList<E extends Comparable<E>> {

    // Внутренний класс Node представляет элемент списка
    private static class Node<E> {
        E data;
        Node<E> next; 


        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> head;
    private int size;

    // Добавляем элемент в список
    public void add(E data) {
        // Проверка на null
        try {
            if (data == null) {
                throw new IllegalArgumentException("The null element cannot be added to the list");
            }

            Node<E> newNode = new Node<>(data);

            // Если список пуст новый узел становится головой
            if (head == null) {
                head = newNode;
            } else {
                // Иначе добавляем новый в конец
                Node<E> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }



    }

    // Находит N наибольших элементов в списке
    public List<E> findTopNElements(int n) {

        try {
            if (n <= 0) {
                throw new IllegalArgumentException("N must be a positive integer");
            }
            if (n > size) {
                throw new IllegalArgumentException("N cannot be greater than the list size");
            }

            // Используем для хранения N наибольших элементов
            PriorityQueue<E> minHeap = new PriorityQueue<>(n);
            Node<E> current = head;


            while (current != null) {
                if (minHeap.size() < n) {
                    // Если меньше N элементов добавляем текущий
                    minHeap.offer(current.data);
                } else if (current.data.compareTo(minHeap.peek()) > 0) {
                    // Если текущий элемент больше минимального
                    // удаляем минимальный и добавляем текущий
                    minHeap.poll();
                    minHeap.offer(current.data);
                }
                current = current.next;
            }

            // Преобразуем в список и сортируем по убыванию
            List<E> result = new ArrayList<>(minHeap);
            Collections.sort(result, Collections.reverseOrder());
            return result;
        }  catch (IllegalArgumentException e) {
            System.out.println("Exception while searching for N elements: " + e.getMessage());
            return Collections.emptyList();
        }
    }


    public void printList() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}