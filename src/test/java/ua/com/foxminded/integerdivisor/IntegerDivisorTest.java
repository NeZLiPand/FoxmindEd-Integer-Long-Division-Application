package ua.com.foxminded.integerdivisor;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class IntegerDivisorTest {
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int ZERO = 0;

    @Test
    void testValidateValues_shouldReturnIllegalArgumentException_whenInputFirstNumberContainOneAndSecondNumberContainZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            IntegerDivisor integerDivisor = new IntegerDivisor(ONE, ZERO);
        });
    }
    
    @Test
    void testValidateValues_shouldReturnIllegalArgumentException_whenInputFirstNumberContainZeroAndSecondNumberContainOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            IntegerDivisor integerDivisor = new IntegerDivisor(ZERO, ONE);
        });
    }

    @Test
    void testValidateValues_shouldReturnIllegalArgumentException_whenInputFirstNumberContainOneAndSecondNumberContainNegativeOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            IntegerDivisor integerDivisor = new IntegerDivisor(ONE, -ONE);
        });
    }
    
    @Test
    void testValidateValues_shouldReturnIllegalArgumentException_whenInputFirstNumberContainNegativeOneAndSecondNumberContainOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            IntegerDivisor integerDivisor = new IntegerDivisor(-ONE, ONE);
        });
    }

    @Test
    void testValidateValues_shouldReturnIllegalArgumentException_whenInputDividendLessThanDivider() {
        assertThrows(IllegalArgumentException.class, () -> {
            IntegerDivisor integerDivisor = new IntegerDivisor(ONE, TWO);
        });
    }
}
