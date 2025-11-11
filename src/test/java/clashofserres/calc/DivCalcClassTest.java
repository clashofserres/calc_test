package clashofserres.calc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DivCalcClassTest {

    // Test: Standard Division
    @Test
    void testStandardDivision() {
        DivCalcClass calculator = new DivCalcClass();
        assertEquals(5.0, calculator.calculate(10.0, 2.0), "10 / 2 should be 5.0");
    }

    // Test: Division by Zero (Expected: Positive Infinity)
    @Test
    void testDivisionByZero() {
        DivCalcClass calculator = new DivCalcClass();
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(10.0, 0.0);
        }, "Division by zero must throw an ArithmeticException");
    }

    // Test: Zero Divided by Zero (Expected: NaN)
    @Test
    void testZeroDividedByZero_ThrowsException() {
        DivCalcClass calculator = new DivCalcClass();

        // GIVEN-WHEN-THEN: Ελέγχουμε αν το 0/0 αντιμετωπίζεται με τον ίδιο τρόπο
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(0.0, 0.0);
        }, "0 / 0 must also throw an ArithmeticException based on the implementation choice");
    }
}