package clashofserres.calc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerCalcClassTest {

    // Test: Standard Power (3^2 = 9)
    @Test
    void testStandardPower() {
        PowerCalcClass calculator = new PowerCalcClass();
        assertEquals(9.0, calculator.calculate(3.0, 2.0), "3^2 should be 9.0");
    }

    // Test: Power of Zero Exponent (10^0 = 1)
    @Test
    void testZeroExponent() {
        PowerCalcClass calculator = new PowerCalcClass();
        assertEquals(1.0, calculator.calculate(10.0, 0.0), "Any number to the power of 0 should be 1.0");
    }

    // Test: Negative Exponent (2^-3 = 0.125)
    @Test
    void testNegativeExponent() {
        PowerCalcClass calculator = new PowerCalcClass();
        assertEquals(0.125, calculator.calculate(2.0, -3.0), "2^-3 should be 0.125");
    }

    // Test: Zero Base (0^5 = 0)
    @Test
    void testZeroBase() {
        PowerCalcClass calculator = new PowerCalcClass();
        assertEquals(0.0, calculator.calculate(0.0, 5.0), "0^5 should be 0.0");
    }
}