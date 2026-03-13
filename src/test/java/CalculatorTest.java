import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator c = new Calculator();
        // This expects 5, but our Calculator currently returns 0
        assertEquals(5, c.add(2, 3));
    }
}