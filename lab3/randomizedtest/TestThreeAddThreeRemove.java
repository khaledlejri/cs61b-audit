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
//        AListNoResizing<Integer> correct = new AListNoResizing<>();
//        BuggyAList<Integer> broken = new BuggyAList<>();
//
//        correct.addLast(5);
//        correct.addLast(10);
//        correct.addLast(15);
//
//        broken.addLast(5);
//        broken.addLast(10);
//        broken.addLast(15);
//
//        Assert.assertEquals(correct.size(), broken.size());
//
//        Assert.assertEquals(correct.removeLast(), broken.removeLast());
//        Assert.assertEquals(correct.removeLast(), broken.removeLast());
//        Assert.assertEquals(correct.removeLast(), broken.removeLast());
    }
}
