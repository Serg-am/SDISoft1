import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


public class SinglyLinkedList<E extends Comparable<E>> implements Iterable<E> {

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
    }

    // Добавляет элемент в начало списка
    public void addFirst(E data) {
        if (data == null) {
            throw new NullPointerException("The null element cannot be added to the list");
        }
        Node<E> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public Stream<E> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Получить значение по индексу
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Удалить
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }

        size--;
    }

    // Удалить все из списка
    public void removeAll() {
        head = null;
        size = 0;
    }

    // Преобразует список в массив
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (E e : this) {
            result[i++] = e;
        }
        return result;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public Spliterator<E> spliterator() {
        return Spliterators.spliteratorUnknownSize(iterator(), Spliterator.ORDERED);
    }

    @Override
    public String toString() {
        return stream().map(Object::toString).collect(Collectors.joining(", ", "[", "]"));
    }

}