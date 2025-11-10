package clashofserres.calc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the AddCalcClass.
 * This class verifies that the addition function works as expected.
 */
public class AddCalcClassTest {

    /**
     * Test case for standard addition of two positive numbers (5.0 + 3.0 = 8.0).
     */
    @Test
    void testStandardAddition() {
        AddCalcClass calculator = new AddCalcClass();

        double result = calculator.calculate(5.0, 3.0);

        // We use assertEquals(expected, actual, message)
        assertEquals(8.0, result, "5.0 + 3.0 should equal 8.0");
    }




    // Test for addition with a negative number
    @Test
    void testAdditionWithNegativeNumber() {
        AddCalcClass calculator = new AddCalcClass();
        // GIVEN
        double result = calculator.calculate(-5.0, 3.0);
        // THEN: -5.0 + 3.0 should be -2.0
        assertEquals(-2.0, result, "Adding a negative number should yield -2.0");
    }

    // Test for addition with zero
    @Test
    void testAdditionWithZero() {
        AddCalcClass calculator = new AddCalcClass();
        // GIVEN
        double result = calculator.calculate(10.0, 0.0);
        // THEN: 10.0 + 0.0 should be 10.0
        assertEquals(10.0, result, "Adding zero should return the original number");
    }
}