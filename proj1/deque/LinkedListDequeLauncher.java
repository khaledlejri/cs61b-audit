package deque;

public class LinkedListDequeLauncher {
    public static void main(String[] args){
        LinkedListDeque<String> s1 = new LinkedListDeque<>();
        s1.addFirst("Jack");
        s1.addFirst("John");
        s1.addLast("last1");
        s1.printDeque();
        s1.addLast("Last_real");
        s1.addFirst("First_real");
        s1.printDeque();
        String removed = s1.removeFirst();
        System.out.println(removed + " has been removed from the list");
        System.out.println(s1.get(2));
        System.out.println("current size is: " + s1.size());
        s1.printDeque();

        System.out.println("--------------------- testing equals ----------------------");
        LinkedListDeque<Integer> deque1 = new LinkedListDeque<>();
        LinkedListDeque<Integer> deque2 = new LinkedListDeque<>();

        deque1.addFirst(1);
        deque1.addLast(2);
        deque2.addFirst(1);
        deque2.addLast(2);

        // This works because equals is called on an instance of LinkedListDeque
        if (deque1.equals(deque2)) {
            System.out.println("The deques are equal.");
        } else {
            System.out.println("The deques are not equal.");
        }
        System.out.println(deque1.getRecursive(1));
    }
}
