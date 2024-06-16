package StringCalculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StringCalculatorTest {

    @Test
    public void testAddEmptyString() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void testAddSingleNumber() {
        assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void testAddTwoNumbers() {
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    public void testAddMultipleNumbers() {
        assertEquals(6, StringCalculator.add("1,2,3"));
    }

    @Test
    public void testAddWithNewline() {
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void testAddWithCustomDelimiter() {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    public void testAddNegativeNumbers() {
        try {
            StringCalculator.add("1,-2,3");
            fail("Exception expected for negative numbers");
        } catch (IllegalArgumentException e) {
            assertEquals("Negative numbers not allowed: [-2]", e.getMessage());
        }
    }

    @Test
    public void testAddMultipleNegativeNumbers() {
        try {
            StringCalculator.add("1,-2,-3");
            fail("Exception expected for negative numbers");
        } catch (IllegalArgumentException e) {
            assertEquals("Negative numbers not allowed: [-2, -3]", e.getMessage());
        }
    }
}
