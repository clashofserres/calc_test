package clashofserres.calc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultCalcClassTest {

    // Test: Standard Multiplication (5.0 * 6.0 = 30.0)
    @Test
    void testStandardMultiplication() {
        MultCalcClass calculator = new MultCalcClass();
        double result = calculator.calculate(5.0, 6.0);
        assertEquals(30.0, result, "5.0 * 6.0 should be 30.0");
    }

    // Test: Multiplication with a Negative Number (-5.0 * 6.0 = -30.0)
    @Test
    void testMultiplicationWithNegative() {
        MultCalcClass calculator = new MultCalcClass();
        double result = calculator.calculate(-5.0, 6.0);
        assertEquals(-30.0, result, "-5.0 * 6.0 should be -30.0");
    }

    // Test: Multiplication by Zero (100.0 * 0.0 = 0.0)
    @Test
    void testMultiplicationByZero() {
        MultCalcClass calculator = new MultCalcClass();
        double result = calculator.calculate(100.0, 0.0);
        assertEquals(0.0, result, "100.0 * 0.0 should be 0.0");
    }
}