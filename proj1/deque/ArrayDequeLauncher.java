package deque;

public class ArrayDequeLauncher {
    public static void main(String[] args){
        // Create an ArrayDeque of Integers
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        System.out.println("Adding elements to the back:");
        for (int i = 1; i <= 10; i++) {
            deque.addLast(i);
            deque.printDeque();
        }

        System.out.println("\nAdding elements to the front:");
        for (int i = 100; i < 105; i++) {
            deque.addFirst(i);
            deque.printDeque();
        }

        System.out.println("\nRemoving elements from the front:");
        for (int i = 0; i < 3; i++) {
            Integer removed = deque.removeFirst();
            System.out.println("Removed: " + removed);
            deque.printDeque();
        }

        System.out.println("\nRemoving elements from the back:");
        for (int i = 0; i < 3; i++) {
            Integer removed = deque.removeLast();
            System.out.println("Removed: " + removed);
            deque.printDeque();
        }

        System.out.println("\nAccessing elements using get():");
        for (int i = 0; i < deque.size(); i++) {
            System.out.println("Element at index " + i + ": " + deque.get(i));
        }

        System.out.println("\nFinal deque size: " + deque.size());
        deque.printDeque();
    }
}
