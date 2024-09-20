public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        int N = 2;

        list.add(5);
        list.add(-2);
        list.add(-4);
        list.add(1);
        list.add(-3);
        list.add(-1);
        list.add(null);
        list.add(0);


        System.out.println("List:");
        list.printList();

        System.out.println("Size list: " + list.size());

        System.out.println(N + " largest elements:");
        System.out.println(list.findTopNElements(N));
    }
}