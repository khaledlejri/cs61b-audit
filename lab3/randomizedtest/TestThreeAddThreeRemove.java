package randomizedtest;
import org.junit.Test;
import org.junit.Assert;

public class TestThreeAddThreeRemove {
    @Test
    public void testAddAndRemove(){

        AListNoResizing<Integer> AListNoResize = new AListNoResizing<>();
        BuggyAList<Integer> BuggyList = new BuggyAList<>();
        for (int i = 0; i < 3; i += 1){
            AListNoResize.addLast(i);
            BuggyList.addLast(i);
        }
        for (int i = 0; i < 3; i += 1){
            Assert.assertEquals(AListNoResize.removeLast(),
                    BuggyList.removeLast());
        }
    }
}
