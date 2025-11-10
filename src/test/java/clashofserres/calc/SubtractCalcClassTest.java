package clashofserres.calc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubtractCalcClassTest {

    // Test 4: Standard Subtraction (10.0 - 4.0 = 6.0)
    @Test
    void testStandardSubtraction() {
        SubtractCalcClass calculator = new SubtractCalcClass();
        double result = calculator.calculate(10.0, 4.0);
        assertEquals(6.0, result, "10.0 - 4.0 should be 6.0");
    }

    // Test 5: Negative Result (4.0 - 10.0 = -6.0)
    @Test
    void testNegativeResult() {
        SubtractCalcClass calculator = new SubtractCalcClass();
        double result = calculator.calculate(4.0, 10.0);
        assertEquals(-6.0, result, "4.0 - 10.0 should be -6.0");
    }

    // Test 6: Subtracting a Negative Number (5.0 - (-2.0) = 7.0)
    @Test
    void testSubtractingNegative() {
        SubtractCalcClass calculator = new SubtractCalcClass();
        double result = calculator.calculate(5.0, -2.0);
        assertEquals(7.0, result, "5.0 - (-2.0) should be 7.0");
    }
}