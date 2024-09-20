package deque;

public class LindkedListDeque<ItemType> {
    private int size;
    private IntNode sentinel;

    public LindkedListDeque(){
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

    //public ItemType get(int index){}

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

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

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

    //    public itemType remove(ItemType x){}
//
//    public void printDeque(){}
//    public ItemType removeFirst(){}
//    public ItemType removeLast(){}
//    public ItemType get(){}
//    public Iterator<ItemType> iterator(){}
//    public boolean equals(Object o){}
//    public itemType getRecursive(int index)



}
