import com.github.jenya705.hints.Hints;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HintsTest {

    @Test
    public void defaultTest() {
        assertEquals("ab", Arrays.asList("a", "b", "c", "aa", "ab"), Arrays.asList("ab"));
    }

    @Test
    public void manyHintsTest() {
        assertEquals("aaa", Arrays.asList("a", "b", "aa", "aab", "aac"), Arrays.asList("aa", "aab", "aac"));
    }

    @Test
    public void noHintsTest() {
        assertEquals("aaa", Arrays.asList("c", "t", "d"), Arrays.asList("c", "t", "d"));
    }

    public void assertEquals(String str, List<String> options, List<String> result) {
        List<String> newResult = new ArrayList<>();
        newResult.addAll(result);
        assertEquals(newResult, Hints.getHints(str, options));
    }

    public void assertEquals(List<String> expected, List<String> real) {

        if (expected.size() != real.size()) Assert.assertEquals(expected, real);

        boolean[] equalsElements = new boolean[expected.size()];
        Arrays.fill(equalsElements, true);
        for (int i = 0; i < equalsElements.length; ++i) {
            if (real.contains(expected.get(i))) equalsElements[i] = false;
        }

        Assert.assertTrue(Arrays.equals(equalsElements, new boolean[equalsElements.length]));

    }

}
