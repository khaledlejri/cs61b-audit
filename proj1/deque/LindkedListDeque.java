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

//
//    public itemType remove(ItemType x){}
//
//    public itemType getRecursive(int index)
//    public int size(){}


}
