package clashofserres.calc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SquareCalcClassTest {

    // Test: Root of Positive Number (Uses Math.sqrt(a))
    @Test
    void testPositiveRoot() {
        SquareCalcClass calculator = new SquareCalcClass();
        // The second operand (b) is ignored in this operation
        assertEquals(4.0, calculator.calculate(16.0, 5.0), "Square root of 16 should be 4.0");
    }

    // Test: Root of Zero
    @Test
    void testRootOfZero() {
        SquareCalcClass calculator = new SquareCalcClass();
        assertEquals(0.0, calculator.calculate(0.0, 1.0), "Square root of 0 should be 0.0");
    }

    // Test: Root of Negative Number (Expected: ArithmeticException)
    @Test
    void testNegativeRoot_ThrowsException() {
        SquareCalcClass calculator = new SquareCalcClass();

        // We assert that calling calculate with a negative 'a' throws an Exception
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(-9.0, 0.0);
        }, "Root of negative number must throw an Exception");
    }

    // Test: Root of Decimal
    @Test
    void testRootOfDecimal() {
        SquareCalcClass calculator = new SquareCalcClass();
        assertEquals(1.5, calculator.calculate(2.25, 0.0), "Square root of 2.25 should be 1.5");
    }
}