package group;


import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BullsnCowsTest {

    @Test
    public void testTrue() {
        Assert.assertEquals(BullsCows.checkWord("java","java"), true);
        Assert.assertEquals(BullsCows.checkWord("pepega","pepega"), true);
        Assert.assertEquals(BullsCows.checkWord("kekw","kekw"), true);

    }

    @Test
    public void testFalse() {
        Assert.assertEquals(BullsCows.checkWord("java","lava"), false);
        Assert.assertEquals(BullsCows.checkWord("fish","kekl"), false);
        Assert.assertEquals(BullsCows.checkWord("java","vaav"), false);
    }
}