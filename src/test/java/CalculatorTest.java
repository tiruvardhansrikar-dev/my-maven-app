import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    
    // Refactor: Create a single instance to use across all tests
    Calculator c = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5, c.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(2, c.subtract(5, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals(15, c.multiply(3, 5));
    }

    // This test expects an exception to be thrown when dividing by zero
    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        c.divide(10, 0);
    }
}