package clashofserres.calc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ModCalcClassTest {

    // Test: Standard Modulo (10 % 3 = 1)
    @Test
    void testStandardModulo() {
        ModCalcClass calculator = new ModCalcClass();
        assertEquals(1.0, calculator.calculate(10.0, 3.0), "10 % 3 should be 1.0");
    }

    // Test: Modulo by Zero (Expected: ArithmeticException)
    @Test
    void testModuloByZero_ThrowsException() {
        ModCalcClass calculator = new ModCalcClass();

        // Assert that calling calculate(a, 0.0) throws ArithmeticException
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(10.0, 0.0);
        }, "Modulo by zero must throw ArithmeticException");
    }

    // Test: Negative Modulo (Expected: -1.0 in Java: -10 % 3 = -1)
    @Test
    void testNegativeModulo() {
        ModCalcClass calculator = new ModCalcClass();
        assertEquals(-1.0, calculator.calculate(-10.0, 3.0), "-10 % 3 should be -1.0");
    }
}