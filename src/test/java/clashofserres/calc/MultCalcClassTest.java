package clashofserres.calc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultCalcClassTest {

    // Test 7: Standard Multiplication (5.0 * 6.0 = 30.0)
    @Test
    void testStandardMultiplication() {
        MultCalcClass calculator = new MultCalcClass();
        double result = calculator.calculate(5.0, 6.0);
        assertEquals(30.0, result, "5.0 * 6.0 should be 30.0");
    }

    // Test 8: Multiplication with a Negative Number (-5.0 * 6.0 = -30.0)
    @Test
    void testMultiplicationWithNegative() {
        MultCalcClass calculator = new MultCalcClass();
        double result = calculator.calculate(-5.0, 6.0);
        assertEquals(-30.0, result, "-5.0 * 6.0 should be -30.0");
    }

    // Test 9: Multiplication by Zero (100.0 * 0.0 = 0.0)
    @Test
    void testMultiplicationByZero() {
        MultCalcClass calculator = new MultCalcClass();
        double result = calculator.calculate(100.0, 0.0);
        assertEquals(0.0, result, "100.0 * 0.0 should be 0.0");
    }
}