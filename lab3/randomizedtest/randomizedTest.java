package randomizedtest;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;


public class randomizedTest {
    @Test
    public void randomTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                broken.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeBroken = broken.size();
                assertEquals("Size mismatch", size, sizeBroken);
                System.out.println("size: " + size);
            } else if (operationNumber == 2) {
                if (L.size() == 0){
                    continue;
                }
                int last = L.getLast();
                int lastBroken = broken.getLast();
                assertEquals("getLast mismatch", last, lastBroken);
                System.out.println("last is: " + last);
            } else if (operationNumber == 3) {
                if (L.size() == 0){
                    continue;
                }
                int removedLast = L.removeLast();
                int removedLastBroken = broken.removeLast();
                assertEquals("removeLast mismatch", removedLast, removedLastBroken);
                System.out.println("removed last: " + removedLast);
            }
        }
    }
}
