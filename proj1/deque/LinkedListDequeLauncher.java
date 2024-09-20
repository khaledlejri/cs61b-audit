package deque;

public class LinkedListDequeLauncher {
    public static void main(String[] args){
        LindkedListDeque<String> s1 = new LindkedListDeque<>();
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

    }
}
