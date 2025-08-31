package deque;

public class LinkedListDeque<ItemType> {
    private int size;
    private IntNode sentinel;

    public LinkedListDeque(){
        size = 0;
        sentinel = new IntNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    // inner class to represent nodes in the deque
    private class IntNode{
        public ItemType item;
        public IntNode prev;
        public IntNode next;

        public IntNode(ItemType i, IntNode p, IntNode n){
            item = i;
            prev = p;
            next = n;
        }
    }

    /** Adds a first item to the deque,
     *  Differentiates between having empty deque and not so we can keep the circular sentinel.  */
    public void addFirst(ItemType x){
        IntNode newNode = new IntNode(x, sentinel, sentinel.next);
        if(size == 0){
            sentinel.prev = sentinel.next = newNode;
        } else {
            sentinel.next = newNode;
            sentinel.next.next.prev = newNode;
        }
        size += 1;
    }

    /** Adds a last element to the deque. */
    public void addLast(ItemType x){
        IntNode newNode = new IntNode(x, sentinel.prev, sentinel);
        if(size == 0) {
            sentinel.prev = sentinel.next = newNode;
        } else {
            sentinel.prev.next = newNode;
            sentinel.prev = newNode;
        }
        size += 1;
    }

    /** Checks if the Deque is empty */
    public boolean isEmpty(){
        return size == 0;
    }

    /** Returns the size of the Deque */
    public int size(){
        return size;
    }

    /** Prints the Deque items in one line separating each with a space  */
    public void printDeque(){
        IntNode p = sentinel;
        int dequeSize = size();
        if(dequeSize == 0){
            System.out.println("no elements in the deque");
        }
        while(p.next.item != null){
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println();

    }

    /** Removes the first node in the Deque */
    public ItemType removeFirst(){
        if(size() != 0){
            IntNode p = sentinel.next;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return p.item;
        } else {
            return null;
        }
    }

    /** Removes the last node in a Deque */
    public ItemType removeLast(){
        if(size() != 0){
            IntNode p = sentinel.prev;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return p.item;
        } else {
            return null;
        }
    }

    /** Gets an item iteratively */
    public ItemType get(int x) {
        int dequeSize = size();
        if ((dequeSize == 0) || (x > dequeSize)) {
            return null;
        }
        IntNode p = sentinel.next;
        int counter = 0;
        while (true) {
            if (counter < x) {
                p = p.next;
                counter += 1;
            } else {
                return p.item;
            }
        }
    }
    /** Checks if an object is equal to the current Deque */
    public boolean equals(Object o){
        // check if they are the same object
        if(this == o){
            return true;
        }
        // if they are not the same object
        // check if "o" is also an instance of the class LinkedListDeque
        if(!(o instanceof LinkedListDeque)){
            return false;
        }
        // we need to typecast to LinkedLIstDeque to be able to access its class methods
        LinkedListDeque<?> that = (LinkedListDeque<?>) o;

        if(size() != that.size()){
            return false;
        }
        for(int i = 0; i < size(); i += 1){
            if(!get(i).equals(that.get(i))){
                return false;
            }
        }
        return true;

    }

    /** Gets an item recursively */
    public ItemType getRecursive(int index){
        return getRecursiveHelper(sentinel.next, index);
    }

    private ItemType getRecursiveHelper(IntNode next, int index) {
        if (index < 0 || index >= size || next == sentinel) {
            return null;
        }
        if (index == 0) {
            return next.item;
        }
        return getRecursiveHelper(next.next, index - 1);
    }

    //public Iterator<ItemType> iterator(){}

}
